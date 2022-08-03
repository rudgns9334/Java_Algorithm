package baekjoon.구간의합구하기5_11660;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_T {

	static int N, M;
	static int[][] accu; // memoization : 미리 계산해 두기 <= 이전 수부터의 합을 미리 계산, 행별로 각각 누적 계산
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		accu = new int[N+1][N+1];
		
		
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				accu[i][j] = accu[i][j-1] + Integer.parseInt(st.nextToken());
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			// x 가 행
			int sum = 0;
			for (int x=x1; x<=x2;x++) { // 행렬로 내려가면서
				sum += accu[x][y2] - accu[x][y1-1];
			}
			sb.append(sum).append("\n");
		}
		System.out.println(sb.toString());
		

	}

}
