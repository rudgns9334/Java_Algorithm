package swea.암호생성기_1225;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static Queue<Integer> q = new LinkedList<>();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for(int t=1;t<=10;t++) {
			br.readLine();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0;i<8;i++) {
				q.add(Integer.parseInt(st.nextToken()));
			}
			make_pass();
			System.out.print("#"+t);
			for(int i=0;i<8;i++) {
				System.out.print(" " + q.poll());
			}
			System.out.println();
		}
	}
	
	static void make_pass() {
		int a = 0;
		for(int i=1;i<=5;i++) {
			a = q.poll();
			a -= i;
			if(a<=0) {
				a = 0;
				q.add(0);
				break;
			}
			q.add(a);
		}
		if(a==0) return;
		make_pass();
	}

}
