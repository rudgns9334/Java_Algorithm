package swea.암호생성기_1225;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_T {
	
	static Queue<Integer> q = new LinkedList<>();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String tc = br.readLine();
			if(tc==null || tc.length() == 0) break; // 없거나, 공백문자이거나
			
			// 초기화
			q.clear();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0;i<8;i++) {
				q.offer(Integer.parseInt(st.nextToken()));
			}
			// 처리
			make();
			
			System.out.print("#"+tc);
			for (int n : q) {
				System.out.print(" "+n);
			}
			System.out.println();
		}
	}
	
	static void make() {
		int num = 0;
		while(true) {
			// 1 cycle
			// 1,2,3,4,5 순차적으로 감소
			for(int i=1;i<=5;i++) {
				num = q.poll() - i;
				
				if(num <= 0) {
					q.offer(0);
					return;
				}
				q.offer(num);
			}
		}
	}
}
