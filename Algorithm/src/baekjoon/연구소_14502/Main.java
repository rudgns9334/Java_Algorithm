package baekjoon.연구소_14502;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, size, max;
	static int[][] map;
	static int[] tar = new int[3];
	static List<Node> list = new ArrayList<>();
	static List<Node> virus = new ArrayList<>();
	
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		max = Integer.MIN_VALUE;
		
		map = new int[N][M];
		
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int n = Integer.parseInt(st.nextToken());
				map[i][j] = n;
				if( n == 0 ) list.add(new Node(i, j));
				if( n == 2 ) virus.add(new Node(i, j));
			}
		}
		
		size = list.size(); // 총 안전 구역 수
		
		choice(0, 0);
		
		System.out.println(max);
		
	}
	
	static void choice(int n, int idx) {
		if( idx == 3 ) {
			build();
			return;
		}
		
		if( n == size ) {
			return;
		}
		
		tar[idx] = n;
		
		choice(n+1, idx+1);
		choice(n+1, idx);
	}
	
	static void build() {
		// 벽 먼저 세우기
		for (int i = 0; i < 3; i++) {
			int y = list.get(tar[i]).y;
			int x = list.get(tar[i]).x;
			
			map[y][x] = 1;
		}
		
		virusStart();
		
		// 세웠던 벽 허물기
		for (int i = 0; i < 3; i++) {
			int y = list.get(tar[i]).y;
			int x = list.get(tar[i]).x;
			
			map[y][x] = 0;
		}
	}
	
	static void virusStart() {
		Queue<Node> q = new ArrayDeque<>();
		boolean[][] visit = new boolean[N][M];
		int cnt = 0; // 감염되는 구역의 수
		
		for (int i = 0; i < virus.size(); i++) {
			Node n = virus.get(i);
			visit[n.y][n.x] = true;
			q.offer(n);
		}
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			
			for (int d = 0; d < 4; d++) {
				int ny = node.y + dy[d];
				int nx = node.x + dx[d];
				
				if( ny<0 || nx<0 || ny>=N || nx>=M || visit[ny][nx] ) continue;
				if( map[ny][nx] == 0 ) {
					visit[ny][nx] = true;
					cnt++;
					q.offer(new Node(ny, nx));
				}
			}
		}
		
		// 최대 안전 구역 수 비교
		max = Math.max(max, size - cnt - 3);
	}
	
	static class Node{
		int y,x;
		
		Node(int y, int x){
			this.y = y;
			this.x = x;
		}
	}
}
