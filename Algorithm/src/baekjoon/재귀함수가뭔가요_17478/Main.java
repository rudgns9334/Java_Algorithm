package baekjoon.재귀함수가뭔가요_17478;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static int N;
	static String[] str = new String[6];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		
		str[0] = "\"재귀함수가 뭔가요?\"";
		str[1] = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어."; 
		str[2] = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지."; 
		str[3] = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"";
		str[4] = "\"재귀함수는 자기 자신을 호출하는 함수라네\"";
		str[5] = "라고 답변하였지.";
		
		System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
		WhatIsRecur(N);
		
	}

	static void WhatIsRecur(int cnt) {
		StringBuilder sb = new StringBuilder();
		for(int i=N;i>cnt;i--) {
			sb.append("____");
		}
		System.out.printf("%s%s\n",sb.toString(),str[0]);
		if(cnt==0) {
			System.out.printf("%s%s\n",sb.toString(),str[4]);
		}else {
			for(int i=1;i<=3;i++) {
				System.out.printf("%s%s\n",sb.toString(),str[i]);
			}
			WhatIsRecur(cnt-1);
		}
		System.out.printf("%s%s\n",sb.toString(),str[5]);
	}
}
