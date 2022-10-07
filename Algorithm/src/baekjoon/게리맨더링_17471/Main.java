package baekjoon.게리맨더링_17471;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int N, min;
	static boolean[] select;
	static int[] parent;
	static Area[] areas;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		min = Integer.MAX_VALUE;
		areas = new Area[N+1];
		select = new boolean[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			int p = Integer.parseInt(st.nextToken());
			areas[i] = new Area(p);
		}
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			for (int j = 0; j < n; j++) {
				int c = Integer.parseInt(st.nextToken());
				areas[i].con.add(c);
			}
		}
		
		// 1. 구역 나누기
		subset(1);
		
		System.out.println(min == Integer.MAX_VALUE ? -1 : min);
	}
	
	static void subset(int srcIdx) {
		// 기저 조건
		if(srcIdx == N+1) {
			// complete code <= select 배열의 현재 상태
			// 두 구역으로 모두 나눠진다면
			if(valid()) {
				int sumA = 0;
				int sumB = 0;
				for (int i = 1; i <= N; i++) {
					if(select[i]) sumA += areas[i].population;
					else sumB += areas[i].population;
				}
				
				min = Math.min(min, Math.abs(sumA-sumB));
				
			}
			return;
		}
		select[srcIdx] = true; // 선택
		subset(srcIdx+1); // 다음 선택
		
		select[srcIdx] = false; // 선택
		subset(srcIdx+1); // 다음 선택
	}
	
	static boolean valid() {
		parent = new int[N+1];
		makeSet();
		for (int i = 1; i <= N; i++) {
			int size = areas[i].con.size();
			for (int j = 0; j < size; j++) {
				int city = areas[i].con.get(j);
				if(select[i] == select[city]) {
					union(i, city);
				}
			}
		}
		
		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			if(i == findSet(i)) cnt++;
		}
		if(cnt != 2) return false;
		
		return true;
	}
	
	// 서로소 집합 관련 메소드들
		static void makeSet() {
			for (int i = 1; i <= N; i++) {
				parent[i] = i;
			}
		}

		// 부모를 찾는(부모 번호 == 집합)
		static int findSet(int x) {
			if(parent[x] == x) return x;
			else return parent[x] = findSet(parent[x]);
		}
		
		static void union(int x, int y) {
			int px = findSet(x);
			int py = findSet(y);
			if(px < py) parent[py] = px;
			else parent[px] = py;
		}
	
	static class Area{
		int population;
		List<Integer> con = new ArrayList<>();
		
		Area(int population){
			this.population = population;
		}
	}
}
