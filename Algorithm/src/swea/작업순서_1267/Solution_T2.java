package swea.작업순서_1267;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//dfs
public class Solution_T2 {

	static int V, E;
	static boolean[] visit;
	static boolean[][] matrix;
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 1; t <= 10; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			visit = new boolean[V+1];
			matrix = new boolean[V+1][V+1];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < E; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				matrix[from][to] = true;
				
			}
			sb.append('#').append(t).append(' ');
			// 위상정렬
			
			for (int i = 1; i <= V; i++) { // 모든 정점에서 dfs() 시도
				// 이미 방문한(선행된) 정점이 있으면 skip
				if(visit[i]) continue;
				dfs(i);
				
			}
			
			sb.append('\n');
		}
		System.out.println(sb.toString());
	}

	static void dfs(int v) {
		visit[v] = true;
		
		for (int i = 1; i <= V; i++) {
			if( matrix[i][v] && !visit[i] ) dfs(i);
		}
		
		sb.append(v).append(' ');
	}
}
