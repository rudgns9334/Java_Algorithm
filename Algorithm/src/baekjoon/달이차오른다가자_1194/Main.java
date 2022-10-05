package baekjoon.달이차오른다가자_1194;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, sy, sx, ans;
	static char[][] map;
	
	static boolean[][][] visit;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visit = new boolean[1 << 7][N][M];
		ans = Integer.MAX_VALUE;
		
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				if(map[i][j] == '0') {
					sy = i;
					sx = j;
				}
			}
		}
		
		bfs(sy, sx);
		
		System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
	}
	
	// a = 0, b = 1.... f = 5
	// 0 0 0 0 0 0
	// f e d c b a 
	static void bfs(int y, int x) {
		Queue<Node> q = new ArrayDeque<>();
		visit[0][y][x] = true;
		q.offer(new Node(y, x, 0, 0));
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			if(map[node.y][node.x] == '1') {
				ans = node.cnt;
				return;
			}
			
			for (int d = 0; d < 4; d++) {
				int ny = node.y + dy[d];
				int nx = node.x + dx[d];
				
				if(ny<0 || nx<0 || ny>=N || nx>=M || visit[node.key][ny][nx] || map[ny][nx] == '#') continue;
				if(map[ny][nx]>='a' && map[ny][nx]<='f') { // 열쇠를 먹는 경우
					int k = map[ny][nx]-'a';
					int newKey = node.key | (1 << k);
					visit[newKey][ny][nx] = true;
					q.offer(new Node(ny, nx, newKey, node.cnt+1));
				}
				else if(map[ny][nx]>='A' && map[ny][nx]<='F') {
					if((node.key & (1 << (map[ny][nx]-'A'))) != 0) { // 열쇠가 있으면
						visit[node.key][ny][nx] = true;
						q.offer(new Node(ny, nx, node.key, node.cnt+1));
					}
				}
				else {
					visit[node.key][ny][nx] = true;
					q.offer(new Node(ny, nx, node.key, node.cnt+1));
				}
			
			}
			
		}
		
	}
	
	static class Node{
		int y,x,key,cnt;
		
		Node(int y, int x, int key, int cnt){
			this.y = y;
			this.x = x;
			this.key = key;
			this.cnt = cnt;
		}
		
	}
}
