package baekjoon.알파벳_1987;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_T3 {

	static int R, C, max;
	static int[][] map;
//	static boolean[] visit = new boolean[26]; // 알파벳 수
	
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	static Queue<Node> queue = new ArrayDeque<>();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		
		for (int i = 0; i < R; i++) {
			char[] temp = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				map[i][j] = temp[j]-'A';
			}
		}
		
		max = Integer.MIN_VALUE;
		bfs();
		
		System.out.println(max);
	}

	static void bfs() {
		queue.offer(new Node(0, 0, 1, 1 << map[0][0]));
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			max = Math.max(max, node.cnt);
			
			for (int i = 0; i < 4; i++) {
				int ny = node.y + dy[i];
				int nx = node.x + dx[i];
		
				if(ny < 0 || nx < 0 || ny >= R || nx >= C || (node.visit & 1 << map[ny][nx]) != 0) continue;
				queue.offer(new Node(ny, nx, node.cnt+1, node.visit | 1 << map[ny][nx]));	
			}
		}
	}
	
	static class Node{
		int y, x, cnt, visit;
		public Node(int y, int x, int cnt, int visit) {
			this.y = y;
			this.x = x;
			this.cnt = cnt;
			this.visit = visit;
		}
	}
}
