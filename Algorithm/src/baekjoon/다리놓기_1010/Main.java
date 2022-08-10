package baekjoon.다리놓기_1010;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int T, N, M, ans;
	static int[][] dp;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			dp = new int[M+1][N+1];
			ans = build(M,N);
			System.out.println(ans);
		}

	}
	
static int build(int m, int n) {
		
		// 기저 조건
		if(m == n) {
			return dp[m][n] = 1;
		}
		// 추가적인 기저조건
		if(n == 0) {
			return dp[m][n] = 1;
		}
		if(dp[m][n] > 0) {
			return dp[m][n];
		}
		
		return dp[m][n] = build(m-1,n-1) + build(m-1,n);
	}

}
