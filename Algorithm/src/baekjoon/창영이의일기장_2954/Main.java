package baekjoon.창영이의일기장_2954;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i); // 입력받은 string 인덱스 순으로 하나씩 받아오기
			if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u') { // 입력 받은 값이 모음인 경우
				i += 2; // i값을 조정하여 뒤에 오는 2개의 index를 스킵한다.(어짜피 모음 + p + 모음이 한쌍이기에 뒤에 2개를 출력에서 빼면 된다.)
			}
			sb.append(c); // 입력 받은 값을 스트링빌더에 넣어 둔다.
		}

		System.out.println(sb.toString());
	}

}