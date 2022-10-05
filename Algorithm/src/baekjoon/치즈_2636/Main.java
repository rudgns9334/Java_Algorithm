package baekjoon.치즈_2636;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N,M;
	static int[][] map;
	
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	static boolean[][] visit;
	
	static Queue<Node> cheeze = new ArrayDeque<>(); 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		bfs(0,0);
	}
	
	static void bfs(int y, int x) {
		Queue<Node> q = new ArrayDeque<>();
		int day = 0;
		int preSize = 0;
		while(true) {
			visit = new boolean[N][M];
			visit[y][x] = true;
			q.add(new Node(y, x));
			cheeze.clear();
			while(!q.isEmpty()) {
				Node n = q.poll();
				for (int d = 0; d < 4; d++) {
					int ny = n.y + dy[d];
					int nx = n.x + dx[d];
					if(ny<0 || nx<0 || ny>=N || nx>=M || visit[ny][nx]) continue;
					if(map[ny][nx] == 0) {
						visit[ny][nx] = true;
						q.add(new Node(ny, nx));
					}else {
						visit[ny][nx] = true;
						cheeze.add(new Node(ny, nx));
					}
				}
			}
			if(cheeze.isEmpty()) {
				System.out.println(day);
				System.out.println(preSize);
				return;
			}
			preSize = cheeze.size();
			day++;
			for (int i = 0; i < preSize; i++) {
				Node n = cheeze.poll();
				map[n.y][n.x] = 0;
			}
			
		}
		
	}
	
	static class Node{
		int y,x;
		Node(int y, int x){
			this.y = y;
			this.x = x;
		}
	}
}
