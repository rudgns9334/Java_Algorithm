package baekjoon.감시_15683;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N, M, wall, ans;
	static List<Node> cctv = new ArrayList<>();
	static int[][] map;
	
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		wall = 0;
		ans = N*M;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==6) wall++;
				else if(map[i][j]<6 && map[i][j]>0) cctv.add(new Node(i,j));
			}
		}
		
		findCCTV(0);

		System.out.println(ans);
	}
	
	static void findCCTV(int idx) {
		if(idx == cctv.size()) {
			
			return;
		}
		
		Node node = cctv.get(idx);
		switch(map[node.y][node.x]) {
		case 1 : No1(idx); break;
		case 2 : No2(idx); break;
		case 3 : No3(idx); break;
		case 4 : No4(idx); break;
		case 5 : No5(idx); break;
		}
	}
	
	static void No1(int idx) {
		
	}
	
	static void No2(int idx) {
			
	}
	
	static void No3(int idx) {
		
	}
	
	static void No4(int idx) {
		
	}
	
	static void No5(int idx) {
		
	}
	
	static class Node{
		int y;
		int x;
		
		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

}
