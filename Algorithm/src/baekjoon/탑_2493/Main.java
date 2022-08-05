package baekjoon.탑_2493;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static Deque<Top> top = new ArrayDeque<>(); 
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		for(int i=1;i<=N;i++) {
			int curT = Integer.parseInt(st.nextToken());
			while(!top.isEmpty()) {
				if(curT > top.getLast().h) {
					top.removeLast();
				}else {
					sb.append(top.getLast().idx).append(" ");
					break;
				}
			}
			if(top.isEmpty()) sb.append("0 ");
			top.add(new Top(curT, i));
		}
		System.out.println(sb.toString());
	}
	
	static class Top{
		int h;
		int idx;
		public Top(int h, int idx) {
			super();
			this.h = h;
			this.idx = idx;
		}	
	}
}
