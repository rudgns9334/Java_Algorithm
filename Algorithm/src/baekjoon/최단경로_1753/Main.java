package baekjoon.최단경로_1753;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int V, E, S;
	static Vertex[] vertices;
	static int[] dist;
	static boolean[] visit;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		S = Integer.parseInt(br.readLine());
		
		vertices = new Vertex[V+1]; // 0 dummy
		dist = new int[V+1];
		visit = new boolean[V+1];
		
		for (int i = 0; i <= V; i++) {
			vertices[i] = new Vertex(i);
			dist[i] = Integer.MAX_VALUE;
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			vertices[u].list.add(new Edge(v, w));
		}
		
		dijstra(S);
		
		for (int i = 1; i <= V; i++) {
			if(dist[i] == Integer.MAX_VALUE) System.out.println("INF");
			else System.out.println(dist[i]);
		}

	}
	
	static void dijstra(int start) {
		PriorityQueue<Edge> pq =  new PriorityQueue<>((e1, e2) -> e1.w - e2.w);
		pq.add(new Edge(start, 0));
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			Edge edge = pq.poll();
			if(visit[edge.v]) continue;
			visit[edge.v] = true;
			
			for (Edge e : vertices[edge.v].list) {
				if(!visit[e.v] && dist[e.v] > dist[edge.v] + e.w) {
					dist[e.v] = dist[edge.v] + e.w;
					pq.add(new Edge(e.v, dist[e.v]));
				}
			}
		}
	}
	
	static class Vertex{
		List<Edge> list = new ArrayList<>();
		int n;
		
		public Vertex(int n) {
			this.n = n;
		}
	}
	
	static class Edge{
		int v;
		int w;
		
		public Edge(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}

}
