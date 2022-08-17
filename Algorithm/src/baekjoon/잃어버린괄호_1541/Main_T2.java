package baekjoon.잃어버린괄호_1541;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_T2 {
	
	static int sum;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stMinus = new StringTokenizer(br.readLine(),"-");
		
		int sizeMinus = stMinus.countTokens(); // 현재 시점에 남아 있는 토큰의 수
		for (int i = 0; i < sizeMinus; i++) {
			String token = stMinus.nextToken();
			
			int num = 0;
			StringTokenizer stPlus = new StringTokenizer(token,"+");
			int sizePlus = stPlus.countTokens();
			
			for (int j = 0; j < sizePlus; j++) {
				num += Integer.parseInt(stPlus.nextToken());
			}
			
			if(i==0) sum = num; // 맨 앞 숫자
			else sum -= num;
		}
		
		System.out.println(sum);
	}
	

}
