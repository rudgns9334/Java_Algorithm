package baekjoon.알파벳_1987;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_T2 {

	static int R, C, max;
	static int[][] map;
//	static boolean[] visit = new boolean[26]; // 알파벳 수
	
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
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
		// map[0][0] --> 어떤 integer 값이 있을 건데 그 값을 1을 << 연산 수행
		// map[0][0] : 3(D)
		dfs(0, 0, 1, 1 << map[0][0]);
		
		System.out.println(max);
	}

	// 좌표를 방문하면(알파벳)
	// 방문할 때 마다 max 확인
	static void dfs(int y, int x, int cnt, int visit) {
		max = Math.max(max, cnt);
		// 다음 방문이 가능하면 다시 방문
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			// D (3) : 1 << map[ny][nx] => 0000 0000 1000
			// visit					=> 1000 1000 1001
			if(ny < 0 || nx < 0 || ny >= R || nx >= C || (visit & 1 << map[ny][nx]) != 0) continue;
			dfs(ny, nx, cnt+1, visit | 1 << map[ny][nx]);	
		}
	}
}
