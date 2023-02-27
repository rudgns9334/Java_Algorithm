package baekjoon.미네랄_2933;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int R,C,N,Y;
	static char[][] map;
	static int[] high;
	
	static PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> n2.y - n1.y);
	
	static boolean[][] visit;
					// 하 상 우 좌
	static int[] dy = {1, -1, 0, 0};
	static int[] dx = {0, 0, 1, -1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		N = Integer.parseInt(br.readLine());
		high = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			high[i] = Integer.parseInt(st.nextToken());
			start(i);
		}
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		
	}
	
	static void start(int cnt) {
		int y = R-high[cnt];
		pq.clear();
		if(cnt%2 == 0) {
			// 왼쪽에서 오른쪽으로 d = 3
			int x = -1;
			for (int i = 0; i < C; i++) {
				x = x + dx[2];
				if(map[y][x] == 'x') {
					map[y][x] = '.';
					if(check(y,x,1)) {
						gravity();
					}
					break;
				}
			}
		}else {
			// 오른쪽에서 왼쪽으로 d = 2
			int x = C;
			for (int i = 0; i < C; i++) {
				x = x + dx[3];
				if(map[y][x] == 'x') {
					map[y][x] = '.';
					if(check(y,x,2)) {
						gravity();
					}
					break;
				}
			}
		}
	}
	
	static boolean check(int y, int x, int type) {
		visit = new boolean[R][C];
//		System.out.println("y : " + y + " x : " + x);
		for (int i = 1; i < 4; i=i+type) {
			int ny = y + dy[i];
			int nx = x + dx[i];
//			System.out.println(i);
			if(ny<0 || nx<0 || ny>=R || nx>=C || visit[ny][nx]) continue;
			
//			System.out.println("inddd y : " + ny + " x : " + nx);
			if(map[ny][nx] == 'x') {
				
				if(dfs(ny,nx)) {
					return false;
				}else {
					return true;
				}
			}
		}
		return false;
	}
	
	static boolean dfs(int y, int x) {
		if(y == R-1) {
//			System.out.println("dfs in y : " + y + " x : " + x);
			return true;
		}
		pq.add(new Node(y,x));
		visit[y][x] = true;
		boolean ok = false;
		for (int i = 0; i < 4; i++) {
			if(ok) break;
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if(ny<0 || nx<0 || ny>=R || nx>=C || visit[ny][nx]) continue;
			if(map[ny][nx] == 'x') {
				ok = dfs(ny,nx);
			}
		}
		
		return ok;
	}
		
	static void gravity() {
		// 상 좌 우 만 체크
		int size = pq.size();
		
		int minH = R+1;
		Iterator<Node> its = pq.iterator();
//		System.out.println(size);
		// 최소 높이 차이 구하기
		while(its.hasNext()) {
			
			Node n = its.next();
			
			Y = n.y+1;
			if(map[Y][n.x] == 'x') continue;
			
			while(Y < R) {
				if(map[Y][n.x] == 'x') {
					if(pq.stream().noneMatch(nn -> (nn.x == n.x) && (nn.y == Y) )) {
						if(minH > Y - n.y) {
							
							minH = Y - n.y;
//							System.out.println("y : " + n.y + " x : " + n.x + " minH : " + minH );
						}
					}
					
					break;
				}
				if(Y == R-1) {
					if(minH > Y-n.y) {
						minH = Y - n.y + 1;
					}
				}
				Y++;
			}
			
		}
//		System.out.println(minH);
		// 옮기기
		for (int i = 0; i < size; i++) {
			Node n = pq.poll();
			map[n.y][n.x] = '.';
			map[n.y+minH-1][n.x] = 'x';
		}
		
		
	}
	
	static class Node{
		int y,x;
		
		public Node(int y, int x){
			this.y = y;
			this.x = x;
		}
	}
}
