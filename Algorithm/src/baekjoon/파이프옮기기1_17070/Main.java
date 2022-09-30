package baekjoon.파이프옮기기1_17070;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, r, c;
	static int[][] map;
	static int[][][] dp;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N+1][N+1];
		dp = new int[N+1][N+1][3];
		// 0 : 가로
		// 1 : 세로
		// 2 : 대각선
		
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp[1][2][0] = 1;
		
		for (int i = 1; i <= N; i++) {
			for (int j = 3; j <= N; j++) {
				if(map[i][j] == 1) continue;
				// 가로로 두는 경우 - (i,j-1)와 (i,j)를 연결 - 가로와 대각선
				dp[i][j][0] = dp[i][j-1][0] + dp[i][j-1][2];
				// 세로로 두는 경우 - (i-1,j)와 (i,j)를 연결 - 세로와 대각선
				dp[i][j][1] = dp[i-1][j][1] + dp[i-1][j][2];
				// 대각선으로 두는 경우 - (i-1,j-1)와 (i,j)를 연결 - 모두 가능
				// 단 모두 빈공간이어야 함
				if(map[i-1][j] == 1 || map[i][j-1] == 1) continue;
				dp[i][j][2] = dp[i-1][j-1][0] + dp[i-1][j-1][1] + dp[i-1][j-1][2]; 
			}
		}
		
		System.out.println(dp[N][N][0] + dp[N][N][1] + dp[N][N][2]);
		
	}
}
