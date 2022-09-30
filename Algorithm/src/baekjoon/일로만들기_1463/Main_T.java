package baekjoon.일로만들기_1463;

import java.util.Scanner;

public class Main_T {
	
	static int[] memoi;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		memoi = new int[N+1];
		
		memoi[1] = 0;
		
		for (int i = 2; i <= N; i++) {
			
			// 3가지 연산중 최소 비용을 선택해서 간다.
			
			// 1 빼는 ( 거꾸로 더하는 )
			memoi[i] = memoi[i-1] + 1;
			
			// 2로 나누는
			if( i % 2 == 0 ) memoi[i] = Math.min(memoi[i], memoi[i/2]+1);
				
			// 3으로 나누는
			if( i % 3 == 0 ) memoi[i] = Math.min(memoi[i], memoi[i/3]+1);
		}
		
		System.out.println(memoi[N]);

	}

}
