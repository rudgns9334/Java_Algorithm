package swea.pro섬지키기_14596;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class UserSolution
{
	static int n, m;
	static int map[][];
	static int tmp[][];
	static int[] structure;
	
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	public void init(int N, int mMap[][])
	{
		n = N;
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = mMap[i][j];
			}
		}
	}

	public int numberOfCandidate(int M, int mStructure[])
	{
//		System.out.println("numberOfCandidate");
		m = M;
		structure = mStructure.clone();
		int cnt = match();
//		System.out.println(cnt);
		return cnt;
	}

	public int maxArea(int M, int mStructure[], int mSeaLevel)
	{
//		System.out.println("maxArea");
		int maxCnt = -1;
		m = M;
		structure = mStructure.clone();
		
		List<Node> nodes = setStructure();
		if(nodes.isEmpty()) {
//			System.out.println(maxCnt);
			return maxCnt;
		}
//		maxCnt = 0;
		for (Node node : nodes) {
			if(node.h < mSeaLevel) continue;
			tmp = new int[n+2][n+2];
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					tmp[i][j] = map[i-1][j-1];
				}
			}
			
			int ny = node.y + 1;
			int nx = node.x + 1;
			tmp[ny][nx] = node.h;
			for (int i = 1; i < m; i++) {
				ny += dy[node.d];
				nx += dx[node.d];
				tmp[ny][nx] = node.h;
			}
			int cnt = bfs(mSeaLevel);
//			if(cnt == 3) System.out.println("ho");
			maxCnt = Math.max(cnt, maxCnt);
		}
		if(maxCnt == -1) {
			maxCnt = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if(map[i][j] >= mSeaLevel) maxCnt++;
				}
			}
		}
//		System.out.println(maxCnt);
		return maxCnt;
	}
	
	static int match() {
		
		int cnt = 0;
		if(m == 1) {
			cnt = n*n;
			return cnt;
		}
		// 좌에서 우 비교
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int high = map[i][j] + structure[0];
				
				for (int d = 0; d < 4; d++) {
					if(i + dy[d]*(m-1) < 0) continue;
					if(i + dy[d]*(m-1) >= n) continue;
					if(j + dx[d]*(m-1) < 0) continue;
					if(j + dx[d]*(m-1) >= n) continue;
					int k = 1;
					int ny = i;
					int nx = j;
					while(k < m) {
						ny += dy[d];
						nx += dx[d];
						if(high != map[ny][nx] + structure[k]) break;
						k++;
					}
					if(k == m) {
//						System.out.println("i : "+i+" j : "+j);
						cnt++;
					}
				}
			}
		}
		boolean ok = true;
		for (int i = 0; i < m/2; i++) {
			if(structure[i] != structure[m-i-1]) {
				ok = false;
				break;
			}
		}
		if(ok) cnt = cnt/2;
		
		return cnt;
	}
	
static List<Node> setStructure() {

		List<Node> nodes = new ArrayList<>();
		// 좌에서 우 비교
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int high = map[i][j] + structure[0];
				
				for (int d = 0; d < 4; d++) {
					if(i + dy[d]*(m-1) < 0) continue;
					if(i + dy[d]*(m-1) >= n) continue;
					if(j + dx[d]*(m-1) < 0) continue;
					if(j + dx[d]*(m-1) >= n) continue;
					int k = 1;
					int ny = i;
					int nx = j;
					
					while(k < m) {
						ny += dy[d];
						nx += dx[d];
						if(high != map[ny][nx] + structure[k]) break;
						k++;
					}
					if(k == m) {
//						System.out.println("i : "+i+" j : "+j);
						nodes.add(new Node(i, j, d, high));
					}
				}
			}
		}
		
		return nodes;
	}

	static int bfs(int level) {
		int cnt = 0;
		boolean[][] visit = new boolean[n+2][n+2];
		for (int i = 0; i < n+2; i++) {
			for (int j = 0; j < n+2; j++) {
				if(visit[i][j]) continue;
				if(tmp[i][j] >= level) continue;
				if(tmp[i][j] == 0) {
					PriorityQueue<Vertex> pq = new PriorityQueue<>((v1,v2)->v1.y - v2.y);
					pq.add(new Vertex(i,j));
					visit[i][j] = true;
					cnt++;
					while(!pq.isEmpty()) {
						Vertex v = pq.poll();
						
						for (int k = 0; k < 4; k++) {
							int ny = v.y + dy[k];
							int nx = v.x + dx[k];
							
							if(ny<0 || nx<0 || ny>=n+2 || nx>=n+2) continue;
							if(visit[ny][nx]) continue;
							if(tmp[ny][nx] < level) {
								visit[ny][nx] = true;
								cnt++;
								pq.add(new Vertex(ny,nx));
							}
						}
					}
				}
			}
		}
		return (n+2)*(n+2) - cnt;
	}

	static class Node{
		int y, x, d, h;
		Node(int y, int x, int d, int h){
			this.y = y;
			this.x = x;
			this.d = d;
			this.h = h;
		}
	}
	
	static class Vertex{
		int y,x;
		Vertex(int y, int x){
			this.y = y;
			this.x = x;
		}
	}
}