package swea.한빈이와SpotMart_9229;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_T {

	static int T,N,M,ans;
	static int[] src, tgt;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			src = new int[N];
			tgt = new int[2];
			
			ans = -1;
			
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				src[i] = Integer.parseInt(st.nextToken());
			}
			
			comb(0,0);
			
			System.out.println("#" + tc + " " + ans);
		}
	}
	
	static void comb(int srcIdx, int tgtIdx) {
		// 기저 조건 -> tgt
		if(tgtIdx == 2) {
			// complete code
			int sum = tgt[0] + tgt[1];
			if( sum > M ) return;
			else ans = Math.max(ans, sum);
			return;
		}
		// 기저 조건 -> src
		if(srcIdx == N) {
			return;
		}
		
		tgt[tgtIdx] = src[srcIdx];
		
		// 재귀 호출
		comb(srcIdx+1,tgtIdx+1); // 현재 선택을 받아 들임.
		comb(srcIdx+1,tgtIdx); // 현재 선택을 받아 들이지 않음.
	}

}
