package swea.원재의메모리복구하기_1289;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Scanner -> BufferedReader
// local 변수 중 주요 변수들을 static으로
// int[] => char[]
// String toCharArray()  <= 이거 잇 아이템
public class Solution_T2 {

	static int T,count;
	static char[] input, memory;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			count = 0;
			input = br.readLine().toCharArray(); // 배열을 새로 생성해서 return
			// 두 개의 배열
			int cnt = input.length;

			memory = new char[cnt]; // 0으로 초기화
			
			for(int i=0;i<cnt;i++) {
				memory[i] = '0';
			}
			// 두 배열을 같은 index로 이동하면서 값을 비교
			for(int i=0;i<cnt;i++) {
				if(memory[i] != input[i]) {
					// memArray를 뒤까지 변경
					for(int j=i;j<cnt;j++) {
						memory[j] = input[i];
					}
					count++; // 변경 횟수 증가
				}
			}
			System.out.println("#" + t + " " + count);
		}

	}

}
