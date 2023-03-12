package baekjoon.내리막길_1520;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 먼가 시간초과긴하네...
public class Main2 {

	static int M, N, ans;
	
	static int[][] map;
	
	static boolean[][] visit;
	
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		ans = 0;
		
		map = new int[M+1][N+1];
		
		visit = new boolean[M+1][N+1];
		
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		bfs();
		
		System.out.println(ans);
		
	}
	
	static void bfs() {
		Queue<Node> q = new ArrayDeque<>();
		q.add(new Node(1,1));
		
		while(!q.isEmpty()) {
			Node n = q.poll();
			if(n.y == M && n.x == N) {
				ans++;
				continue;
			}
			
			for (int d = 0; d < 4; d++) {
				int ny = n.y + dy[d];
				int nx = n.x + dx[d];
				
				if(ny <= 0 || nx <= 0 || ny > M || nx > N) continue;
				
				if(map[n.y][n.x] > map[ny][nx]) {
					q.add(new Node(ny,nx));
				}
			}
		}
	}
	
	static class Node{
		int y,x;
		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	

}
