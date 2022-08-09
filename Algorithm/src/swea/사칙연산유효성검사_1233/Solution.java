package swea.사칙연산유효성검사_1233;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int N,ans;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t=1;t<=10;t++) {
			N = Integer.parseInt(br.readLine());
			ans = 1;
			for(int i=0;i<N;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				if(ans == 0) continue;
				int cnt = st.countTokens();
				if(cnt == 4) {
					st.nextToken();
					char c = st.nextToken().charAt(0);
					if(c>='0' && c<='9') {
						ans = 0;
					}
				}else if(cnt == 2){
					st.nextToken();
					char c = st.nextToken().charAt(0);
					if(c=='+' || c=='-' || c=='*' || c=='/') {
						ans = 0;
					}
				}else if(cnt == 3) {
					ans = 0;
				}
			}
			System.out.println("#"+t+" "+ans);
		}
		
	}

}
