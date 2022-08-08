package baekjoon.요세푸스문제_1158;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	static int N, K;
	static Deque<Integer> dq = new ArrayDeque<>();
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		sb.append("<");
		
		for(int i=1;i<=N;i++) {
			dq.add(i);
		}
		int cnt = 1;
		while(!dq.isEmpty()) {
			if(cnt!=K) {
				dq.addLast(dq.pollFirst());
				cnt++;
			}else {
				sb.append(dq.pollFirst());
				cnt = 1;
				if(dq.isEmpty()) sb.append(">");
				else sb.append(", ");
			}
		}
		
		System.out.println(sb.toString());
		
		

	}

}
