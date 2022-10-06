package baekjoon.맥주마시면서걸어가기_9205;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int T, N;
	static int[][] pos;
	static int[][] matrix;
	
	static final int INF = 999999;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine()); // 편의점

			pos = new int[N+2][2]; // 0 : 집  N+1 : 도착
			matrix = new int[N+2][N+2];
			
			for (int i = 0; i < N+2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				pos[i][0] = Integer.parseInt(st.nextToken());
				pos[i][1] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 0; i < N+2; i++) {
				for (int j = 0; j < N+2; j++) {
					int dist = Math.abs(pos[i][0]-pos[j][0]) + Math.abs(pos[i][1] - pos[j][1]);
					if( i == j ) matrix[i][j] = 0;
					else if( dist > 1000 && i != j ) matrix[i][j] = INF;
					else matrix[i][j] = dist;
				}
			}
			
			for (int i = 0; i < N+2; i++) {
				for (int j = 0; j < N+2; j++) {
					for (int k = 0; k < N+2; k++) {
						matrix[j][k] = Math.min(matrix[j][k], matrix[j][i] + matrix[i][k]);
					}
				}
			}
			
			if(matrix[0][N+1] == INF) System.out.println("sad");
			else System.out.println("happy");
		}

	}

}
