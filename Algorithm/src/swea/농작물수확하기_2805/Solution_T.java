package swea.농작물수확하기_2805;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 농장의 크기는 항상 홀수x홀수 = 홀수
// 가운데 점에서 delta? X
// 상하 또는 좌우 대칭으로 그 변화가 바뀌는 부분 기준으로 풀이
public class Solution_T {

	static int T, N;
	static int[][] map;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());			
			map = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				char[] temp = br.readLine().toCharArray();
				for (int j = 0; j < N; j++) {
					map[i][j] = temp[j] - '0';
				}
			}
			
			int sum = 0;
			int wide = 0; // center 로부터 좌우로 멀어지는 정도
			int half = N/2; // 가운데 인덱스 ( 홀수이므로 2로 나누면 됨 )
			int startX, endX; // 가로 수확 시작 - 끝
			
			// 위에서부터 밑으로 한 행씩 내려가면서
			for (int i = 0; i < N; i++) {
				startX = half - wide; // 왼쪽 시작 index
				endX = half + wide;	  // 오른쪽 종료 index (포함)	
				
				for (int j = startX; j <= endX; j++) {
					sum += map[i][j];
				}
				if( i < half) {
					wide++;
				}else {
					wide--;
				}
			}
			System.out.println("#" + t + " " + sum);
		}
	}

}
