package baekjoon.회전초밥2_15961;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, d, k, c, cnt, max;
	static int[] sushi;
	static int[] kind;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		cnt = 0;
		max = 0;
		
		sushi = new int[N+k-1];
		kind = new int[d+1];
		
		for (int i = 0; i < N; i++) {
			sushi[i] = Integer.parseInt(br.readLine());
		}
		
		for (int i = 0; i < k-1; i++) {
			sushi[i+N] = sushi[i];
		}
		
		action();
		
		System.out.println(max);
		
	}
	
	static void action() {
		// 사이클 시작
		// 제일 처음 스시의 종류 집어넣기
		for (int i = 0; i < k; i++) {
			if(kind[sushi[i]] == 0) {
				cnt++;
			}
			kind[sushi[i]]++;
		}
		max = cnt;
		for (int i = 1; i < N; i++) {
			
			// 새로운 스시 영입
			if(kind[sushi[i+k-1]] == 0) cnt++;
			kind[sushi[i+k-1]]++;
			
			// 첫번째를 제외하고는 삭제되는 스시는 빼야함
			kind[sushi[i-1]]--;
			// 뺏을때 개수가 0이 되면 총 종류량에서 제외
			if(kind[sushi[i-1]] == 0) {
				cnt--;
			}
					
			if(kind[c] == 0) {
				cnt++;
				kind[c]++;
			}
			
			max = Math.max(max, cnt);
		}
	}
}
