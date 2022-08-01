package swea.원재의메모리복구하기_1289;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 배열 하나만으로 해보기
// 숫자가 바뀔 때마다 카운트 ( 내가 한 방법과 유사 )
public class Solution_T3 {

	static int T,count;
	static char[] input;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			count = 0;
			input = br.readLine().toCharArray(); // 배열을 새로 생성해서 return
			
			// 현재 문자
			char current = '0';
			
			int cnt = input.length;

			// 현재의 값과 input[i]를 비교해서 다르면 변경횟수 증가
			for(int i=0;i<cnt;i++) {
				if(current != input[i]) {
					count++; // 변경 횟수 증가
				}
				current = input[i]; // 오호 이런 방법이
			}
			System.out.println("#" + t + " " + count);
		}

	}

}
