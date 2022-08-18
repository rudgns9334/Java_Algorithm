package baekjoon.DFS와BFS_1260;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N,M,V;
	static List<Integer>[] map;
	static Queue<Integer> q = new ArrayDeque<>();
	static boolean[] visit;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		map = new List[N+1];
		for (int i = 0; i < N+1; i++) {
			map[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a].add(b);
			map[b].add(a);
		}
		
		visit = new boolean[N+1];
		dfs(V);
		sb.append("\n");
		visit = new boolean[N+1];
		bfs(V);
		
		System.out.println(sb.toString());
	}

	static void dfs(int v) {
		visit[v] = true;
		sb.append(v).append(" ");
		Collections.sort(map[v]);
		for (int ver : map[v]) {
			if(!visit[ver]) {
				dfs(ver);
			}
		}
	}
	
	static void bfs(int v) {
		q.add(v);
		visit[v] = true;
		while(!q.isEmpty()) {
			int s = q.poll();
			sb.append(s).append(" ");
			for (int ver : map[s]) {
				if(!visit[ver]) {
					visit[ver] = true;
					q.add(ver);
				}
			}
		}
	}
}
