package baekjoon.배열돌리기4_17406;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,M,K,ans;
	static int[][] map, rotation;
	static boolean[] used;
	static int[] tar;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		ans = Integer.MAX_VALUE;
		
		map = new int[N+1][M+1];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		rotation = new int[K][3];
		used = new boolean[K];
		tar = new int[K];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				rotation[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		perm_rotation(0);
		
		System.out.println(ans);
		
	}
	
	static void perm_rotation(int cnt) {
		// 순열이 완성되는 (기저 조건)
		// 현재 호출 전까지 이미 마무리
		if(cnt == K) {
			for (int i = 0; i < K; i++) {
				rotate(rotation[tar[i]][0], rotation[tar[i]][1], rotation[tar[i]][2]);
			}
			
			for (int i = 1; i <= N; i++) {
				int sum = 0;
				for (int j = 1; j <= M; j++) {
					sum += map[i][j];
				}
				ans = Math.min(ans, sum);
			}
			return;
		}
		
		for (int i = 0; i < K; i++) {
			if(used[i]) continue;
			// 선택
			tar[cnt] = i;
			used[i] = true;
			// 다음 자리 tgt를 채우기
			perm_rotation(cnt+1);
			
			used[i] = false;
				
		}
	}
	
	
	static void rotate(int r, int c, int s) {
		int sy = r-s, ey = r+s; // sy : 시작 y, ey : 종료 y
		int sx = c-s, ex = c+s; // sx : 시작 x, ex : 종료 x
		
		while(true) {
			// 기저 조건
			if(ey-sy<1 || ex-sx<1) return;
			
			// 반 시계 방향으로 이동
			int tmp = map[sy][sx];// 첫 좌표 복사
			
			// left->top 으로 좌표 이동
			for(int i = sy; i < ey; i++) {
				map[i][sx] = map[i+1][sx];
			}
			
			// bottom -> left으로 이동
			for(int i=sx;i<ex;i++) {
				map[ey][i] = map[ey][i+1]; // 오른쪽 끝 X 고적
			}
			
			// right -> bottom 으로 이동
			for(int i=ey;i > sy;i--) {
				map[i][ex] = map[i-1][ex];
			}
			
			// top -> right로 이동
			for(int i=ex;i>sx;i--) {
				map[sy][i] = map[sy][i-1];
			}
			
			map[sy][sx+1] = tmp;
			// sy, ey, sx, ex 보정
			sy++;
			sx++;
			ey--;
			ex--;
		}
	}
}
