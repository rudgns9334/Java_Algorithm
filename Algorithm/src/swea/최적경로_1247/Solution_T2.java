package swea.최적경로_1247;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// np
public class Solution_T2 {

	static int T, N, comY, comX, homeY, homeX, min;
	static int[][] cust;
	static int[] index;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			min = Integer.MAX_VALUE;
			
			N = Integer.parseInt(br.readLine());
			cust = new int[N][2];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			comY = Integer.parseInt(st.nextToken());
			comX = Integer.parseInt(st.nextToken());
			homeY = Integer.parseInt(st.nextToken());
			homeX = Integer.parseInt(st.nextToken());
			
			for (int i = 0; i < N; i++) {
				cust[i][0] = Integer.parseInt(st.nextToken());
				cust[i][1] = Integer.parseInt(st.nextToken());
			}
			// 가장 작은 수로 정렬
			index = new int[N];
			for (int i = 0; i < N; i++) {
				index[i] = i;
			}
			while(true) {
				
				check();
				if( !np() ) break;
			}
			
			System.out.println("#" + t + " " + min);
		}

	}

	static void check() {
		// 회사 -> 첫번째 고객
		int sum = distance(comY, comX, cust[index[0]][0], cust[index[0]][1]);
		// 첫번째 고객 -> 마지막 고객
		for (int i = 0; i < N-1; i++) {
			sum += distance(cust[index[i]][0], cust[index[i]][1],
					cust[index[i+1]][0], cust[index[i+1]][1]);
		}
		// 마지막 고객 -> 집
		sum += distance(homeY, homeX, cust[index[N-1]][0], cust[index[N-1]][1]);
		
		min = Math.min(min, sum);
		
		return;
	}
	
	static boolean np() {
		int i = index.length-1; // 바꿀 대상 찾기
		while(i>0 && index[i-1] >= index[i] ) i--;
		
		if(i==0) return false;
		
		int j = index.length - 1; // 결정된 i의 앞보다 더 큰 j 찾기
		
		while(index[i-1] >= index[j]) j--;
		
		swap(index, i-1, j);
		
		int k = index.length - 1; // 나머지 스왑하기
		while(i<k) swap(index, i++, k--);
		
		return true;
		
	}
	
	static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	
	static int distance(int y1, int x1, int y2, int x2) {
		return Math.abs(y1-y2) + Math.abs(x1-x2);
	}
}
