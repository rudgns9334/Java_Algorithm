package swea.농작물수확하기_2805;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int T, N, sum;
	static int[][] area;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++) {
			N = Integer.parseInt(br.readLine());
			area = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				String line = br.readLine();
				char[] chr = line.toCharArray();
				for (int j = 0; j < N; j++) {
					area[i][j] = chr[j]-'0';
				}
			}
			int center = N/2;
			sum = 0;
			for (int i = 0; i < N; i++) {
				int blank = Math.abs(center-i);
				for (int j = 0; j < N; j++) {
					if(j>=blank && j<N-blank) {
						sum += area[i][j];
					}
				}
			}
			System.out.println("#"+t+" "+sum);
		}
	}

}
