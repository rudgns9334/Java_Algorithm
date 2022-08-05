package baekjoon.신기한소수_2023;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	static int N;
	static int[] prime;
	static int[] div = {2, 3, 5, 7};
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		prime = new int[N]; 
		make_p(0);
		System.out.println(sb.toString());
	}

	static void make_p(int cnt) {
		if(cnt == N) {
			for(int i=0;i<N;i++) {
				sb.append(prime[i]);
			}
			sb.append("\n");
			return;
		}
		int num = 0;
		prime[cnt] = 0;
		for(int i=0;i<=cnt;i++) {
			num += prime[i]*Math.pow(10, cnt-i);
		}
		for(int i=0;i<=9;i++) {
			int t = num + i;
			boolean p = true;
			if(t == 1 || t == 0) continue;
			int sqrt = (int) Math.sqrt(t);
			for(int j=2;j<=sqrt;j++) {
				if(t % j == 0) {
					p = false;
					break;
				}
			}
			if(p) {
				prime[cnt] = t%10;
				make_p(cnt+1);
			}
		}
		
	}
}
