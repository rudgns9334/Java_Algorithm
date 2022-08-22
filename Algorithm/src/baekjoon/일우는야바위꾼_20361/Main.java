package baekjoon.일우는야바위꾼_20361;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, X, K, ans;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 종이컵 개수
        X = Integer.parseInt(st.nextToken()); // 왼쪽에서 몇번째(1~N)
        K = Integer.parseInt(st.nextToken()); // 바꾸는 횟수

        ans = X; // 공의 위치

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()); // 바꾸기 전 위치
            int to = Integer.parseInt(st.nextToken()); // 바꾼 후 위치
            if(from == ans) { // 바꾸기전 위치에 공이 있는 경우
                ans = to; // 공 위치 조정
            }else if(to == ans) { // 바꾼 후 위치에 공이 있는 경우
                ans = from; // 공 위치 조정
            }
        }

        System.out.println(ans);
	}
}