package swea.정사각형방_1861;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int T,N,ans, maxIdx;
	static int[][] room;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++) {
			N = Integer.parseInt(br.readLine());
			room = new int[N][N];
			maxIdx = (N*N)+1;
			ans = 0;
			for(int i=0;i<N;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					room[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					int s = dfs(i,j);
					if(ans < s) {
						maxIdx = room[i][j];
						ans = s;
					}else if(ans == s) {
						maxIdx = Math.min(maxIdx, room[i][j]);
					}
				}
			}
			
			System.out.println("#"+t+" "+ maxIdx + " " + ans);
		}
	}
	
	static int dfs(int y, int x) {
		int Sum = 1;
		for(int i=0;i<4;i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if(ny<0 || nx<0 || ny>=N || nx>=N) continue;
			if(room[ny][nx]-room[y][x] == 1) {
				Sum += dfs(ny,nx);
			}
		}
		return Sum;
		
	}

}
