package baekjoon.맥주마시면서걸어가기_9205;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_T {

	static int T, N, V;
	static final int BIG = 101*23767*2;
	static int[][] input;
	static int[][] matrix;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			V = N + 2;
			input = new int[V][2];
			matrix = new int[V][V];
			
			for (int i = 0; i < V; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 2; j++) {
					input[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 입력 => 인접행렬
			for (int i = 0; i < V; i++) {
				int vy = input[i][0];
				int vx = input[i][1];
				
				for (int j = 0; j < V; j++) {
					if(i == j) continue;
					int ty = input[j][0];
					int tx = input[j][1];
					int dis = Math.abs(ty-vy) + Math.abs(tx-vx); // 맨하튼 거리
					
					// 중요 !
					// 만약 dis > 50*20 = 1000 => 연결 X / 갈 수 없다. <= BIG
//					if( dis > 1000 ) {
//						matrix[i][j] = BIG;
//					}else {
//						matrix[i][j] = dis;
//					}
					
					matrix[i][j] = dis > 1000 ? BIG : dis;
				}
			}
			
			// 플로이드 워샬 적용
			for (int k = 0; k < V; k++) { // 경유지
				for (int i = 0; i < V; i++) { // 출발지
					if(k == i) continue;
					for (int j = 0; j < V; j++) { // 도착지
						if( i == j || k == j ) continue;
						
						// 최소값 선택 : i -> j 비용 vs i->k 비용 + k->j비용의 합
						matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
					}
					
				}
				
			}
			
			// 모든 정점에서 다른 정점으로 가는 최소 비용이 matrix 인접행렬에 계산되었음.
			// 인접행렬에는 갈 수 없는 구간에 대해서 BIG
			
			// 집 --> 공연장
			// 집[0] --> 공연장[V-1]
			System.out.println(matrix[0][V-1] != 0 && matrix[0][V-1] < BIG ? "happy" : "sad");
		}
	}

}
