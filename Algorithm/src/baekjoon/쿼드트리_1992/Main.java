package baekjoon.쿼드트리_1992;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	static int N;
	static int[][] map;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N =  Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			char[] line = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				map[i][j] = line[j]-'0';
			}
		}
		
		check(0,0,N);
		
		System.out.println(sb.toString());

	}

	static void check(int y, int x, int size) {
		int cur = map[y][x];
		boolean same = true;
		for (int i = y; i < y+size; i++) {
			for (int j = x; j < x+size; j++) {
				if(map[i][j] != cur) {
					same = false;
					break;
				}
			}
		}
		
		if(!same) {
			sb.append("(");
			check(y, x, size/2);
			check(y, x+size/2, size/2);
			check(y+size/2, x, size/2);
			check(y+size/2, x+size/2, size/2);
			sb.append(")");
		}else {
			sb.append(cur);
		}
	}
}
