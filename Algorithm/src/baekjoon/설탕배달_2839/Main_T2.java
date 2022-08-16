package baekjoon.설탕배달_2839;

import java.util.Scanner;

public class Main_T2 {

	static int N, count;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		count = 0;
		while(true) {
			// 안전 장치
			if(N<0) {
				System.out.println(-1);
				break;
			}
			if(N%5 == 0) { // 5로 나누어지는지, 우선적으로 확인
				System.out.println(N/5 + count);
				break;
			}else { // 3을 하나 쓴다.
				count++;
				N -= 3;
			}
		}
	}

}
