package baekjoon.DNA비밀번호_12891;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_T2 {

	static int S, P, ans;
	static char[] dna;
	static int minA, minC, minG, minT;
	// A B C D E F G H I J K L M N O P Q R S T U
	// 0 1 2 3 4 5 6 7 8 9 1011121314151617181920
	static int[] cnt = new int[26];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		dna = br.readLine().toCharArray();
		
		st = new StringTokenizer(br.readLine());
		minA = Integer.parseInt(st.nextToken());
		minC = Integer.parseInt(st.nextToken());
		minG = Integer.parseInt(st.nextToken());
		minT = Integer.parseInt(st.nextToken());
		
		solve();
		System.out.println(ans);
	}
	
	static void solve() {
		// 시작 P개 부분 문자열 부터 확인
		for (int i = 0; i < P; i++) {
			cnt[ dna[i] - 'A']++;
		}
		// 시작 P에 대해서 확인
		check();
		
		for (int i = P; i < S; i++) {
			// 하나는 버리고 새로 하나를 취한다. 버리는 것은 맨앞, 취하는 건 맨 뒤 => 중간에 있는 것들은 재사용
			// dna[i-P];
			cnt[dna[i-P] -'A']--;
			cnt[dna[i]-'A']++;
			// 새로운 부분문자열을 확인
			check();
		}
	}
	
	// 부분 문자열이 조건에 맞는지 확인
	static void check() {
		if(cnt[0] >= minA && cnt[2] >= minC && cnt[6] >= minG && cnt[19] >= minT) ans++;
	}

}
