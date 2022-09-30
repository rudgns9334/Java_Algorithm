package baekjoon.말이되고픈원숭이_1600;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int K, W, H, ans;
	static int[][] map;
	static boolean[][][] visit;
	
	static int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1, -1, 1, 0, 0};
	static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2, 0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		K = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		ans = -1;
		
		map = new int[H][W];
		visit = new boolean[H][W][K+1];
		
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		bfs();
		
		System.out.println(ans);
	}
	
	static void bfs() {
		Queue<Node> q = new ArrayDeque<>();
		visit[0][0][K] = true;
		q.add(new Node(0,0,0,K));
		
		while(!q.isEmpty()) {
			Node n = q.poll();
			if(n.y == H-1 && n.x == W-1) {
				ans = n.cnt;
				return;
			}
			
			if(n.k != 0) {
				for (int i = 0; i < 8; i++) {
					int ny = n.y + dy[i];
					int nx = n.x + dx[i];
					if(ny < 0 || nx < 0 || ny >= H || nx >= W || visit[ny][nx][n.k-1]) continue;
					if(map[ny][nx] != 1) {
						visit[ny][nx][n.k-1] = true;
						q.add(new Node(ny, nx, n.cnt+1, n.k-1));
					}
				}
			}
			for (int i = 8; i < 12; i++) {
				int ny = n.y + dy[i];
				int nx = n.x + dx[i];
				if(ny < 0 || nx < 0 || ny >= H || nx >= W || visit[ny][nx][n.k]) continue;
				if(map[ny][nx] != 1) {
					visit[ny][nx][n.k] = true;
					q.add(new Node(ny, nx, n.cnt+1, n.k));
				}
			}
		}
		
	}
	
	static class Node{
		int y,x,cnt,k;

		public Node(int y, int x, int cnt, int k) {
			this.y = y;
			this.x = x;
			this.cnt = cnt;
			this.k = k;
		}
	}
}
