package baekjoon.DFS와BFS_1260;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_T2 {

	static int N, M, V;
	static ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>(); // 방문할 수 있는 정점 관계
	static boolean[] visit;
	static Queue<Integer> queue = new ArrayDeque<>();
	static StringBuilder ans = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());

		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<Integer>());
		}
		
		visit = new boolean[N+1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			list.get(n1).add(n2);
			list.get(n2).add(n1);
		}
		
		// 작은 수부터 정렬
		for (int i = 1; i <= N; i++) {
			Collections.sort(list.get(i));
		}
		//dfs 
		visit[V] = true;
		dfs(V);
		
		// 맨 뒤 문자를 개행문자로 변경
		ans.setCharAt(ans.length()-1, '\n');
		
		// visit 초기화
		for (int i = 1; i <= N; i++) {
			visit[i] = false;
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
		int size = list.get(num).size();
		for (int i = 0; i < size; i++) { // 1~N의 정점중
			int v = list.get(num).get(i); // v : 방문하려는 정점
			if(visit[v]) continue;
			visit[v] = true;
			dfs(v);
		}	
	}
	
	static void bfs() {
		visit[V] = true;
		queue.offer(V);
		
		while(!queue.isEmpty()) {
			int num = queue.poll();
			ans.append(num).append(" ");
			
			int size = list.get(num).size();
			for (int i = 0; i < size; i++) { // 1~N의 정점중
				int v = list.get(num).get(i); // v : 방문하려는 정점
				if(visit[v]) continue;
				visit[v] = true;
				queue.offer(v);
			}	
		}
	}

}
