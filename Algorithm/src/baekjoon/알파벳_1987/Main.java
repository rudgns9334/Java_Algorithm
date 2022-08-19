package baekjoon.알파벳_1987;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int R, C, ans;
	static char[][] map;
	static boolean[] visit = new boolean[26];
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		ans = 0;
		
		map = new char[R][];
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		visit[map[0][0]-'A'] = true;
		dfs(0,0,1);
		
		
		

	}
	
	static void dfs(int y, int x, int cnt) {
		ans = Math.max(ans, cnt);
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if(nx<0 || ny<0 || nx>=C || ny>=R) continue;
			if(!visit[map[ny][nx]-'A']) {
				visit[map[ny][nx]-'A'] = true;
				dfs(ny,nx,cnt+1);
				visit[map[ny][nx]-'A'] = false;
			}
		}
	}

}
