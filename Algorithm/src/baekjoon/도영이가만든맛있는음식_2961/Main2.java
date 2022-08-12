package baekjoon.도영이가만든맛있는음식_2961;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 부분 집합
public class Main2 {

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
		
		subset(0);
		
		System.out.println(ans);

	}
	
	static void subset(int idx) {
		
		if(idx == N) {
			int S = 1;
			int B = 0;
			for (int i = 0; i < N; i++) {
				if(select[i]) {
					S *= food[i][0];
					B += food[i][1];
				}
			}
			if(S==1 && B==0) return;
			int diff = Math.abs(S-B);
			ans = Math.min(ans, diff);
			return;
		}
		
		
		select[idx] = true;
		subset(idx+1);
		select[idx] = false;
		subset(idx+1);
	}

}
