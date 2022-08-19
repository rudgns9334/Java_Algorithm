package swea.준환이의양팔저울_3234;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int T, N, sum, ans;
	static int[] chu;
	static boolean[] used;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			chu = new int[N];
			used = new boolean[N];
			ans = 0;
			sum = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				chu[i] = Integer.parseInt(st.nextToken());
				sum += chu[i];
			}

			dfs(0,0,0);
			
			System.out.println("#" + t + " " + ans);
		}

	}
	
	static int calc(int idx) {
		if(idx == 0) return 1;
		return 2*idx * calc(idx-1);
	}
	
	static void dfs(int d, int leftSum, int rightSum) {
		if(d == N) {
			// complete code
			ans++;
			return;
		}
		if(sum <= 2*leftSum) { // sum - leftSum = rightSum < leftSum
			ans += calc(N-d);
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(used[i]) continue;
			if(leftSum + chu[i] >= rightSum) {
				used[i] = true;
				dfs(d+1, leftSum+chu[i], rightSum);
				used[i] = false;
			}
			if(leftSum >= rightSum + chu[i]) {
				used[i] = true;
				dfs(d+1, leftSum, rightSum+chu[i]);
				used[i] = false;
			}
		}
	}
}
