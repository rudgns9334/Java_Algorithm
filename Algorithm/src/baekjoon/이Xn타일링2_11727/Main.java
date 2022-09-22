package baekjoon.이Xn타일링2_11727;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	static int N;
	static long[] dp;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dp = new long[N+1];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 3;
		for (int i = 3; i <= N; i++) {
			
		}
	}
}
