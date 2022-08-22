package swea.Contact_1238;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static int N, V, ans;
	static boolean[] visit;
	static Person[] p = new Person[101];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 1; t <= 10; t++) {
			StringTokenizer st= new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			V = Integer.parseInt(st.nextToken());
			
			init();
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N/2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				p[from].add(to);
			}
			
			call(V);
			
			System.out.println("#" + t + " " + ans);
		}

	}
	
	static void call(int start) {
		Queue<Call> q = new ArrayDeque<>();
		q.add(new Call(start,0));
		visit[start] = true;
		int cntMax = 0;
		
		while(!q.isEmpty()) {
			Call c = q.poll();
			int cnt = c.cnt;
			Person person = p[c.pIdx];
			if(cntMax < cnt) {
				ans = c.pIdx;
				cntMax = cnt;
			}
			if(cntMax == cnt) ans = Math.max(ans, c.pIdx);
			
			for (int i = 0; i < person.getLength(); i++) {
				int to = person.to.get(i);
				if(visit[to]) continue;
				visit[to] = true;
				q.add(new Call(to, cnt+1));
			}
		}
	}
	
	static void init() {
		visit = new boolean[101];
		ans = 0;
		for (int i = 1; i <= 100; i++) {
			p[i] = new Person();
		}
	}
	
	static class Person{
		List<Integer> to = new ArrayList<>();
		
		public void add(int idx) {
			for (int i = 0; i < to.size(); i++) {
				if(to.get(i) == idx) return;
			}
			to.add(idx);
		}
		
		public int getLength() {
			return to.size();
		}
	}
	
	static class Call{
		int pIdx;
		int cnt;
		
		public Call(int pIdx, int cnt) {
			this.pIdx = pIdx;
			this.cnt = cnt;
		}
	}

}
