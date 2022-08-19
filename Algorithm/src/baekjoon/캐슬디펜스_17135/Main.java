package baekjoon.캐슬디펜스_17135;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, M, D, archer, ans, max, sum;
	static int[][] map;
	static int[] tgt;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		archer = N;
		tgt = new int[3];
		map = new int[N][M];
		ans = 0;
		max = 0;
		sum = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		while(check()) {
			comb(0,0);
			ans += sum;
			archer--;
		}
		
		System.out.println(ans);
		

	}

	
	static void comb(int srcIdx, int tgtIdx) { // srcIdx를 tgtIdx에 선택, 비선택 2가지 경우
		
		// 기저 조건
		if(tgtIdx == 3) {
			max = attack();
			sum = Math.max(max, sum);
			return;
		}
		// 추가적인 기저조건
		if(srcIdx == N) return;
		
		// 선택
		tgt[tgtIdx] = srcIdx;
		
		comb(srcIdx + 1, tgtIdx + 1); // 현재 선택(tgtIdx <- srcIdx)을 만족, 다음 선택을 하러 재귀
		comb(srcIdx +1, tgtIdx); // 현재 선택(tgtIdx <- srcIdx) 만족 X, 여전히 tgtIdx <- src+1;
	}
	
	static boolean check() {
		for (int i = 0; i < archer; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 1) return false;
			}
		}
		
		return true;
	}
	static int attack() {
		int arIdx = 0;
		for (int i = archer-1; i >= 0 ; i--) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 1) {
					int d = Math.abs(i-archer) + Math.abs(j-tgt[arIdx]);
					if(d<=D) {
						map[i][j] = 0;
						arIdx++;
						if(arIdx == 3) return arIdx;
					}
					
				}
			}
		}
		return arIdx;
		
	}
}
