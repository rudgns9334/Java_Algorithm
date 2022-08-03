package swea.상호의배틀필드_1873;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_T {

	static int T, H, W, N, ty, tx;
	static char[][] map;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			
			// map
			map = new char[H][]; // input을 toCharArray()를 이용할 것
			
			for(int i=0;i<H;i++) {
				map[i] = br.readLine().toCharArray();
				for(int j=0;j<W;j++) {
					switch(map[i][j]) {
					case '<':
					case '>':
					case '^':
					case 'v':
						ty = i;
						tx = j;
						break; // 탱크는 하나
					}
				}
			}
			
			//명령어
			N = Integer.parseInt(br.readLine());
			String oper = br.readLine();
			
			for (int i = 0; i < N; i++) {
				char c = oper.charAt(i);
				switch(c) {
				case 'U':
					map[ty][tx] = '^';
					move(0); // delta 상
					break;
				case 'D':
					map[ty][tx] = 'v';
					move(1); // delta 상
					break;
				case 'L':
					map[ty][tx] = '<';
					move(2); // delta 상
					break;
				case 'R':
					map[ty][tx] = '>';
					move(3); // delta 상
					break;
				case 'S':
					shoot();
					break;
				}
			}
			
			// 출력
			System.out.println("#" + t + " ");
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}
		}

	}
	
	static void move(int dir) {
		int ny = ty + dy[dir];
		int nx = ty + dx[dir];
		
		if(ny<0 || nx<0 || ny>=H || nx>=W) return;
		
		if(map[ny][nx]=='.') {
			map[ny][nx] = map[ty][tx];
			map[ty][tx] = '.';
			ty = ny;
			tx = nx;
		}
	}
	
	static void shoot() {
		int dir = 0;
		switch(map[ty][tx]) {
		case '^': dir = 0; break; // 상
		case 'v': dir = 1; break; // 하
		case '<': dir = 2; break; // 좌
		case '>': dir = 3; break; // 우
		}
		
		int ny = ty;
		int nx = tx;
		
		while(true) {
			ny = ny + dy[dir];
			nx = nx + dx[dir];
			
			if(ny<0 || nx<0 || ny>=H || nx>=W) return;
			
			// 벽
			if(map[ny][nx] == '*') {
				map[ny][nx] = '.';
				return;
			}else if(map[ny][nx] == '#') {
				return;
			}
		}
		
	}

}
