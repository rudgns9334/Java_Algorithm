package swea.벽돌깨기_5656;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int T, N, W, H, min, total, cnt;
	static int[][] map,copy;
	static int[] dest, startB, copyB;
	
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			min = Integer.MAX_VALUE;
			total = 0;
			
			map = new int[H][W];
			copy = new int[H][W];
			dest = new int[N];
			startB = new int[W];
			copyB = new int[W];
			
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					int n = Integer.parseInt(st.nextToken());
					if(n > 0) {
						total++;
					}
					map[i][j] = n;
				}
			}
			
			for (int i = 0; i < W; i++) {
				for (int j = 0; j < H; j++) {
					if(map[j][i] != 0) {
						startB[i] = j;
						break;
					}
					if(j == H-1) startB[i] = -1;
				}
			}
			
			choice(0);
			
			System.out.println("#" + t + " " +min);
			
		}
	}
	
	static void choice(int idx) {
		
		if(idx == N) {
			start();
			return;
		}
		
		for (int i = 0; i < W; i++) {
			dest[idx] = i;
			choice(idx+1);
		}
		
	}
	
	static void start() {
		copyMap();
		cnt = 0;
		for (int i = 0; i < N; i++) {
			int w = dest[i];
			int h = copyB[w];
			if(h == -1) continue;
			bomb(h, w);
			setBlock();
		}
		if(min > total - cnt) {
			min = total - cnt;
		}
	}
	
	static void bomb(int y, int x) {
		int range = copy[y][x];
		copy[y][x] = 0;
		cnt++;
		for (int d = 0; d < 4; d++) {
			int ny = y;
			int nx = x;
			for (int j = 1; j < range; j++) {
				ny = ny + dy[d];
				nx = nx + dx[d];
				
				if(ny<0 || nx<0 || ny>=H || nx>=W) break;
				if(copy[ny][nx] == 0) continue;
				bomb(ny, nx);
			}
		}
	}
	
	static void setBlock() {
		for (int i = 0; i < W; i++) {
			if(copyB[i] == -1) continue;
			int idx = H;
			int c = H-1;
			while(idx>0) {
				idx--;
				if(copy[idx][i] == 0) {
					continue;
				}
				
				copy[c][i] = copy[idx][i];
				if(c != idx) copy[idx][i] = 0;
				c--;
				
			}
			if(c != H-1) {
				copyB[i] = c+1;
			}else {
				copyB[i] = -1;
			}
			
		}
	}
	
	static void copyMap() {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				copy[i][j] = map[i][j];
			}
		}
		for (int i = 0; i < W; i++) {
			copyB[i] = startB[i];
		}
	}
	
}
