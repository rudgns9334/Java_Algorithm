package swea.달팽이숫자_1954;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

	static int T,N,num,d,x,y;
	static int[][] snail;
	
	static int[] dy = {0,1,0,-1};
	static int[] dx = {1,0,-1,0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			N = Integer.parseInt(br.readLine());
			snail = new int[N][N];
			num = 1;
			d = 0;
			x = 0;
			y = 0;
			while(true) {
				if(snail[y][x]==0) {
					snail[y][x] = num++;
					int ny = y + dy[d];
					int nx = x + dx[d];
					if(ny<0 || nx<0 || ny>=N || nx>=N ||snail[ny][nx] != 0) {
						continue;
					}else {
						y = ny;
						x = nx;
					}
				}else {
					d = (d+1)%4;
					y = y + dy[d];
					x = x + dx[d];
					if(y<0 || x<0 || y>=N || x>=N || snail[y][x] != 0) {
						break;
					}
				}
			}
			System.out.println("#"+tc);
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					System.out.print(snail[i][j] + " ");
				}
				System.out.println();
			}
		}
		
	}

}
