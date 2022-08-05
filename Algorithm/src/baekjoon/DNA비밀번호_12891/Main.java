package baekjoon.DNA비밀번호_12891;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	static int S, P, sum;
	static String dna;
	static int[] condition = new int[4];
	static int[] count = new int[4];
	static Deque<Character> dq = new ArrayDeque<>();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		sum = 0;
		dna = br.readLine();
		dq.clear();
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<4;i++) {
			condition[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<S;i++) {
			dq.addLast(dna.charAt(i));
			if(dq.getLast()=='A') count[0]++;
			else if(dq.getLast()=='C') count[1]++;
			else if(dq.getLast()=='G') count[2]++;
			else if(dq.getLast()=='T') count[3]++;
			if(dq.size()== P) {
				if(condition[0]<=count[0] && condition[1]<=count[1] && condition[2]<=count[2] && condition[3]<=count[3]) {
					sum++;
				}
				char rm = dq.removeFirst();
				if(rm == 'A') count[0]--;
				else if(rm == 'C') count[1]--;
				else if(rm == 'G') count[2]--;
				else if(rm == 'T') count[3]--;
			}
			
		}
		System.out.println(sum);
	}

}
