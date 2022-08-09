package swea.암호문1_1228;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_T {
	
	static int N, M;
	static List<String> list = new LinkedList<>();
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t=1;t<=10;t++) {
			list.clear();
			
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				list.add(st.nextToken());
			}
			
			M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<M;i++) {
				st.nextToken(); // I
				int x = Integer.parseInt(st.nextToken()); // x 인덱스
				int y = Integer.parseInt(st.nextToken()); // y 삽입할 문자열의 수
				int count = x+y;
				for(int j=x;j<count;j++) {
					list.add(j,st.nextToken());
				}
			}
			
			// 출력 처음 10개
			sb.append("#").append(t).append(" ");
			for(int i=0;i<10;i++) {
				sb.append(list.get(i)).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());

	}

}
