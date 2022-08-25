package swea.작업순서_1267;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static int V, E;
	static Vertex[] vertex;
	static boolean[] visit;
	static Queue<Integer> q = new ArrayDeque<>();
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 1; t <= 10; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			q.clear();
			
			vertex = new Vertex[V+1]; // 0은 dummy
			visit = new boolean[V+1];
			
			for (int i = 0; i <= V; i++) {
				vertex[i] = new Vertex();
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < E; i++) {
				int v1 = Integer.parseInt(st.nextToken());
				int v2 = Integer.parseInt(st.nextToken());
				vertex[v1].output.add(v2);
				vertex[v2].inputSize++;
			}
			
			for (int i = 1; i <= V; i++) {
				if(vertex[i].inputSize == 0) q.offer(i);
			}		
			
			sb.append('#').append(t).append(' ');
			
			search();
			
			sb.append('\n');
		}

		System.out.println(sb.toString());
	}
	
	static void search() {
		while(!q.isEmpty()) {
			int v = q.poll();
			sb.append(v).append(' ');
			for (int e : vertex[v].output) {
				vertex[e].inputSize--;
				if(vertex[e].inputSize == 0) q.offer(e);
			}
		}
	}
	
	
	static class Vertex{
		List<Integer> output = new ArrayList<>();
		int inputSize = 0;
	}
}
