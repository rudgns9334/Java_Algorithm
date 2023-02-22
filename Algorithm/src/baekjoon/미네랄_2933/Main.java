package baekjoon.미네랄_2933;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int R,C,N, total;
	static char[][] map;
	static int[] high;
	
	static boolean[][] visit;
	
	static int[] dy = {1, -1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		total = 0;
		
		map = new char[R][C];
		
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				if(map[i][j] == 'X') {
					total++;
				}
				
			}
		}
		
		N = Integer.parseInt(br.readLine());
		high = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			high[i] = Integer.parseInt(st.nextToken());
			start(i);
		}
		
		
		
		
	}
	
	static void start(int cnt) {
		int y = R-high[cnt];
		
		if(cnt%2 == 0) {
			// 왼쪽에서 오른쪽으로 d = 3
			int x = -1;
			for (int i = 0; i < C; i++) {
				x = x + dx[3];
				if(map[y][x] == 'X') {
					map[y][x] = '.';
					total--;
					if(check()) {
						gravity(y,i);
					}
				}
			}
		}else {
			// 오른쪽에서 왼쪽으로 d = 2
			int x = C;
			for (int i = 0; i < C; i++) {
				x = x + dx[2];
				if(map[y][x] == 'X') {
					map[y][x] = '.';
					total--;
					if(check()) {
						gravity(y,i);
					}
				}
			}
		}
	}
	
	static boolean check() {
		visit = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j] == 'X' && !visit[i][j]) {
					int n = bfs(i,j);
					// 탐색 개수가 전체 개수와 같으면
					if(n == total) return false;
					// 같지 않으면
					else return true;
				}
			}
		}
		
		
		return true;
	}
	
	static int bfs(int y, int x) {
		
		int cnt = 1;
		
		visit[y][x] = true;
		Queue<Node> q = new ArrayDeque<>();
		q.add(new Node(y,x,1));
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			
			if(node.cnt > cnt) cnt = node.cnt;
			
			for (int d = 0; d < 4; d++) {
				int ny = node.y + dy[d];
				int nx = node.x + dx[d];
				
				if(ny<0 || nx<0 || ny>=R || nx>=C) continue;
				if(visit[ny][nx]) continue;
				if(map[ny][nx] == 'X') {
					visit[ny][nx] = true;
					q.add(new Node(ny, nx, node.cnt + 1));
				}
			}
		}
		
		return cnt;
	}
	
	static void gravity(int y, int x) {
		// 상 좌 우 만 체크
		int nnY = -1;
		int nnX = -1;
		for (int d = 1; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			if(ny<0 || nx<0 || ny>=R || nx>=C) continue;
			if(map[ny][nx] == 'X') {
				nnY = ny;
				nnX = nx;
				break;
			}
		}
		if(nnY == -1) {
			return;
		}
		
		
	}
	
	static class Node{
		int y,x,cnt;
		
		public Node(int y, int x, int cnt){
			this.y = y;
			this.x = x;
			this.cnt = cnt;
		}
	}
}
