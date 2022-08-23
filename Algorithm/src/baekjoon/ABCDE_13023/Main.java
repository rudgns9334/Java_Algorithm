package baekjoon.ABCDE_13023;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, ans;
	static boolean[] check;
	static List<Integer>[] f;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ans = 0;
		f = new List[N];
		for (int i = 0; i < N; i++) {
			f[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			f[a].add(b);
			f[b].add(a);
		}
		for (int i = 0; i < N; i++) {
			if(ans == 1) break;
			check = new boolean[N];
			check[i] = true;
			dfs(i, 1);
		}
		

		System.out.println(ans);
	}

	static void dfs(int n, int depth) {
		if(depth == 5) {
			ans = 1;
			return;
		}
		for (int i = 0; i < f[n].size(); i++) {
			if(ans == 1) return;
			int next = f[n].get(i);
			if(check[next]) continue;
			check[next] = true;
			dfs(next,depth+1);
			check[next] = false;
		}
	}
}
