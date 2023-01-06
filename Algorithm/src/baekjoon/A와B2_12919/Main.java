package baekjoon.A와B2_12919;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	static String S, T;
	static int ans;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		S = br.readLine();
		T = br.readLine();
		
		ans = 0;
		
		start(S);

		System.out.println(ans);
	}
	
	static void start(String str) {
		if(ans == 1) return;
		
		StringBuffer sb;
		
		sb = new StringBuffer(str);
		if(!T.contains(str)) {
			if(!T.contains(sb.reverse().toString())) {
				return;
			}
		}
		
		if(check(str)) {
			if(str.equals(T)) ans = 1;
			return;
		}
		
		start(str+"A");
		sb = new StringBuffer(str+"B");
		String newStr = sb.reverse().toString();
		start(newStr);
	}
	
	static boolean check(String str) {
		if(str.length() == T.length()) {
				return true;
		}else return false;
	}

}
