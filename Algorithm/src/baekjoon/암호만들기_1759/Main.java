package baekjoon.암호만들기_1759;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int L, C;
	static char[] input;
	static char[] select;
	static boolean[] isMo;
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		input = new char[C];
		select = new char[L];
		isMo = new boolean[C];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			input[i] = st.nextToken().charAt(0);
			
		}
		
		Arrays.sort(input);
		
		for (int i = 0; i < C; i++) {
			if(input[i] == 'a' || input[i] == 'e' || input[i] == 'i' || input[i] == 'o' || input[i] == 'u') {
				isMo[i] = true;
			}
		}
comb(0, 0, 0, 0);
		
		System.out.println(sb.toString());
	}
	
	static void comb(int srcIdx, int tgtIdx, int moCnt, int jaCnt) {
		// 기저 조건
		if(tgtIdx == L) {
			if(moCnt >= 1 && jaCnt >= 2) {
				for (int i = 0; i < L; i++) {
					sb.append(select[i]);
				}
				sb.append('\n');
			}
			return;
		}
		
		if(srcIdx == C) return;
		
		select[tgtIdx] = input[srcIdx]; // 현재 소스를 현재 타깃에 받아 들인다.
		
		// 현재 따지는 문자가 모음이냐 자음이냐에 따라 다르게 처리
		if(isMo[srcIdx]) {
			comb(srcIdx+1, tgtIdx+1, moCnt+1, jaCnt);
		}else {
			comb(srcIdx+1,tgtIdx+1, moCnt, jaCnt+1);
		}
		comb(srcIdx+1, tgtIdx, moCnt, jaCnt);
	}


}
