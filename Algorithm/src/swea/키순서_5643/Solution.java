package swea.키순서_5643;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int T, N, M;
	static int[][] map;
	static final int INF = 98765432;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			
			map = new int[N+1][N+1];
			
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if(i == j) map[i][j] = 0;
					else map[i][j] = INF;
				}
			}
			
			for (int i = 0; i < M; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int v1 = Integer.parseInt(st.nextToken());
				int v2 = Integer.parseInt(st.nextToken());
				map[v1][v2] = 1;
			}
			
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					for (int k = 1; k <= N; k++) {
						map[j][k] = Math.min(map[j][k], map[j][i] + map[i][k]);
					}
				}
			}
			
			int cnt = 0;
			for (int i = 1; i <= N; i++) {
				boolean ok = true;
				for (int j = 1; j <= N; j++) {
					if(i==j) continue;
					if(map[i][j] == INF && map[j][i] == INF) {
						ok = false;
						break;
					}
				}
				if(ok) cnt++;
			}
			
			System.out.println("#" + t + " " + cnt);
			
		}
	}
}
