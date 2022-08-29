package baekjoon.탈출_3055;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int R, C, max;
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
		max = Integer.MAX_VALUE;
		map = new char[R][];
		
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j] == 'S') {
					sq.offer(new Node(i,j,0));
				}
				else if(map[i][j] == '*') {
					q.offer(new Node(i,j,0));
				}
			}
		}
		
		escape();
		
		System.out.println(max == Integer.MAX_VALUE ? "KAKTUS" : max );
	}

	static void escape() {
		
		while(!sq.isEmpty()) {
			int waterSize = q.size();
			for (int i = 0; i < waterSize; i++) {
				Node node = q.poll();
				for (int d = 0; d < 4; d++) {
					int ny = node.y + dy[d];
					int nx = node.x + dx[d];
					
					if(ny<0 || nx<0 || ny>=R || nx>=C) continue;
					if(map[ny][nx] == '.') {
						map[ny][nx] = '*';
						q.offer(new Node(ny, nx, node.t + 1));
					}
				}
			}
			int goSize = sq.size();
			for (int i = 0; i < goSize; i++) {
				Node node = sq.poll();
				for (int d = 0; d < 4; d++) {
					int ny = node.y + dy[d];
					int nx = node.x + dx[d];
					if(ny<0 || nx<0 || ny>=R || nx>=C) continue;
					if( map[ny][nx] == 'D') { // 목적지 도달
	                    max = Math.min(max, node.t + 1 );
	                    return; // 바로 종료
	                }else if( map[ny][nx] == '.') {                
	                    map[ny][nx] = 'S';
	                    sq.offer(new Node(ny, nx, node.t + 1)); // 다음 번 방문할 고슴도치  
	                }
				}
			}
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
