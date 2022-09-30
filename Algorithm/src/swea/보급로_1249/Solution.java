package swea.보급로_1249;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Solution {

	static int T, N;
	static int[][] map;
	static int[][] dp;
	static int INF = 987654321;
	static PriorityQueue<Node> pq;
	
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			dp = new int[N][N];
			
			pq = new PriorityQueue<>((n1, n2) -> n1.w - n2.w);
			for (int i = 0; i < N; i++) {
				char[] c = br.readLine().toCharArray();
				for (int j = 0; j < N; j++) {
					map[i][j] = c[j]-'0';
					dp[i][j] = INF;
				}
			}
			
			dp[0][0] = 0;
			pq.add(new Node(0,0,0));
			while(!pq.isEmpty()) {
				Node n = pq.poll();
				if(dp[n.y][n.x] < n.w) continue;
				
				for (int i = 0; i < 4; i++) {
					int ny = n.y + dy[i];
					int nx = n.x + dx[i];
					
					if(ny<0 || nx<0 || ny>=N || nx>=N) continue;
					if(dp[ny][nx] > n.w + map[ny][nx]) {
						dp[ny][nx] = n.w + map[ny][nx];
						pq.add(new Node(ny, nx, dp[ny][nx]));
					}
				}
			}
			
			System.out.println("#" + t + " " + dp[N-1][N-1]);
			
			
			
			
		}

	}
	static class Node{
		int y,x,w;

		public Node(int y, int x, int w) {
			this.y = y;
			this.x = x;
			this.w = w;
		}
	}

}
