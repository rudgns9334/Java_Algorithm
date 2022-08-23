package swea.최소스패닝트리_3124;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// Prim
public class Solution2 {

	static int T, V, E;
	static long ans;
	static Vertex[] vertex;
	static boolean[] visit;
//	static PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			ans = 0;
			visit = new boolean[V+1]; // 0 dummy
			vertex = new Vertex[V+1]; // 0 dummy
			
			for (int i = 0; i <= V; i++) {
				vertex[i] = new Vertex(i);
			}
			
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				
				vertex[a].list.add(new Node(b,c));
				vertex[b].list.add(new Node(a,c));
			}
			
			prim(1);
			
			System.out.println("#" + t + " " + ans);
		}

	}
	
	static void prim(int s) {
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);
		pq.add(new Node(s, 0));
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			if(!visit[node.v]) {
				visit[node.v] = true;
				ans += node.w;
			}else continue;
			
			for (int i = 0; i < vertex[node.v].list.size(); i++) {
				Node n = vertex[node.v].list.get(i);
				if(visit[n.v]) continue;
				pq.add(new Node(n.v, n.w));
			}
			
		}
	}
	
	
	static class Vertex{
		int v;
		List<Node> list = new ArrayList<>();
		
		public Vertex(int v) {
			this.v = v;
		}
	}
	
	static class Node{
		int v,w;
		
		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}

}
