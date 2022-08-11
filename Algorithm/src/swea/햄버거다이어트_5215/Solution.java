package swea.햄버거다이어트_5215;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int T,N,L,maxS;
	static int[] foodScore;
	static int[] foodKal;
	static int[] tgt;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			foodScore = new int[N];
			foodKal = new int[N];
			maxS = 0;
			tgt = new int[N];
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				foodScore[i] = Integer.parseInt(st.nextToken());
				foodKal[i] = Integer.parseInt(st.nextToken());
			}
			
			comb(0,0);
			
			System.out.println("#" + t + " " + maxS);
		}

	}
	
	static void comb(int srcIdx, int tgtIdx) {
		if(tgtIdx == tgt.length) {
			return;
		}
		
		if(srcIdx == N) {
			return;
		}
		
		tgt[tgtIdx] = srcIdx;
		
		int sumS = 0;
		int sumK = 0;
		for(int k=0;k<=tgtIdx;k++) {
			sumK += foodKal[tgt[k]];
			sumS += foodScore[tgt[k]];
		}
		if(sumK<=L) {
			if(sumS > maxS) {
				maxS = sumS;
			}
			comb(srcIdx+1, tgtIdx+1);
		}
		comb(srcIdx+1, tgtIdx);
	}

}
