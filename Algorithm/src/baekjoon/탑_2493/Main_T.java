package baekjoon.탑_2493;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_T {

	static int N;
	static Deque<int[]> stack = new ArrayDeque<>();
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 1; i<= N; i++) { // index : 자리, 숫자 : height
			int height = Integer.parseInt(st.nextToken());
			
			// 도장깨기 ( 나보다 큰 놈 있으면 나와봐)
			while(!stack.isEmpty()) {
				// 나보다 큰 수 가 있으면 꾸벅 하고 큰 수의 index를 sb에 더하고 while을 끝낸다.
				if(stack.peek()[1] > height) {
					sb.append(stack.peek()[0]).append(" ");
					break;
				}
				// 나보다 작은 수를 만나면 (너 꺼져!) stack에서 제거 <== 중요
				stack.pop();
			}
			
			if(stack.isEmpty()) {
				sb.append("0 ");
			}
			
			stack.push(new int[] {i, height});
		}
		System.out.println(sb.toString());
	}

}
