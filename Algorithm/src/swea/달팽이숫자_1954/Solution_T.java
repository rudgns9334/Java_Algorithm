package swea.달팽이숫자_1954;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_T {

	static int T,N;
	static int[][] snail;
	// 시계 방향으로 이동 = delta : 순서가 있는
	// 우 - 하 - 좌 - 상
	static int[] dy = {0, 1, 0, -1};
	static int[] dx = {1, 0, -1, 0};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			snail = new int[N][N];
			
			// 시작좌표, 방향
			int y = 0;
			int x = 0;
			int d = 0; // 시작 방향 : 우 index
			
			int num = 1; // 시작 숫자 (계속 1씩 증가)
			
			// NxN 만큼 반복하면서 숫자를 저장
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					
					snail[y][x] = num++; // 숫자를 저장
					
					// 이동
					// 현재 방향으로 이동하다가 더이상 못가면 다음 방향으로 전환
					if( d == 0 ) {
						int nx = x + dx[d];
						if( nx >= N || snail[y][nx] != 0) d = 1;
					}else if( d == 1 ) {
						int ny = y + dy[d];
						if( ny >= N || snail[ny][x] != 0) d = 2;
					}else if( d == 2 ) {
						int nx = x + dx[d];
						if( nx < 0 || snail[y][nx] != 0) d = 3;
					}else if (d == 3 ) {
						int ny = y + dy[d];
						if( ny < 0 || snail[ny][x] != 0) d = 0;
					}
					
					// 위 조건에 해당하지 않으면 d는 이전의 d
					// 해당하면 d는 변경
					x = x + dx[d];
					y = y + dy[d];		
				}
			}
			
			System.out.println("#"+t);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(snail[i][j] + " ");
				}
				System.out.println();
			}
			
		}

	}

}
