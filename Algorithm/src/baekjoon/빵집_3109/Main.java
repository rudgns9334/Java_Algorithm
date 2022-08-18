package baekjoon.빵집_3109;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int R,C,ans;
	static char[][] map;
	static boolean[][] visit;
	
	// 오른쪽 위, 오른쪽, 오른쪽 아래
	static int[] dy = {-1, 0, 1};
	static int[] dx = {1, 1, 1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		ans = 0;
		map = new char[R][C];
		visit = new boolean[R][C];
		
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		for (int i = 0; i < R; i++) {
			if(dfs(i,0)) {
				ans++;
			}
		}
		
		
		System.out.println(ans);
	}
	
	static boolean dfs(int y, int x) {
		visit[y][x] = true;
		if(x == C-1) {
			return true;
		}
		for (int i = 0; i < 3; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if(ny<0 || nx<0 || ny>=R || nx>=C) continue;
			if(map[ny][nx]=='.') {
				if(!visit[ny][nx]) {
					if(dfs(ny,nx)) {
						return true;
					}
				}
			}
		}
		return false;
	}

}
