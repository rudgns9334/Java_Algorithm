package baekjoon.스도쿠_2239;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static int[][] map;
	static boolean ok;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		map = new int[9][9];
		ok = false;
		for (int i = 0; i < 9; i++) {
			char[] c = br.readLine().toCharArray();
			for (int j = 0; j < 9; j++) {
				map[i][j] = c[j] - '0';
			}
		}
		
		dfs(0);
		
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		
		

	}
	
	static void dfs(int d) {
		if(d == 81) {
			ok = true;
			return;
		}
		
		int y = d/9;
		int x = d%9;
		
		if(map[y][x] != 0) {
			dfs(d+1);
		}else {
			for (int i = 1; i < 10; i++) {
				if(!valid(y,x,i)) continue;
				map[y][x] = i;
				dfs(d+1);
				if(ok) return;
				map[y][x] = 0;
			}
		}
	}
	
	static boolean valid(int y, int x, int n) {
		for (int i = 0; i < 9; i++) {
			if(map[y][i] == n || map[i][x] == n) return false;
		}
		
		int ny = y/3 * 3;
		int nx = x - x%3;
		for (int i = ny; i < ny+3; i++) {
			for (int j = nx; j < nx+3; j++) {
				if(map[i][j] == n) return false;
			}
		}
		return true;
	}

}
