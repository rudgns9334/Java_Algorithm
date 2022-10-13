package swea.원점으로집합_8458;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_T {
	
	static int T, N, max;
	static int[] arr;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());	
			arr = new int[N];
			max = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[0] = Math.abs(a) + Math.abs(b);
			max = arr[0];
			// 전부 짝수 또는 홀수 여부를 따진다.
			// max 값도 미리 계산
			boolean stop = false;
			for (int i = 1; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				arr[i] = Math.abs(a) + Math.abs(b);
				max = Math.max(max, arr[i]);
				if(arr[i]%2 != arr[i-1]%2) stop = true;
			}
			if(stop) {
				System.out.println("#" + t + " " + "-1");
			}else {
				// 전부다 짝수이거나 홀수 => 원점으로 모두 이동 가능
				
				int sum = 0;// 총 이동 거리의 합
				int cnt = 0;// 움직이는 횟수
				
				while(true) {
					if( sum == max || ( sum > max ) && ( sum - max ) % 2 == 0 ) break;
		            sum += ++cnt;
				}
				System.out.println("#" + t + " " + cnt);
			}
		}
	}
}
