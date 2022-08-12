package swea.요리사_4012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_T {

	static int T,N,min;
	static int[][] map;
	static int[] arrA, arrB; // 각각 두 그룹 A, B으로 재료를 나누었을 때, 재료의 index를 관리
	// 0, 1, 2, 3, 4, 5
	// A : 1, 3, 4
	// B : 0, 2, 5
	static boolean[] select; // 재료중 어떤 index의 재료가 선택되었는지 표현
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			select = new boolean[N];
			
			arrA = new int[N/2];
			arrB = new int[N/2];
			
			// 입력 처릴
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			min = Integer.MAX_VALUE;
			comb(0,0);
			
			System.out.println("#" + t + " " + min);
		}

	}
	
	static void comb(int srcIdx, int tgtIdx) {
		// 기저 조건
		if(tgtIdx == N/2) {
			// complete code
			check();
			return;
		}
		
		if(srcIdx==N) return;
		// src로 부터 선택된 항목을 tgt 자료구조에 담고 이어가는게(덮어쓰는게) 아니라, select에 표시이어간다.
		select[srcIdx] = true;
		comb(srcIdx+1, tgtIdx+1);
		
		select[srcIdx] = false;
		comb(srcIdx+1, tgtIdx);
	}
	
	static void check() {
		// 나누어진 2개의 배열에 select를 이용해서 각각 원재료의 인덱스를 확보
		// 시너지 합을 각각 계산한 후에 그 차이를 계산 -> min 갱신
		
		// arrA, arrB의 index
		int idxA = 0;
		int idxB = 0;
		
		// arrA에는 선택된, arrB 선택되지 않은
		for (int i = 0; i < N; i++) {
			if(select[i]) arrA[idxA++] = i;
			else arrB[idxB++] = i;
 		}
		
		int sumA = 0;
		int sumB = 0;
		// 시너지 표( map )을 이용해서 계산
		for (int i = 0; i < N/2; i++) {
			for (int j = 0; j < N/2; j++) {
				if(i==j) continue;
				sumA += map[arrA[i]][arrA[j]];
				sumB += map[arrB[i]][arrB[j]];
			}
		}
		
		min = Math.min(min, Math.abs(sumA-sumB));
	}

}
