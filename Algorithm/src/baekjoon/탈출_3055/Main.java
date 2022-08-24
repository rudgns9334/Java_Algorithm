package baekjoon.탈출_3055;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int R, C, ey, ex, max;
	static char[][] map;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	static Queue<Node> q = new ArrayDeque<>();
	static Queue<Node> sq = new ArrayDeque<>();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		max = 0;
		map = new char[R][];
		
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j] == 'D') {
					ey = i;
					ex = j;
				}
				else if(map[i][j] == 'S') {
					sq.offer(new Node(i,j,0));
				}
				else if(map[i][j] == '*') {
					q.offer(new Node(i,j,0));
				}
			}
		}
		
		
		
		
		

	}

	static void escape() {
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			int y = node.y;
			int x = node.x;
			
			for (int d = 0; d < 4; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];
				
				if(ny<0 || nx<0 || ny>=R || nx>=C) continue;
				if(map[ny][nx] == '.') {
					map[ny][nx] = '*';
					q.offer(new Node(ny, nx, node.t + 1));
				}
			}
			
			while(!sq.isEmpty()) {
				Node sn = sq.peek();
				if(sn.t == max) break;
				sn = sq.poll();
				int sy = sn.y;
				int sx = sn.x;
				
				for (int d = 0; d < 4; d++) {
					int nsy = sy + dy[d];
					int nsx = sx + dx[d];
					if(nsy == ey && nsx == ex) {
						System.out.println(max+1);
						return;
					}
					if(nsy<0 || nsx<0 || nsy>=R || nsx>=C) continue;
					if(map[nsy][nsx] == '.') {
						map[nsy][nsx] = '-';
						sq.offer(new Node(nsy, nsx, sn.t+1));
					}
				}
			}
			
			if(sq.isEmpty()) System.out.println("KAKTUS");
			
			
		}
		
	}
	
	static class Node{
		int y, x, t;
		public Node(int y, int x, int t) {
			this.y = y;
			this.x = x;
			this.t = t;
		}
	}
}
