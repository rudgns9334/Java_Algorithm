package swea.프로세서연결하기_1767;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

//cell core
public class Solution {

	static int T, N, size, max, ans;
	static List<Node> core = new ArrayList<>();
	static int[] line,back;
	
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			core.clear();
			line = new int[N];
			max = 0;
			ans = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					int num = Integer.parseInt(st.nextToken());
					if(num == 1) {
						line[i] |= 1 << j;
						if(i==0 || j==0 || i==N-1 || j==N-1) continue;
						core.add(new Node(i,j));
					}
				}
			}
			
			size = core.size();
			
			back = Arrays.copyOf(line, N);
			dfs(0, 0, 0, back);
			
			System.out.println("#" + t + " " + ans);
		}

	}
	
	static void dfs(int idx, int sum, int cnt, int[] back) {
		// 기저 조건
		if(idx == size) {
			// complete code
			if(max < cnt) {
				max = cnt;
				ans = sum;
			}else if(max == cnt) {
				ans = Math.min(ans, sum);
			}
			
			return;
		}
		
		for (int d = 0; d < 4; d++) {
			int ny = core.get(idx).y;
			int nx = core.get(idx).x;
			int[] visit = Arrays.copyOf(back, N);
			int leng = 0;
			while(true) {
				ny = ny + dy[d];
				nx = nx + dx[d];
				if(ny<0 || nx<0 || ny>=N || nx>=N) { // 벽에 도달했을 때
					dfs(idx+1, sum+leng, cnt+1, visit);
					break;
				}
				if((visit[ny] & 1<<nx)!=0) { // 이미 지나간 line이 있을 때
					dfs(idx+1, sum, cnt, back);
					break;
				}
				leng++;
				visit[ny] |= 1 << nx;
				
				
			}
		}
	}
	
	
	static class Node{
		int y,x;
		
		public Node(int y, int x) {
			this.x = x;
			this.y = y;
		}
	}

}
