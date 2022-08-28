package swea.낚시터자리잡기_test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static int T, N, ans;
	static int[] index;
	static int[] wait;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			
			index = new int[3];
			wait = new int[N+1];
			ans = Integer.MAX_VALUE;
			
			for (int i = 0; i < 3; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				index[i] = Integer.parseInt(st.nextToken());
				wait[index[i]] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(index);
			
			while(true) {
				boolean[] visit = new boolean[N+1];
				
				dfs(0,0, visit);
				
				if(!np()) break;
			}
			System.out.println("#" + t + " " + ans);
			
		}

	}
	
	static void dfs(int idx, int sum, boolean[] visit) {
		if(sum > ans) return;
		if(idx == 3) {
			ans = Math.min(ans, sum);
			return;
		}
		
		int cnt = 0;
		int i = 0;
		int degree = 0;
		int num = index[idx];
		while(cnt < wait[num]) {
			if(num-i>0 && !visit[num-i]) {
				visit[num-i] = true;
				cnt++;
				degree += i+1;
				if(num+i<=N && cnt == wait[num] && !visit[num+i]) {
					boolean[] back;
					back = Arrays.copyOf(visit, N+1);
					dfs(idx+1, sum+degree, visit);
					visit = Arrays.copyOf(back, N+1);
					cnt--;
					degree -= i+1;
					visit[num-i] = false;
				}
			}
			if(num+i<=N && !visit[num+i]) {
				visit[num+i] = true;
				cnt++;
				degree += i+1;
			}
			i++;
		}
		dfs(idx+1, sum+degree, visit);
	}
	
	static boolean np() {
		int i = 2;
		while(i>0 && index[i-1] >= index[i]) --i;
		if(i==0) return false;
		
		int j = 2;
		while(index[i-1] >= index[j]) --j;
		swap(i-1, j);
		
		int k = 2;
		while(i<k) swap(i++,k--);
		
		return true;
	}
	
	static void swap(int i, int j) {
		int temp = index[i];
		index[i] = index[j];
		index[j] = temp;
	}

}