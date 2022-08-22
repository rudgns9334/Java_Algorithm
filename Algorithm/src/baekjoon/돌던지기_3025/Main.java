package baekjoon.돌던지기_3025;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int R, C, N;
	static char[][] map;
	static Rock[] rock;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][];
		rock = new Rock[C];
		
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		for (int i = 0; i < C; i++) {
			rock[i] = new Rock(i, R);
		}
		
		N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			int idx = Integer.parseInt(br.readLine()); // 출발 index 받아오기
			rock[idx-1].insert();
			for (int j = 0; j < C; j++) {
				rock[j].init();
			}
		}
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				sb.append(map[i][j]);
			}
			sb.append('\n');
		}
		System.out.println(sb.toString());

	}
	
	static class Rock{
		int r;
		int col[];
		
		public Rock(int idx, int c) {
			this.col = new int[c];
			this.col[0] = idx;
			this.r = 1;
			init();
		}
		
		public void init() {
			while(true) {
				int cur = col[r-1];
				
				if(r>1 && map[r-1][cur] != '.') {
					r--;
				}
				
				else if(r==R) break;
				
				else if(map[r][cur] == 'X') break;
				
				else if(map[r][cur] == '.') col[r++] = cur;
				
				else {
					if(cur > 0 && map[r][cur-1] == '.' && map[r-1][cur-1] == '.') col[r++] = cur-1;
					else if(cur+1<C && map[r][cur+1]=='.' && map[r-1][cur+1] == '.') col[r++] = cur+1;
					else break;
				}
			}
		}
		
		public void insert() {
			map[r-1][col[r-1]] = 'O';
		}
	}

}