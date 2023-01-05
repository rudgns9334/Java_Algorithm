package baekjoon.하늘에서별똥별이빗발친다_14658;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N, M, L, K;
	static int maxCnt;
	
	static List<Node> list;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			maxCnt = 0;
			
			list = new ArrayList<>();
			
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				list.add(new Node(a,b));
			}
			
			for (Node n1 : list) {
				for (Node n2 : list) {
					
					int cnt = 0;
					for (Node n3 : list) {
						if(n1.x <= n3.x && n1.x+L>=n3.x && n2.y <= n3.y && n2.y+L >= n3.y) cnt++;
					}
					
					if(maxCnt < cnt) {
						maxCnt = cnt;
					}
				}
			}
			
			System.out.println(K-maxCnt);
			
	}
	
	static class Node{
		int x, y;
		
		Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}

}
