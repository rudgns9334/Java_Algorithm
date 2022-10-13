package swea.원점으로집합_8458;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int T, N, cnt, max, sum;
	static int[] arr;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			cnt = 0;
			arr = new int[N];
			max = 0;
			sum = 0;
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				arr[i] = Math.abs(a) + Math.abs(b);
				max = Math.max(max, arr[i]);
			}
			
			int test = arr[0] % 2;
			for (int i = 1; i < N; i++) {
				if(arr[i]%2 != test) {
					cnt = -1;
					break;
				}
			}
			if(cnt == -1) {
				System.out.println("#" + t + " " + cnt);
				continue;
			}
			
			while(true) {
				sum += cnt;
				if(max <= sum) break;
				cnt++;
			}
			
			int diff = sum - max;
			
			if(diff%2 == 1) {
				if(cnt % 2 == 0) {
					cnt++;
				}else {
					cnt += 2;
				}
			}
			
				
			System.out.println("#" + t + " " + cnt);
		}
	}
}
