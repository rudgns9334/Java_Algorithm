package baekjoon.설탕배달_2839;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static int N, ans;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		ans = check();
		
		System.out.println(ans);
	}

	static int check() {
		if( N==4 || N==7) return -1;
		else if(N%5 == 0) return N/5;
		else if(N%5 == 1 || N%5 == 3) return (N/5) +1;
		else if(N%5 == 2 || N%5 == 4) return (N/5) +2;
		return 0;
	}
}
