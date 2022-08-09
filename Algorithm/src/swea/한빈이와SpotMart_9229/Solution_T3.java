package swea.한빈이와SpotMart_9229;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_T3 {

	static int T,N,M,ans;
	static int[] src1, src2;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			src1 = new int[N];
			src2 = new int[N];
			
			ans = -1;
			
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				src2[i] = src1[i] = Integer.parseInt(st.nextToken());
			}
			
			// 대각선 밑으로
			int sum = 0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<i;j++) {
					sum = src1[i] + src2[j];
					if(sum > M) continue;
					ans = Math.max(ans, sum);
				}
			}
			
			System.out.println("#" + tc + " " + ans);
		}
	}
}
