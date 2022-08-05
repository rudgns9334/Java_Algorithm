package baekjoon.회전초밥_2531;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	
	static int N,d,k,c,sum;
	static Deque<Integer> dq = new ArrayDeque<Integer>();
	static Deque<Integer> eat = new ArrayDeque<Integer>();
	static int[] kind;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		sum = 0;
		kind = new int[d+1];
		kind[c]++;
		
		for(int i=0;i<N;i++) {
			dq.addLast(Integer.parseInt(br.readLine()));
			eat.addLast(dq.getLast());
			kind[eat.getLast()]++;
			if(eat.size() == k) {
				int max = 0;
				for(int j=1;j<=d;j++) {
					if(kind[j]>0) max++;
				}
				sum = Math.max(sum, max);
				int rm = eat.removeFirst();
				kind[rm]--;
			}
		}
		for(int i=0;i<k-1;i++) {
			eat.add(dq.removeFirst());
			kind[eat.getLast()]++;
			if(eat.size() == k) {
				int max = 0;
				for(int j=1;j<=d;j++) {
					if(kind[j]>0) max++;
				}
				sum = Math.max(sum, max);
				int rm = eat.removeFirst();
				kind[rm]--;
			}
		}
		System.out.println(sum);
		
	}

}