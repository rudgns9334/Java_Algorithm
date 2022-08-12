package baekjoon.치킨배달_15686;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_T {

	static int N, M, min;
	static List<int[]> house, src, tgt;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		house = new ArrayList<>();
		src = new ArrayList<>();
		tgt = new ArrayList<>();
		min = Integer.MAX_VALUE;
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int n = Integer.parseInt(st.nextToken());
				if(n==1) house.add(new int[] {i, j});
				if(n==2) src.add(new int[] {i,j});
			}
		}
		
		comb(0,0);
		
		System.out.println(min);
	}

	static void comb(int srcIdx, int tgtIdx) {
		// 기저 조건
		if( tgtIdx == M ) {
			// complete code
			// 현재 치킨집 조합을 기준으로 모든 집에서 최단거리 치킨집을 계산해서 모두 더한다. => 그 합의 최소값 선택
			
			int sum = 0; // 치킨 거리의 합
			int size = house.size();
			for (int i = 0; i < size; i++) {
				int  dist = Integer.MAX_VALUE;
				int[] h = house.get(i);
				for (int j = 0; j < M; j++) {
					int[] c = tgt.get(j);
					
					dist = Math.min(dist, Math.abs(h[0]-c[0]) + Math.abs(h[1]-c[1]));
				}
				sum += dist; // 현재 M개 선택의 치킨 거리의 누적합
			}
			// 최소값
			min = Math.min(min, sum);
			
			return;
		}
		
		if(srcIdx==src.size()) return;
		
		tgt.add(src.get(srcIdx));
		
		comb(srcIdx+1, tgtIdx+1);
		tgt.remove(src.get(srcIdx));
		comb(srcIdx+1, tgtIdx);
	}
}
