package baekjoon.외판원순회2_10971;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static long min;
	static int[][] map;
	static boolean[] visit;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		min = Long.MAX_VALUE;
		visit = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visit[0] = true;
		dfs(0, 1, 0);
		
		System.out.println(min);
	}
	
	static void dfs(int v, int cnt, long sum) {
		
		if(cnt == N) {
			//complete code
			if(map[v][0] != 0) {
				min = Math.min(min, sum + map[v][0]);
			}
			return;
		}
		for (int i = 0; i < N; i++) {
			if(visit[i] || map[v][i] == 0) continue;
			visit[i] = true;
			dfs(i, cnt+1, sum+map[v][i]);
			visit[i] = false;
		}
	}
	
}
