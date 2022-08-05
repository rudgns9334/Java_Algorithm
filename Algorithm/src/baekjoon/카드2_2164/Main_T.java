package baekjoon.카드2_2164;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main_T {

	static int N;
	static Deque<Integer> deque = new ArrayDeque<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		for(int i=1;i<=N;i++) deque.add(i);

		while(deque.size() > 1) {
			deque.remove();
			deque.add(deque.remove());
		}
		System.out.println(deque.getLast());
	}

}
