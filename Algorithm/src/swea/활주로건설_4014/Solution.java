package swea.활주로건설_4014;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution{

	static int T, N, X, ans;
	static int[][] map;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			ans = 0;
			
			map = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 가로 탐색
			widthSearch();
			// 세로 탐색
			verticalSearch();
			System.out.println("#" + t + " " + ans);
		}
	}
	
	static void widthSearch() {
		for (int i = 0; i < N; i++) {
			boolean ok = true;
			boolean[] visit = new boolean[N];
			for (int j = 0; j < N-1; j++) {
				if(Math.abs(map[i][j] - map[i][j+1]) > 1) {
					ok =  false;
					break;
				}
				// 다음 칸이 높은 경우
				if(map[i][j] == map[i][j+1]-1) {
					for (int x = 0; x < X; x++) {
						if(j-x < 0 || map[i][j] != map[i][j-x] || visit[j-x]) {
							ok = false;
							break;
						}
					}
					if(ok) {
						for (int x = 0; x < X; x++) {
							visit[j-x] = true;
						}
					}
					
				}
				// 다음 칸잉 낮은 경우
				if(map[i][j] == map[i][j+1]+1) {
					for (int x = 1; x <= X; x++) {
						if(j+x >= N || map[i][j]-1 != map[i][j+x] || visit[j+x]) {
							ok = false;
							break;
						}
					}
					if(ok) {
						for (int x = 1; x <= X; x++) {
							visit[j+x] = true;
						}
					}
					
				}
				
				if(!ok) {
					break;
				}
			}
			if(ok) {
//				System.out.println("w : " + i);
				ans++;
			}
		}
	}
	
	static void verticalSearch() {
		for (int i = 0; i < N; i++) {
			boolean ok = true;
			boolean[] visit = new boolean[N];
			for (int j = 0; j < N-1; j++) {
				if(Math.abs(map[j][i] - map[j+1][i]) > 1) {
					ok =  false;
					break;
				}
				// 다음 칸이 높은 경우
				if(map[j][i] == map[j+1][i]-1) {
					for (int x = 0; x < X; x++) {
						if(j-x < 0 || map[j][i] != map[j-x][i] || visit[j-x]) {
							ok = false;
							break;
						}
					}
					if(ok) {
						for (int x = 0; x < X; x++) {
							visit[j-x] = true;
						}
					}
					
				}
				// 다음 칸잉 낮은 경우
				if(map[j][i] == map[j+1][i]+1) {
					for (int x = 1; x <= X; x++) {
						if(j+x >= N || map[j][i]-1 != map[j+x][i] || visit[j+x]) {
							ok = false;
							break;
						}
					}
					if(ok) {
						for (int x = 1; x <= X; x++) {
							visit[j+x] = true;
						}
					}
				}
				
				if(!ok) {
					break;
				}
			}
			if(ok) {
//				System.out.println("v : " + i);
				ans++;
			}
		}
	}
}
