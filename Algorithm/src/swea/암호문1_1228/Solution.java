package swea.암호문1_1228;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
public class Solution {
	
	static int N,M,x,y,s;
	static LinkedList<Integer> password = new LinkedList<>();
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t=1;t<=10;t++) {
			N = Integer.parseInt(br.readLine());
			password.clear();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				password.add(Integer.parseInt(st.nextToken()));
			}
			M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i<M;i++) {
				st.nextToken();
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				for(int j=0;j<y;j++) {
					s = Integer.parseInt(st.nextToken());
					password.add(x++, s);
				}
			}
			sb.append("#").append(t);
			for(int i=0;i<10;i++) {
				sb.append(" ").append(password.get(i));
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
