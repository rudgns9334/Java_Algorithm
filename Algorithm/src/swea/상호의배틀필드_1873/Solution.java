package swea.상호의배틀필드_1873;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int T, H, W, N;
	static char[][] map;
	static char[] user;
	static int sx,sy,d; // 상 하 좌 우
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			map = new char[H][W];
			for(int i=0;i<H;i++) {
				char[] line = br.readLine().toCharArray();
				for(int j=0;j<W;j++) {
					map[i][j] = line[j];
					if(line[j]=='^') {
						sy = i;
						sx = j;
						d = 0;
					}else if(line[j]=='v') {
						sy = i;
						sx = j;
						d = 1;
					}else if(line[j]=='<') {
						sy = i;
						sx = j;
						d = 2;
					}else if(line[j]=='>') {
						sy = i;
						sx = j;
						d = 3;
					}
				}
			}
			
			N = Integer.parseInt(br.readLine());
			user = br.readLine().toCharArray();
			
			for (int i = 0; i < N; i++) {
				if(user[i] == 'S') {
					int cy = sy;
					int cx = sx;
					while(true) {
						cy = cy + dy[d];// 포탄 y좌표
						cx = cx + dx[d];// 포탄 x좌표
						if(cy<0 || cx<0 || cy>=H || cx>=W || map[cy][cx]=='#') break;
						if(map[cy][cx]=='*') {
							map[cy][cx] = '.';
							break;
						}
					}
				}else if(user[i] == 'U') {
					d = 0;
					map[sy][sx] = '^';
					int ny = sy + dy[d];
					int nx = sx + dx[d];
					if(ny<0) continue;
					if(map[ny][nx]=='.') {
						map[sy][sx] = '.';
						map[ny][nx] = '^';
						sy = ny;
						sx = nx;
					}
				}else if(user[i] == 'D') {
					d = 1;
					map[sy][sx] = 'v';
					int ny = sy + dy[d];
					int nx = sx + dx[d];
					if(ny>=H) continue;
					if(map[ny][nx]=='.') {
						map[sy][sx] = '.';
						map[ny][nx] = 'v';
						sy = ny;
						sx = nx;
					}
				}else if(user[i] == 'L') {
					d = 2;
					map[sy][sx] = '<';
					int ny = sy + dy[d];
					int nx = sx + dx[d];
					if(nx<0) continue;
					if(map[ny][nx]=='.') {
						map[sy][sx] = '.';
						map[ny][nx] = '<';
						sy = ny;
						sx = nx;
					}
				}else if(user[i] == 'R') {
					d = 3;
					map[sy][sx] = '>';
					int ny = sy + dy[d];
					int nx = sx + dx[d];
					if(nx>=W) continue;
					if(map[ny][nx]=='.') {
						map[sy][sx] = '.';
						map[ny][nx] = '>';
						sy = ny;
						sx = nx;
					}
				}
			}
			
			System.out.print("#"+t+" ");
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}
	}
}
