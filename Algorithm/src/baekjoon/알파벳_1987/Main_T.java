package baekjoon.알파벳_1987;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_T {

	static int R, C, max;
	static char[][] map;
	static boolean[] visit = new boolean[26]; // 알파벳 수
	
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][];
		
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		max = Integer.MIN_VALUE;
		
		dfs(0, 0, 1);
		
		System.out.println(max);
	}

	// 좌표를 방문하면(알파벳)
	// 방문할 때 마다 max 확인
	static void dfs(int y, int x, int cnt) {
		max = Math.max(max, cnt);
		visit[map[y][x]-'A'] = true;
		
		// 다음 방문이 가능하면 다시 방문
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if(ny < 0 || nx < 0 || ny >= R || nx >= C || visit[map[ny][nx]-'A']) continue;
			dfs(ny, nx, cnt+1);
			
		}
		// visit 원복
		visit[map[y][x]-'A'] = false;
	}
}
