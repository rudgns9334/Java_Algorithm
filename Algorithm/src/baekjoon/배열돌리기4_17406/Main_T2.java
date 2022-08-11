package baekjoon.배열돌리기4_17406;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_T2 {

	static int[][] map, backup, rcs;
	static int N,M,K,min;
	static int[] npIdx;
	static boolean[] select;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		backup = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int n = Integer.parseInt(st.nextToken());
				map[i][j] = n;
				backup[i][j] = n;
			}
		}
		
		// 초기화
		min = Integer.MAX_VALUE;
		rcs = new int[K][3];
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			rcs[i][0] = Integer.parseInt(st.nextToken());
			rcs[i][1] = Integer.parseInt(st.nextToken());
			rcs[i][2] = Integer.parseInt(st.nextToken());
		}

		// 순열
		npIdx = new int[K];
//		select = new boolean[K];
		for (int i = 0; i < K; i++) { // 앞쪽이 작은 수 뒤가 가장 큰수
			npIdx[i] = i;
		}
		
		while(true) {
			
			for(int n : npIdx) {
				int r = rcs[n][0]-1;
				int c = rcs[n][1]-1;
				int s = rcs[n][2];
				
				int sy = r-s, ey = r+s; // sy : 시작 y, ey : 종료 y
				int sx = c-s, ex = c+s; // sx : 시작 x, ex : 종료 x
				
				while(s>0) {
					// 반 시계 방향으로 이동
					int tmp = map[sy][sx];// 첫 좌표 복사
					
					// left->top 으로 좌표 이동
					for(int i = sy; i < ey; i++) {
						map[i][sx] = map[i+1][sx];
					}
					
					// bottom -> left으로 이동
					for(int i=sx;i<ex;i++) {
						map[ey][i] = map[ey][i+1]; // 오른쪽 끝 X 고적
					}
					
					// right -> bottom 으로 이동
					for(int i=ey;i > sy;i--) {
						map[i][ex] = map[i-1][ex];
					}
					
					// top -> right로 이동
					for(int i=ex;i>sx;i--) {
						map[sy][i] = map[sy][i-1];
					}
					
					map[sy][sx+1] = tmp;
					// sy, ey, sx, ex 보정
					sy++;
					sx++;
					ey--;
					ex--;
					
					s--;
				}
			}
			// 최소값 갱신
			for (int i = 0; i < N; i++) {
				int sum = 0;
				for (int j = 0; j < M; j++) {
					sum += map[i][j];
				}
				min = Math.min(min, sum);
			}
			
			
			// 배열 초기화
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					map[i][j] = backup[i][j];
				}
			}
			
			// np() 다음 것 호출
			if(!np(npIdx)) break;
		}
		
		
		System.out.println(min);
		
	}
	
	private static boolean np(int array[]) {
	    
	    int i = array.length-1;
	    while( i>0 && array[i-1]>=array[i] ) --i;
	    
	    if( i == 0 ) return false;
	    
	    int j = array.length-1;
	    while(array[i-1]>=array[j])    --j;
	    swap(array,i-1,j);
	    
	    // reverse
	    int k = array.length-1;
	    while(i<k) {
	        swap(array,i++,k--);            
	    }
	    return true;
	}

	private static void swap(int numbers[], int i, int j) {
	    int temp = numbers[i];
	    numbers[i] = numbers[j];
	    numbers[j] = temp;
	}
}
