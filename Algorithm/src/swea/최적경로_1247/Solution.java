package swea.최적경로_1247;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	
	static int T,N,cy,cx,hy,hx,ans;

	static boolean[] visit;
	static List<Node> list = new ArrayList<>();
	static int[][] dist;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			list.clear();
			N = Integer.parseInt(br.readLine());
			visit = new boolean[N+2];
			dist = new int[N+2][N+2]; // 0은 회사 N+1은 집
			StringTokenizer st = new StringTokenizer(br.readLine());
			cy = Integer.parseInt(st.nextToken());
			cx = Integer.parseInt(st.nextToken());
			hy = Integer.parseInt(st.nextToken());
			hx = Integer.parseInt(st.nextToken());
			
			ans = Integer.MAX_VALUE;
			
			// 첫 회사 노드 입력
			list.add(new Node(cy, cx));
			// 1~N번까지 고객 노드 생성
			for (int i = 0; i < N; i++) {
				list.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}
			// 집 노드 생성
			list.add(new Node(hy, hx));
			
			// 가중치 입력
			for (int i = 0; i < N+2; i++) {
				for (int j = 0; j < N+2; j++) {
					dist[i][j] = Math.abs(list.get(i).y - list.get(j).y) + Math.abs(list.get(i).x - list.get(j).x);
				}
			}
			
			visit[0] = true;
			dfs(0, 0, 0);
			
			
			System.out.println("#" + t + " " + ans);
		}

	}
	
	static void dfs(int idx, int sum, int cnt) {
		if(cnt == N) {
			sum = sum + dist[idx][N+1];
			ans = Math.min(ans, sum);
			return;
		}
		
		for (int i = 1; i <= N; i++) {
			int d = dist[idx][i];
			if(!visit[i]) {
				visit[i] = true;
				if(sum + d < ans) dfs(i, sum+d, cnt+1);
				visit[i] = false;
			}
		}
	}
	
	
	static class Node{
		int y, x;
		
		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

}
