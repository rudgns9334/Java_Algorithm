package baekjoon.색종이_2563;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, sx, sy, sum;
	static int[][] map = new int[100][100];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			sx = Integer.parseInt(st.nextToken());
			sy = Integer.parseInt(st.nextToken());
			
			for(int y=sy;y<sy+10;y++) {
				for(int x=sx;x<sx+10;x++) {
					if(map[y][x]==0) map[y][x]=1;
				}
			}
		}
		sum = 0;
		for(int i=0;i<100;i++) {
			for(int j=0;j<100;j++) {
				sum += map[i][j];
			}
		}
		System.out.println(sum);
	}
}
