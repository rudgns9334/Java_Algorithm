package swea.요리사_4012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int T,N,ans,Aflavor,Bflavor;
	static int[][] synergy;
	static boolean[] tgt;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++) {
			N = Integer.parseInt(br.readLine());
			synergy = new int[N][N];
			tgt = new boolean[N];
			ans = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					synergy[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			comb(0,0);
			
			System.out.println("#" + t + " " + ans);
		}

	}
	
	static void comb(int srcIdx, int tgtIdx) {
		if(tgtIdx == N/2) {
			//complete code
			cook();
			ans = Math.min(ans, Math.abs(Aflavor-Bflavor));
			return;
		}
		
		if(srcIdx==N) return;
		
		tgt[srcIdx] = true;
		comb(srcIdx + 1, tgtIdx + 1);// 선택
		tgt[srcIdx] = false;
		comb(srcIdx + 1, tgtIdx); // 선택 x
		
	}
	
	static void cook() {
		Aflavor = 0;
		Bflavor = 0;
		for(int i=0;i<N;i++) {
			for (int j = 0; j < N; j++) {
				if(tgt[i] && tgt[j]) Aflavor += synergy[i][j];
				else if(!tgt[i] && !tgt[j]) Bflavor += synergy[i][j];
			}
		}
	}

}
