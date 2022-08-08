package baekjoon.요세푸스문제_1158;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

//Queue
public class Main_T2 {

	static int N, K;
	static Queue<Integer> queue = new ArrayDeque<>();
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		for(int i=1;i<=N;i++) {
			queue.offer(i);
		}
		
		// 변수들
		int alive = 1; // 1부터 계속 증가, 살아 있는 번호에서만 증가
		sb.append("<");
		while(!queue.isEmpty()) {
			
			int num = queue.poll();
			 
			// alive % K ==0
			if(alive % K == 0) {
				sb.append(num).append(", ");
			}else {
				queue.offer(num);
			}
			alive++;
		}
		
		// 뒷부분 출력 정리
		sb.setLength(sb.length() - 2); // 끝부분 2개 빼기
		sb.append(">");
		System.out.println(sb.toString());
	}

}
