package swea.창용마을무리의개수_7465;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int T, N, M, ans;
	static int[] parent;
	static boolean[] visit;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			ans = 0;
			parent = new int[N+1]; // 0 dummy;
			visit = new boolean[N+1];
			makeSet();
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				union(a,b);
			}
			
			for (int i = 1; i <= N; i++) {
				if(!visit[findSet(i)]) {
					visit[findSet(i)] = true;
					ans++;
				}
			}
			
			System.out.println("#" + t + " " + ans);
			
			
		}

	}
	
	static void makeSet() {
		for (int i = 0; i <= N; i++) {
			parent[i] = i;
		}
	}
	
	static int findSet(int x) {
		if(parent[x] == x) return x;
		else return parent[x] = findSet(parent[x]);
	}

	static void union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);
		if(px < py) parent[py] = px;
		else parent[px] = py;
	}
}
