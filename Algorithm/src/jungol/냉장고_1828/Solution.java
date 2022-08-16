package jungol.냉장고_1828;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static int N, idx, ans;
	static Chemical[] c;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		ans = 1;
		c = new Chemical[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			c[i] = new Chemical(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(c,(o1, o2) -> o1.minT==o2.minT ? o1.maxT - o2.maxT : o1.minT - o2.minT);
		idx = 0;
		for(int i=1;i<N;i++) {
			if(c[idx].maxT < c[i].minT) {
				ans++;
				idx = i;
			}
		}
		
		System.out.println(ans);

	}
	
	static class Chemical{
		int minT;
		int maxT;
		
		public Chemical(int minT, int maxT) {
			this.minT = minT;
			this.maxT = maxT;
		}
	}

}
