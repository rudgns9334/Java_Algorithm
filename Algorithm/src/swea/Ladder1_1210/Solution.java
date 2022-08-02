package swea.Ladder1_1210;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

	static int[] dx = {-1,1};
	
	static int T,d;
	static int sy,sx;
	
//	static ArrayList<Integer> start = new ArrayList<>();
	static int[][] ladder = new int[100][100];
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for(int tc=1;tc<=10;tc++) {
			T = Integer.parseInt(br.readLine());
			
			for(int i=0;i<100;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0;j<100;j++) {
					ladder[i][j] = Integer.parseInt(st.nextToken());
//					if(i==0 && ladder[i][j]==1) {
//						start.add(j);
//					}
				}
			}
			
			
			int rst = 0;
			
			// 뒤에서 시작하는 방법
			sy = 99;
			for(int i=0;i<100;i++) {
				if(ladder[sy][i] == 2) sx = i;
			}
			
			for(int i=99;i>=0;i--) {
				for(int j=0;j<2;j++) {
					int nx = sx + dx[j];
					if(nx<0 || nx>=100) continue;
					if(ladder[i][nx]==1) {
						while(true) {
							nx = nx + dx[j];
							if(nx<0 || nx>=100) break;
							if(ladder[i][nx]==0) break;
						}
						sx = nx-dx[j];
						break;
					}
				}
			}
			rst = sx;
			
			// 앞에서부터 차례로 탐색하는 방법
//			for (Integer s : start) {
//				int y = 0;
//				int x = s;
//				for(int i=1;i<100;i++) {
//					y = i;
//					for(int j=0;j<2;j++) {
//						int nx = x + dx[j];
//						if(nx<0 || nx>=100) continue;
//						if(ladder[y][nx]==1) {
//							while(true) {
//								nx = nx + dx[j];
//								if(nx<0 || nx>=100) break;
//								if(ladder[y][nx]==0) break;
//							}
//							x = nx-dx[j];
//							break;
//						}
//					}
//				}
//				if(ladder[y][x]==2) {
//					rst = s;
//					break;
//				}
//			}
			
			System.out.println("#"+tc+" "+rst);
			
		}
	}

}
