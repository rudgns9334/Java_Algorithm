package baekjoon.스위치켜고끄기_1244;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N,M; // N : 스위치 개수, M : 학생 수
	static int t, Snum; // t : 성별, numS : 스위치 번호
	static int[] Switch;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		Switch = new int[N]; // 배열 초기화
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			Switch[i] = Integer.parseInt(st.nextToken());
		}
		
		M = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			t = Integer.parseInt(st.nextToken());
			Snum = Integer.parseInt(st.nextToken());
			if(t==1) {
				int Cnum = Snum-1;
				while(Cnum < N) {
					Switch[Cnum] = (Switch[Cnum]+1)%2;
					Cnum += Snum;
				}
			}else {
				int leftIdx = Snum-1;
				int rightIdx = Snum-1;
				Switch[Snum-1] = (Switch[Snum-1]+1)%2;
				while(true) {
					leftIdx--;
					rightIdx++;
					if(leftIdx<0 || rightIdx>=N) break;
					if(Switch[leftIdx]!=Switch[rightIdx]) break;
					Switch[leftIdx] = (Switch[leftIdx]+1)%2;
					Switch[rightIdx] = (Switch[rightIdx]+1)%2;
				}
			}	
		}
		for(int i=0;i<N;i++) {
			System.out.print(Switch[i] + " ");
			if(i%20 == 19) {
				System.out.println();
			}
		}
	}

}
