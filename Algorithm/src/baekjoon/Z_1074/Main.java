package baekjoon.Z_1074;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N,r,c,ans;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		ans = 0;
		int size = (int) Math.pow(2, N);
		Z(size, 0, 0);
		
		System.out.println(ans);

	}
	
	static void Z(int size, int y, int x) {
		// 기저조건
		if(size == 1) return;
		// 2사분면
		if(r < y+size/2 && c < x+size/2) {
			Z(size/2, y, x);
		}
		// 1사분면
		if(r < y+size/2 && c >= x+size/2) {
			ans += (size/2) * (size/2);
			Z(size/2, y, x+size/2);
		}
		// 3사분면
		if(r >= y+size/2 && c < x+size/2) {
			ans += ((size/2) * (size/2))*2;
			Z(size/2, y+size/2, x);
		}
		// 4사분면
		if(r >= y+size/2 && c >= x+size/2) {
			ans += ((size/2) * (size/2))*3;
			Z(size/2, y+size/2, x+size/2);
		}
	}

}
