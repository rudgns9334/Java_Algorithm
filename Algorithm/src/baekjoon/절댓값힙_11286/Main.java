package baekjoon.절댓값힙_11286;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

	static int N;
	static PriorityQueue<Integer> pq 
	= new PriorityQueue<>((n1,n2)->Math.abs(n1) == Math.abs(n2)? n1 - n2 : Math.abs(n1)-Math.abs(n2));// 람다로 조건 설정 가능 // Integer를 natural ordering 순( 작은 수 부터 )
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if( num == 0 ) { // 꺼내서 출력, 없으면 null 0 출력
				Integer min = pq.poll();
				System.out.println(min == null ? 0 : min);
			}else {
				pq.offer(num);
			}
		}
	}

}
