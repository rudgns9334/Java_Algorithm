package baekjoon.치킨배달_15686;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N, M, ans;
	static int[][] map,chicken;
	static List<Node> house = new ArrayList<>();
	static List<Node> store = new ArrayList<>();
	static List<Node> tgt = new ArrayList<>();
	static boolean[] select;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][N+1];
		ans = Integer.MAX_VALUE;
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==1) house.add(new Node(i,j));
				if(map[i][j]==2) store.add(new Node(i,j));
			}
		}
		
		select = new boolean[store.size()];
		
		comb(0,0);
		
		System.out.println(ans);
	}
	
	static void comb(int srcIdx, int tgtIdx) {
		if(tgtIdx == M) { //... 치킨집을 기준잡냐 하우스를 기준잡냐에 따라 메모리차이가 심하다.
			chicken = new int[N+1][N+1];
			for (int i = 1; i <= N; i++) {
				Arrays.fill(chicken[i], Integer.MAX_VALUE);
			}
			for (int i = 0; i < tgt.size(); i++) {
				calc(tgt.get(i));
			}
			int sum = chickenSum();
			ans = Math.min(ans, sum);
			return;
		}
		if(srcIdx==store.size()) return;
		
		tgt.add(store.get(srcIdx));
		
		comb(srcIdx+1, tgtIdx+1);
		tgt.remove(store.get(srcIdx));
		comb(srcIdx+1, tgtIdx);
	}
	
	// 선택된 치킨집과의 거리 계산
	static void calc(Node node) {
		int ey = node.y;
		int ex = node.x;
		for(int i=0;i<house.size();i++) {
			int y = house.get(i).y;
			int x = house.get(i).x;

			chicken[y][x] = Math.min(chicken[y][x], Math.abs(y-ey) + Math.abs(x-ex));
		}
	}
	
	static int chickenSum() {
		int sum = 0;
		for(int i=0;i<house.size();i++) {
			sum += chicken[house.get(i).y][house.get(i).x];
		}
		
		return sum;
	}
	
	static class Node{
		int y;
		int x;
		
		public Node(int y, int x){
			this.y = y;
			this.x = x;
		}
	}

}
