package baekjoon.도영이가만든맛있는음식_2961;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// dfs
public class Main {

	static int N, ans;
	static int[][] food;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		ans = Integer.MAX_VALUE;
		food = new int[N][2];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			food[i][0] = Integer.parseInt(st.nextToken());
			food[i][1] = Integer.parseInt(st.nextToken());
		}
		
		dfs(0,1,0);
		
		System.out.println(ans);

	}
	
	static void dfs(int idx, int S, int B) {
		if(idx==N) {
			if(S==1 && B==0) return;
			int diff = Math.abs(S-B);
			ans = Math.min(ans, diff);
			return;
		}
		
		dfs(idx+1, S, B);
		dfs(idx+1, S*food[idx][0], B+food[idx][1]);
	}

}
