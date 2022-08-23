package swea.최소스패닝트리_3124;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {

	static int T, V, E;
	static long ans;
	static int[] parent;
	static PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			ans = 0;
			pq.clear();
			parent = new int[V+1]; // 0은 dummy
			makeSet();
			
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				
				pq.add(new Node(a,b,c));
			}
			
			kruskal();
			
			System.out.println("#" + t + " " + ans);
		}

	}
	
	static void kruskal() {	
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			if(findSet(node.v1) == findSet(node.v2)) {
				continue;
			}else {
				ans += node.w;
				union(node.v1, node.v2);
			}
		}
	}
	
	// 서로소 집합 관련 메소드들
		static void makeSet() {
			for (int i = 0; i <= V; i++) {
				parent[i] = i;
			}
		}

		// 부모를 찾는(부모 번호 == 집합)
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
	
	static class Node{
		int v1,v2,w;
		
		public Node(int v1, int v2, int w) {
			this.v1 = v1;
			this.v2 = v2;
			this.w = w;
		}
	}

}
