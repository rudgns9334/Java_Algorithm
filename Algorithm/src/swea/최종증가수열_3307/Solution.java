package swea.최종증가수열_3307;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int T, N, len;
	static int[] input;
	static int[] LIS;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			input = new int[N];
			LIS = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				input[i] = Integer.parseInt(st.nextToken());
			}
			
			len = 0;
			
			for (int i = 0; i < N; i++) {
				// 현재 따지는 i를 초기값 1로 설정
				LIS[i] = 1;
				for (int j = 0; j < i; j++) {
					// 맨 앞에서 i 이전까지 i와 j의 값을 비교해서
					// j의 값이 i의 값보다 작으면
					if( input[j] < input[i] && LIS[i] <= LIS[j]) {
						LIS[i] = LIS[j] + 1;
					}
				}
				
				len = Math.max(len, LIS[i]);
			}
			
			System.out.println("#" + t + " " + len);
		}
		
	}
}
