package baekjoon.다리놓기_1010;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_T2 {

	// 공 7개중에 4개를 뽑는다. (조합)
	//	공 한개를 선택한 경우의 수 => 6개 중에 3개
	// 공한개를 선택하지 않은 경우의 수 => 6개 중에 4개
	// 4C7 = 6C3 + 6C4
	//     = 5C2 + 5C3 + 5C3 + 5C4
	
	// => 중복이 많이 발생한다. => 미리 계산한 값을 저장할 수 있는 자료구조를 만들고, 반복되는 경우는 기록해 두고 재사용한다.
	// memoization
	// memoization을 이용해서 작은 수 -> 큰 수로 확대해 나가는 방법 DP
	
	static int T,N,M,ans;
	static int[][] dp; // 역할은 재귀 호출을 줄여주는 효과
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			dp = new int[M+1][N+1];
			
			// dp로 배열 완성하기
			for (int i = 0; i <= M; i++) {
				for (int j = 0; j <= Math.min(i, N); j++) {
					if(j==0 || j==i) dp[i][j] = 1;
					else dp[i][j] = (dp[i-1][j-1] + dp[i-1][j]);
				}
			}
			
			System.out.println(dp[M][N]);
		}
		

	}

}
