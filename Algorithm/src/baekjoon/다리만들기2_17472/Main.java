package baekjoon.다리만들기2_17472;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 크루스칼로 푼거
public class Main {
	
	static int N, M, V, sum;
	static int[][] map;
	static int[] parent;
	static boolean[][] visit;
	static List<Island> list = new ArrayList<>();
	static int[][] edges;
	
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = 0;
		sum = 0;
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		makeIsland();
		
		edges = new int[V+1][V+1];
		
		makeBridge();
		
		kru();
		
		System.out.println(sum == 0 ? -1 : sum);
		
	}
	
	static void kru() {
		List<Edge> E = new ArrayList<>();
		for (int i = 1; i <= V; i++) {
			for (int j = i; j <= V; j++) {
				if(edges[i][j] != 0) {
					E.add(new Edge(i,j,edges[i][j]));
				}
			}
		}
		
		Collections.sort(E, (e1, e2)->e1.w-e2.w);
		parent = new int[V+1];
		makeSet();
		int cnt = 0; // 간선의 수 (V-1개 선택이 되면 종료)
		for (int i = 0; i < E.size(); i++) {
			Edge edge = E.get(i); // 이 간선이 연결하려는 두 정점에 대해서 cycle 체크
			if(union(edge.v1, edge.v2)) { // true이면 두 정점이 사이클이 생기지 않았고, 그래서 연결
				cnt++;
				sum += edge.w;
			}
			if(cnt == V - 1) break;
		}
		
		for (int i = 1; i < V; i++) {
			if(findSet(i) != findSet(i+1)) sum = 0;
		}
	}
	
	static void makeIsland() {
		visit = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(visit[i][j]) continue;
				if(map[i][j] == 1) {
					Island island = new Island();
					V = list.size()+1;
					Queue<int[]> q = new ArrayDeque<>();
					visit[i][j] = true;
					q.add(new int[] {i,j});
					
					while(!q.isEmpty()) {
						int[] pos = q.poll();
						int y = pos[0];
						int x = pos[1];
						map[y][x] = V;
						for (int d = 0; d < 4; d++) {
							int ny = y + dy[d];
							int nx = x + dx[d];
							
							if(ny<0 || nx<0 || ny>=N || nx>=M || visit[ny][nx]) {
								continue;
							}
							if(map[ny][nx] == 0) {
								island.V[d].add(new Node(y,x));
								continue;
							}
							
							visit[ny][nx] = true;
							q.add(new int[] {ny, nx});
						}
					}
					list.add(island);
				}
			}
		}
	}
	
	static void makeBridge() {
		for (int i = 0; i < V; i++) {
			Island is = list.get(i);
			
			for (int d = 0; d < 4; d++) {
				int size = is.V[d].size();
				for (int j = 0; j < size; j++) {
					Node n = is.V[d].get(j);
					int ny = n.y;
					int nx = n.x;
					int cnt = 0;
					while(true) {
						ny = ny + dy[d];
						nx = nx + dx[d];
						if(ny<0 || nx<0 || ny>=N || nx>=M) break;
						if(map[ny][nx] == 0) {
							cnt++;
						}else {
							if(cnt>=2) {
								int v1 = map[n.y][n.x];
								int v2 = map[ny][nx];
								if(edges[v1][v2] == 0) {
									edges[v1][v2] = cnt;
									edges[v2][v1] = cnt;
								}else if(edges[v1][v2] != 0 && cnt < edges[v1][v2]) {
									edges[v1][v2] = cnt;
									edges[v1][v2] = cnt;
								}
							}
							break;
						}
					}
				}
			}
		}
	}
	
	static void makeSet() {
		for (int i = 1; i <= V; i++) {
			parent[i] = i;
		}
	}
	
	// 부모를 찾는(부모 번호 == 집합)
	static int findSet(int x) {
		if(parent[x] == x) return x;
		else return parent[x] = findSet(parent[x]);
	}
	
	static boolean union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);
		if(px == py) return false;
		
		if(px < py) parent[py] = px;
		else parent[px] = py;
		
		return true;
	}
	
	static class Island{
		List<Node>[] V = new List[4];
		
		Island(){
			for (int i = 0; i < 4; i++) {
				V[i] = new ArrayList<>();
			}
		}
	}
	
	static class Edge{
		int v1, v2, w;
		Edge(int v1, int v2, int w){
			this.v1 = v1;
			this.v2 = v2;
			this.w = w;
		}
	}
	
	static class Node{
		int y,x;
		Node(int y, int x){
			this.y = y;
			this.x = x;
		}
	}
}
