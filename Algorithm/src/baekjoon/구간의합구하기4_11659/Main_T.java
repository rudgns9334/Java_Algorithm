package baekjoon.구간의합구하기4_11659;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_T {

	static int N, M;
	static int[] accu; // memoization : 미리 계산해 두기
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		accu = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1;i <= N; i++) {
			accu[i] = accu[i-1] + Integer.parseInt(st.nextToken());
		}
		
		// M개의 구간 합
		StringBuilder sb = new StringBuilder(); // StringBuilder를 사용하면 print를 1번만 하기 때문에 몹시 시간 절약이 된다.
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
//			System.out.println(accu[to]-accu[from-1]);
			sb.append(accu[to]-accu[from-1]).append("\n");
		}
		System.out.println(sb.toString());
	}

}
