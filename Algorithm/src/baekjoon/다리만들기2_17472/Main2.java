package baekjoon.다리만들기2_17472;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// 프림으로 푼거
public class Main2 {
	
	static int N, M, V, sum;
	static int[][] map;
	static boolean[][] visit;
	static boolean[] ver;
	static List<Island> list = new ArrayList<>();
	static int[][] edges;
	static PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2) -> e1.w - e2.w);
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
		
		ver = new boolean[V+1];
		prim();
		
		System.out.println(sum == 0 ? -1 : sum);
		
	}
	
	static void prim() {
		// 시작 정점 선택
		// 1번 정점부터
		int cnt = 1;
		ver[1] = true;
		
		for (int i = 1; i <= V; i++) {
			if(edges[1][i] != 0) pq.add(new Edge(1,i, edges[1][i]));
		}
		
		
		while(!pq.isEmpty()) {
			Edge edge = pq.poll();
			if(ver[edge.v2]) continue; // 새로 최소비용으로 연결하려는 정점이 이미 방문(연결)한 정점이면 skip
			
			//새로운 정점을 연결(방문)
			ver[edge.v2] = true;
			sum += edge.w; // 새로 방문(연결)하는 정점으로 가는 비용 누적
			cnt++; // 연결한 정점의 수 증가
			if(cnt == V) break; // 필요한 모든 정점을 다 연결(방문)
			for (int i = 1; i <= V; i++) {
				if(edges[edge.v2][i] != 0) pq.add(new Edge(edge.v2,i, edges[edge.v2][i]));
			}
		}
		
		for (int i = 1; i <= V; i++) {
			if(!ver[i]) sum = 0;
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
