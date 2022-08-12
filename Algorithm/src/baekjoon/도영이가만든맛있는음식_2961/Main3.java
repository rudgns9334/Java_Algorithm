package baekjoon.도영이가만든맛있는음식_2961;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 바이너리 카운트
public class Main3 {

	static int N, ans;
	static int[][] food;
	static boolean[] select;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		ans = Integer.MAX_VALUE;
		food = new int[N][2];
		select = new boolean[N];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			food[i][0] = Integer.parseInt(st.nextToken());
			food[i][1] = Integer.parseInt(st.nextToken());
		}
		
		subset();
		
		System.out.println(ans);

	}
	
	static void subset() {
		for (int i = 0; i < (1<<N); i++) {
			int S = 1;
			int B = 0;
			int cnt = 0;
			for (int j = 0; j < N; j++) {
				if((i & (1<<j))!=0) {
					S *= food[j][0];
					B += food[j][1];
					cnt++;
				}
			}
			if(cnt>0)ans = Math.min(ans, Math.abs(S-B));
		}
	}

}
