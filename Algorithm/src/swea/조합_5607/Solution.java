package swea.조합_5607;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int T,N,R;
	static final int P = 1234567891;
	static long ans = 0;
	static long[] factMod;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		factMod = new long[1000001];
		factMod[0] = 1;
		
		for (int i = 1; i <= 1000000; i++) {
			factMod[i] = (factMod[i-1] * i) % P;
		}
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			
			// 구하는 건 nCr % P

			// nCr % P 는 분수식으로 표현하면
	
			// n!
			// ----------  % P
			// (n-r)! * r! 
			
			// n! => A, (n-r)! * r! => B 로 놓으면
			// 위 식은 A * B ^ -1 % P
			
			// 페르마의 소정리에 의해
			// X ^ P   합동 X	( mod P )							: X ^ P 를 P 로 나눈 나머지는 X 를 P 로 나눈 나머지와 같다.
			// X ^ P-1  합동  1 ( mod P )							: X 로 양변을 나누면
			// X ^ P-2  합동  1 / X ( mod P ) == X ^ -1 ( mod P )  	: X 로 양변을 한번 더 나누면 (우측 분수 표현) 
			// => 1 / X 를  P로 나눈 나머지는 X ^ P-2 를 P로 나눈 나머지와 같다. <== 이걸 써 보자
			
			
			// ( A * (B ^ -1) ) % P ==> ( A * B ^ (P-2) ) % P ==> ( A % P ) * ( ( B ^ P -2 ) % P ) % P <== 모듈러 연산 
			
			long top = factMod[N];
			long bottom = factMod[N-R] * factMod[R] % P;
						
			ans = (top * pow( bottom, P - 2)) % P;
			System.out.println("#" + t + " " + ans);
		}
	}
	// pow 자체만 이해할 경우 MOD 로 나누는 부분 제외하고 생각
		// 2^16 계산 방법 pow(2, 16)
		// 16 이 1이 될 때까지 계속 나눈다. 중간에 홀수가 되면 base 를 한번 더 곱해주어서  지수/2 가 계속 유효하도록 처리
		// 마지막에 1이 되면 1*2/2 = 0 이 되어 while 문 종료
		// 각 단계마다 base 는 *= 연산을 통해서 ^만큼 증가
		// base = 2
		// base = 4 
		// base = 8
		// base = 16
		static long pow(long base, long expo) {
			if( expo == 0 ) return 1;
			else if( expo == 1 ) return base;
			
			long num = 1;

			while (expo > 0) {

				// 지수가 홀수일 경우, 지수를 줄이는 expo /= 2 처리가 안되므로 미리 결과 값에 base를 한번 곱해 
				if (expo % 2 == 1) {
					num *= base;
					num %= P;
				}
				base = (base * base) % P;
				expo /= 2;
			}
			return num;
		}
}
