package swea.아파트;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] y = new int[N+1];
		int[] b = new int[N+1];
		y[1] = 1;
		b[1] = 1;
		b[0] = 1;
		// dp[3]은 노랑노랑파랑 노랑파랑노랑 파랑노랑노랑 파랑노랑파랑
		// dp[4]는 노랑노랑파랑노랑 노랑파랑노랑노랑 노랑파랑노랑파랑 파랑노랑노랑파랑 파랑노랑파랑노랑
		// dp[5] 노랑노랑파랑노랑노랑 노랑노랑파랑노랑파랑 노파노노파 노파노파노 파노노파 파노파노파 파노파노노
		
		// b[2] = 1
		// y[2] = 2
		// y[3] = b[2] + b[1] = 1+1 = 2
		// b[3] = y[2] = 2;
		// y[4] = b[3] + b[2] = 2 + 1 = 3;
		// b[4] y[3] = 2;
		// y[5] = b[4] + b[3] = 2 + 2;
		// b[5] = y[4] = 3;
		for (int i = 2; i <= N; i++) {
			y[i] = b[i-1] + b[i-2];
			b[i] = y[i-1];
		}
		
		System.out.println(y[N] + b[N]);
	}

}
