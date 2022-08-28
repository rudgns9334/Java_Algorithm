package swea.헌터_test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	static int T, N, size, ans;
	static List<Node> client = new ArrayList<>();
	static List<Node> monster = new ArrayList<>();
	static boolean[] clientVisit;
	static boolean[] monsterVisit;
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			ans = Integer.MAX_VALUE;
			client.clear();
			monster.clear();
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					int num = Integer.parseInt(st.nextToken());
					if(num > 0) { // 몬스터
						monster.add(new Node(num, i, j));
					}else if(num < 0) { // 고객
						client.add(new Node(-num, i, j));
					}
				}
			}
			
			Collections.sort(client, (n1,n2)->n1.n - n2.n);
			Collections.sort(monster, (n1,n2)->n1.n - n2.n);
			
			size = client.size();
			clientVisit = new boolean[size];
			monsterVisit = new boolean[size];
			
			dfs(0,0,0,0,0);
			
			System.out.println("#" + t + " " + ans);
		}

	}
	
	static void dfs(int clientCnt, int monsterCnt, int y, int x, int degree) {
		if(clientCnt == size && monsterCnt == size) {
			ans = Math.min(degree, ans);
			return;
		}
		
		for (int i = 0; i < size; i++) {
			if(monsterVisit[i]) {
				if(clientVisit[i]) continue;
				clientVisit[i] = true;
				int d = Math.abs(y-client.get(i).y) + Math.abs(x-client.get(i).x);
				dfs(clientCnt+1, monsterCnt, client.get(i).y, client.get(i).x, degree + d);
				clientVisit[i] = false;
			}
			else {
				monsterVisit[i] = true;
				int d = Math.abs(y-monster.get(i).y) + Math.abs(x-monster.get(i).x);
				dfs(clientCnt, monsterCnt+1, monster.get(i).y, monster.get(i).x, degree + d);
				monsterVisit[i] = false;
			}
		}
	}
	
	static class Node{
		int x,y,n;
		
		public Node(int n, int y, int x) {
			this.n = n;
			this.y = y;
			this.x = x;
		}
	}

}