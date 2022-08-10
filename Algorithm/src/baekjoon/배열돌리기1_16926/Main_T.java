package baekjoon.배열돌리기1_16926;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_T {

	static int N, M, R;
	static int[][] map;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 처리
		for (int i = 0; i < R; i++) {
			rotate();
		}
		
		// 출력
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	
	// 1회 회전
	static void rotate() {
		int sy = 0, ey = N-1; // sy : 시작 y, ey : 종료 y
		int sx = 0, ex = M-1; // sx : 시작 x, ex : 종료 x
		
		while(true) {
			// 기저 조건
			if(ey-sy<1 || ex-sx<1) return;
			
			// 반 시계 방향으로 이동
			int tmp = map[sy][sx];// 첫 좌표 복사
			
			// top 좌표 이동( 오른쪽의 값이 왼쪽의 값으로 이동)
			for(int i = sx; i < ex; i++) {
				map[sy][i] = map[sy][i+1];
			}
			
			// right 상으로 이동( 밑의 값이 위로 이동 )
			for(int i=sy;i<ey;i++) {
				map[i][ex] = map[i+1][ex]; // 오른쪽 끝 X 고적
			}
			
			// bottom 우로 이동( 왼쪽의 값이 오른쪽으로 이동 )
			for(int i=ex;i > sx;i--) {
				map[ey][i] = map[ey][i-1];
			}
			
			// left
			for(int i=ey;i>sy;i--) {
				map[i][sx] = map[i-1][sx];
			}
			
			map[sy+1][sx] = tmp;
			// sy, ey, sx, ex 보정
			sy++;
			sx++;
			ey--;
			ex--;
		}
	}

}
