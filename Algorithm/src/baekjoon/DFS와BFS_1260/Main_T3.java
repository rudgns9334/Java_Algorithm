package baekjoon.DFS와BFS_1260;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_T3 {

	static int N, M, V;
	static boolean[][] matrix; // 방문할 수 있는 정점 관계. 더미인 0을 visit으로 사용
//	static boolean[] visit; // 사용X
	static Queue<Integer> queue = new ArrayDeque<>();
	static StringBuilder ans = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());

		matrix = new boolean[N+1][N+1]; // 0 dummy
//		visit = new boolean[N+1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			matrix[n1][n2] = true;
			matrix[n2][n1] = true;
		}
		
		//dfs 
		matrix[V][0] = true; // index 0은 방문 여부
		dfs(V);
		
		// 맨 뒤 문자를 개행문자로 변경
		ans.setCharAt(ans.length()-1, '\n');
		
		// visit 초기화
		for (int i = 1; i <= N; i++) {
			matrix[i][0] = false;
		}
		//bfs
		bfs();
		
		// 마지막 문자 제거
		ans.setLength(ans.length()-1);
		System.out.println(ans.toString());
	}
	
	static void dfs(int num) {
		ans.append(num).append(" ");
		
		// num에서 갈 수 있는 다른 정점을 방문
		for (int i = 1; i <= N; i++) {
			if(!matrix[num][i] || matrix[i][0]) continue;
			matrix[i][0] = true;
			dfs(i);
		}	
	}
	
	static void bfs() {
		matrix[V][0] = true;
		queue.offer(V);
		
		while(!queue.isEmpty()) {
			int num = queue.poll();
			ans.append(num).append(" ");
			
			for (int i = 1; i <= N; i++) {
				if(!matrix[num][i] || matrix[i][0]) continue;
				matrix[i][0] = true;
				queue.offer(i);
			}
		}
	}

}

