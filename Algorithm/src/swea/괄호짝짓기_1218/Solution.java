package swea.괄호짝짓기_1218;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {

	static int N,ans;
	static String str;
	static Stack<Character> stack = new Stack<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		for(int t=1;t<=10;t++) {
			N = Integer.parseInt(br.readLine());
			str = br.readLine();
			stack.clear();
			
			ans = 1;
			for(int i=0;i<N;i++) {
				char check;
				char in = str.charAt(i);
				switch(in) {
				case '(': stack.push(in); break;
				case '[': stack.push(in); break;
				case '{': stack.push(in); break;
				case '<': stack.push(in); break;
				case '>': {
					check = stack.peek();
					if(check != '<') {
						ans = 0;
					}else {
						stack.pop();
					}
					break;
				}
				case '}': {
					check = stack.peek();
					if(check != '{') {
						ans = 0;
					}else {
						stack.pop();
					}
					break;
				}
				case ']': {
					check = stack.peek();
					if(check != '[') {
						ans = 0;
					}else {
						stack.pop();
					}
					break;
				}
				case ')': {
					check = stack.peek();
					if(check != '(') {
						ans = 0;
					}else {
						stack.pop();
					}
					break;
				}
				}
				if(ans == 0) break;
			}
			if(!stack.isEmpty()) ans = 0;
			sb.append("#").append(t).append(" ").append(ans).append("\n");
			
		}
		System.out.println(sb.toString());
	}

}
