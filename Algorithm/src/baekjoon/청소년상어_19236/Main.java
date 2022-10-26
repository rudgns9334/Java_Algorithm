package baekjoon.청소년상어_19236;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static Shark shark;
	static int[][] map;
	static Fish[] fishes;
	
	static PriorityQueue<Fish> pq = new PriorityQueue<>((f1, f2)->f1.n - f2.n);
	
	// 상부터 1, 반시계로 45도씩 이동
	static int[] dy = {0, -1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dx = {0, 0, -1, -1, -1, 0, 1, 1, 1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[4][4];
		fishes = new Fish[17];
		
		for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				fishes[a] = new Fish(i, j, a, b);
				map[i][j] = a;
			}
		}
		
		shark = new Shark();
		start();
	}
	
	static void start() {
		// 상어 입장 -> 0, 0 자리 버-억
		sharkEnter();
		
		// 물고기 무빙
		fishMove();
		
	}
	
	static void sharkEnter() {
		int n = map[0][0];
		shark.eat += fishes[n].n;
		fishes[n].die = true;
		shark.d = fishes[n].d;
		shark.y = 0;
		shark.x = 0;
	}
	
	static void fishMove() {
		
		for (int i = 1; i <= 16; i++) {
			if(!fishes[i].die) pq.offer(fishes[i]);
		}
		
		for (int i = 0; i < pq.size(); i++) {
			Fish f1 = pq.poll();
			int ny, nx;
			while(true) {
				ny = f1.y + dy[f1.d];
				nx = f1.x + dx[f1.d];
				// 이동하려는 칸에 
				// #1 상어가 있다면?
				if(ny == shark.y && nx == shark.x) {
					f1.d = f1.d == 8 ? 1 : f1.d+1;
					continue;
				}
				// #2 벽이라면?
				if(ny<0 || nx<0 || ny>=4 || nx>=4) {
					f1.d = f1.d == 8 ? 1 : f1.d+1;
					continue;
				}
				// 모두 아니라면 자리를 옮김
				break;
			}
			swapFish(f1.y, f1.x, ny, nx);
		}
	}
	
	static void swapFish(int y1, int x1, int y2, int x2){
		int ny = y1;
		int nx = x1;
		map[y1][x1] = map[y2][x2];
		map[y2][x2] = map[ny][nx];
		fishes[map[y1][x1]].y = y1;
		fishes[map[y1][x1]].x = x1;
		fishes[map[y2][x2]].y = y2;
		fishes[map[y2][x2]].x = x2;
	}
	
	static class Shark{
		int y,x,eat, d;
	}
	
	static class Fish{
		int y, x, n, d;
		boolean die = false;
		
		Fish(int y, int x, int n, int d){
			this.y = y;
			this.x = x;
			this.n = n;
			this.d = d;
		}
	}
}
