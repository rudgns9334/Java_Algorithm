package baekjoon.적록색약_10026;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static int N, noRG, RG;
	static char[][] map;
	static boolean[][] visit;
	
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		noRG = 0;
		RG = 0;
		map = new char[N][];
		visit = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!visit[i][j]) {
					dfs(i,j);
					noRG++;
				}
			}
		}
		
		visit = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j]=='R') map[i][j] = 'G';
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!visit[i][j]) {
					dfs(i,j);
					RG++;
				}
			}
		}
		
		System.out.println(noRG + " " + RG);
	}

	static void dfs(int y, int x) {
		visit[y][x] = true;
		char color = map[y][x];
		
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if(ny<0 || nx<0 || ny>=N || nx>=N) continue;
			if(visit[ny][nx]) continue;
			if(map[ny][nx] == color) dfs(ny,nx);
		}
	}
	
}
