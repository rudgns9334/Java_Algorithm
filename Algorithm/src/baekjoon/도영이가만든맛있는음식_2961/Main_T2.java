package baekjoon.도영이가만든맛있는음식_2961;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_T2 {

	static int N, min;
	static int[][] src;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		src = new int[N][2];
		
		min = Integer.MAX_VALUE;
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			src[i][0] = Integer.parseInt(st.nextToken());
			src[i][1] = Integer.parseInt(st.nextToken());
		}
		
		dfs(0,1,0);
		
		System.out.println(min);
	}
	
	static void dfs(int idx, int sinSum, int ssnSum) {
		if(idx == N) return;
		
		// 현재 srcIdx 재료의 신맛과 쓴맛을 계산
		int currSin = src[idx][0] * sinSum;
		int currSsn = src[idx][1] + ssnSum;
		
		// 현재 재료에 대한 고려
		min = Math.min(min, Math.abs(currSin - currSsn));
	
		// 다음 재료 선택
		dfs(idx+1, currSin, currSsn); // 현재 재료를 선택
		dfs(idx+1, sinSum, ssnSum); // 현재 재료를 선택 X
	}

}
