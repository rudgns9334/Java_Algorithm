package baekjoon.막대기_1094;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static int X, stick, cnt;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		X = Integer.parseInt(br.readLine());
			stick = 64; // 제일 짧은 막대 길이를 저장할 변수
			cnt = 1; // 막대의 개수
			
			cut(X);
			
			System.out.println(cnt);
		}
       
	static void cut(int x) {
		int sum = stick; // 남아 있는 나무막대의 총 길이를 저장할 변수
		while(true) {
			// 기저 조건
			if(sum == x) {
				return;
			}
			// #0. 길이가 제일 짧은 막대를 자른다.
			stick = stick/2;
			// #1. 이등분한 막대를 제외한 나머지의 합이 X보다 크거나 같다면 자른 막대중 하나를 버린다.
			if(sum - stick >= x) {
				// 버리는 경우 총 개수는 달라지지 않음
				// 총 길이만 변화
				sum -= stick;
			}
			// #2. 이등분한 막대를 제외한 나머지의 합이 X보다 작으면 버리지 않고 작업 반복
			else {
				// 이때는 개수가 늘어남
				cnt++;
			}
		}
	}
}
