package swea.한빈이와SpotMart_9229;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int T, N, M;
	static int MAX, weight;
	static int[] snack;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=T ;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			MAX = -1;
			snack = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				snack[i] = Integer.parseInt(st.nextToken());
			}
			
			comb(0,0,0);
			
			System.out.println("#" + tc + " " + MAX);
		}
	}
	
static void comb(int srcIdx, int cnt, int w) {
		
		// 기저 조건
		if(cnt == 2) {
			if(w > M) return;
			MAX = Math.max(MAX, w);
			return;
		}
		// 추가적인 기저조건
		if(srcIdx == N) return;
		
		int nw = w;
		// 선택
		nw += snack[srcIdx];
		
		comb(srcIdx + 1, cnt + 1, nw);
		comb(srcIdx +1, cnt, w);
	}

}
