package baekjoon.RGB거리_1149;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] dp;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		dp = new int[N+1][3]; // 0 -> R , 1 -> G , 2 -> B
		
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int R = Integer.parseInt(st.nextToken());
			int G = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			// 결국 연속된 집이 같은 색이 아니면 된다.
			// 매 라인마다 나머지 색중 더 작은 값을 받아와서 해당 색과 더해줌
			dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + R;
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + G;
			dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + B;
		}
		
		System.out.println(Math.min(dp[N][0], Math.min(dp[N][1], dp[N][2])));

	}

}
