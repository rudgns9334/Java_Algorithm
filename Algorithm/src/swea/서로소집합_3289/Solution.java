package swea.서로소집합_3289;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	
	static int T, N, M;
	static List<Integer>[] list; 
	static boolean[] visit;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			sb = new StringBuilder();
			sb.append("#").append(t).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			list = new List[N+1];
			
			for (int i = 0; i <= N; i++) {
				list[i] = new ArrayList<>();
				list[i].add(i);
			}
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int mode = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				if(mode == 0) {
					sum(a,b);
				}else if(mode == 1) {
					find(a,b);
				}
			}
			System.out.println(sb.toString());
		}
	}
	// a = 1 3
	// b = 5 7
	static void sum(int a, int b) {
		list[a].add(b);
		list[b].add(a);
	}

	static void find(int a, int b) {
		visit = new boolean[N+1];
		Queue<Integer> q = new ArrayDeque<>();
		q.add(a);
		visit[a] = true;
		while(!q.isEmpty()) {
			int n = q.poll();
			if(n == b) {
				sb.append('1');
				return;
			}
			for (int i = 0; i < list[n].size(); i++) {
				int num = list[n].get(i);
				if(visit[num]) continue;
				visit[num] = true;
				q.add(num);
			}
		}
		
		sb.append('0');
	}
	
}
