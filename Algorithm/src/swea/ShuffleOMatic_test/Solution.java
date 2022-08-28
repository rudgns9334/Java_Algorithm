package swea.ShuffleOMatic_test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static int T, N, ans;
	static Queue<Card> q = new ArrayDeque<>();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			ans = 0;
			q.clear();
			Card c = new Card(N, 0);
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				c.card[i] = Integer.parseInt(st.nextToken());
			}
			
			if(!check(c)) {
				q.add(c);
				bfs();
			}
	
			System.out.println("#" + t + " " + ans);
		}

	}
	
	static void bfs() {
		while(!q.isEmpty()) {
			Card card = q.poll();
			// i=0 0 1 2 0 1 2 <= 굳이 따질 필요가 없네
			// i=1 0 1 0 2 1 2
			// i=2 0 0 1 1 2 2
			for (int i = 1; i < N/2; i++) {
				int s = N/2 - i;
				int cnt = 0;
				while(true) {
					if(cnt == i) break;
					swap(card, s, s+1);
					cnt++;
					s += 2;
				}
				Card c = new Card(N, card.cnt+1);
				c.card = Arrays.copyOf(card.card, N);
				if(c.cnt > 5) {
					ans = -1;
					return;
				}
				if(check(c)) {
					ans = c.cnt;
					return;
				}
				q.add(c);
			}
			// i=3 0 0 1 1 2 2
			// i=4 0 1 0 2 1 2
			// i=5 0 1 2 0 1 2
			for (int i = N/2; i > 0; i--) {
				int s = N/2 - i;
				int cnt = 0;
				while(true) {
					if(cnt == i) break;
					swap(card, s, s+1);
					cnt++;
					s += 2;
				}
				Card c = new Card(N, card.cnt+1);
				c.card = Arrays.copyOf(card.card, N);
				if(c.cnt > 5) {
					ans = -1;
					return;
				}
				if(check(c)) {
					ans = c.cnt;
					return;
				}
				q.add(c);
			}
		}
	}
	
	static void swap(Card c, int i, int j) {
		int temp = c.card[i];
		c.card[i] = c.card[j];
		c.card[j] = temp;
	}
	
	static boolean check(Card c) {
		int i = N-1;
		while(i>0 && c.card[i-1] > c.card[i]) i--;
		if(i==0) return true;
		i = N-1;
		while(i>0 && c.card[i-1] < c.card[i]) i--;
		if(i==0) return true;
		return false;	
	}
	
	static class Card{
		int[] card;
		int cnt;
		
		public Card(int N, int cnt) {
			this.card = new int[N];
			this.cnt = cnt;
		}
	}
}