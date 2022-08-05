package baekjoon.카드2_2164;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static int N;
	static Queue<Integer> q = new LinkedList<>();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		for(int i=1;i<=N;i++) {
			q.add(i);
		}
		
		while(q.size()>1) {
			q.poll();
			q.add(q.poll());
		}
		System.out.println(q.poll());
	}
}
