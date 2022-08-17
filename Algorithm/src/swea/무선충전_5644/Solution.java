package swea.무선충전_5644;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int T,M,A,sum,ax,ay,bx,by;
	static int[] moveA, moveB;
	static int[][] map = new int[11][11];
	static int[][] BC; 
	static int[] dy = {0, -1, 0, 1, 0};
	static int[] dx = {0, 0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			sum = 0;
			moveA = new int[M];
			moveB = new int[M];
			BC = new int[A][4]; // 0 : X좌표, 1 : Y좌표, 2 : 충전범위 , 3 : 처리량
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				moveA[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				moveB[i] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 0; i < A; i++) {
				st = new StringTokenizer(br.readLine());
				BC[i][0] = Integer.parseInt(st.nextToken());
				BC[i][1] = Integer.parseInt(st.nextToken());
				BC[i][2] = Integer.parseInt(st.nextToken());
				BC[i][3] = Integer.parseInt(st.nextToken());
			}
			
			ax = 1;
			ay = 1;
			bx = 10;
			by = 10;
			check();
			
			for (int i = 0; i < M; i++) {
				ax = ax + dx[moveA[i]];
				ay = ay + dy[moveA[i]];
				bx = bx + dx[moveB[i]];
				by = by + dy[moveB[i]];
				
				check();
			}
			
			System.out.println("#" + t + " " + sum);
		}

	}

	static void check() {
		int max = 0;
		for (int i = 0; i < A; i++) {
			for (int j = 0; j < A; j++) {
				int asum = 0;
				int bsum = 0;
				int S = 0;
				int D = Math.abs(ax-BC[i][0]) + Math.abs(ay-BC[i][1]);
				if(D<=BC[i][2]) {
					asum = BC[i][3];
				}
				int D2 = Math.abs(bx-BC[j][0]) + Math.abs(by-BC[j][1]);
				if(D2 <= BC[j][2]) {
					bsum = BC[j][3];
				}
				
				if(i!=j) {
					S = asum + bsum;
				}else {
					S = Math.max(asum, bsum);
				}
				
				if(max<S) max = S;
			}
		}
		sum += max;
	}
}
