package baekjoon.캐슬디펜스_17135;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, D, archer, ans;
	static int[][] map,backup;
	static int[] tgt;
	static boolean[][] kill;
	static int[] dy = {0, -1, 0};
	static int[] dx = {-1, 0, 1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		tgt = new int[3];
		map = new int[N][M];
		backup = new int[N][M];
		ans = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				backup[i][j] = map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		comb(0,0);
		
		System.out.println(ans);
		

	}

	
	static void comb(int srcIdx, int tgtIdx) { // srcIdx를 tgtIdx에 선택, 비선택 2가지 경우
		if(tgtIdx == 3) {
			archer = N;
			attack(0);
			mapBackup();
			return;
		}
		// 추가적인 기저조건
		if(srcIdx == M) return;
		
		// 선택
		tgt[tgtIdx] = srcIdx;
		
		comb(srcIdx + 1, tgtIdx + 1); // 현재 선택(tgtIdx <- srcIdx)을 만족, 다음 선택을 하러 재귀
		comb(srcIdx +1, tgtIdx); // 현재 선택(tgtIdx <- srcIdx) 만족 X, 여전히 tgtIdx <- src+1;
	}
	
	static void attack(int sum) {
		// 기저 조건
		if(archer==0) {
			ans = Math.max(ans, sum);
			return;
		}
		int cnt = 0;
		kill = new boolean[N][M];
		for (int i = 0; i < 3; i++) {
			findEnemy(tgt[i]);
		}
		
		cnt = killEnemy();

		archer--;
		attack(sum+cnt);
	}
	
	static int killEnemy() {
		int cnt = 0;
		for (int i = 0; i < archer; i++) {
			for (int j = 0; j < M; j++) {
				if(kill[i][j]) {
					map[i][j] = 0;
					cnt++;
				}
			}
		}
		return cnt;
	}
	
	static void findEnemy(int idx) {
		Queue<Node> q = new ArrayDeque<>();
		boolean[][] visit = new boolean[N][M];
		q.add(new Node(archer-1,idx,1));
		visit[archer-1][idx] = true;
		
		while(!q.isEmpty()) {
			Node n = q.poll();
			if(n.d > D) continue;
			if(map[n.y][n.x] == 1) {
				kill[n.y][n.x] = true;
				break;
			}
			for (int i = 0; i < 3; i++) {
				int ny = n.y + dy[i];
				int nx = n.x + dx[i];
				if(ny<0 || nx<0 || nx>=M || visit[ny][nx]) continue;
				visit[ny][nx] = true;
				q.add(new Node(ny, nx, n.d+1));
			}
		}
	}
	
	static void mapBackup() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = backup[i][j];
			}
		}
	}
	
	static class Node{
		int y,x,d;
		
		public Node(int y, int x, int d) {
			this.y = y;
			this.x = x;
			this.d = d;
		}
	}
}
