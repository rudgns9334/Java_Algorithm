package swea.규영이와인영이의카드게임_6808;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_T2 {

	static int T, win, lose, N = 9;
	static int[] input = new int[19];
	static int[] guCard = new int[9]; // 테케에서 고정
	static int[] inCard = new int[9]; // guCard에 없는 번호를 입력 <= 순열을 만들기 위해 선택할 수 있는 src
//	static int[] tgt = new int[9];
	
	static boolean[] select = new boolean[N];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++) {
			
			win = 0;
			lose = 0;
			Arrays.fill(input, 0);
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			// 규영이 카드
			int num = 0;
			for(int i=0;i<N;i++) {
				num = Integer.parseInt(st.nextToken());
				guCard[i] = num;
				input[num] = 1; // 인영이 카드 설정을 위해
			}
			// 인영이 카드 - 순열의 src
			num = 0; // 맨앞, 계속 증가
			for(int i=1;i<19;i++) {
				if(input[i]==0) {
					inCard[num++] = i;
				}
			}
			
			perm(0,0,0);
			
			System.out.println("#" + t + " " + win + " " + lose);
		}

	}
	static void perm(int guIdx, int guSum, int inSum) {
		// 기저조건
		// 규영이의 카드로부터 임의의 카드를 순열로 완성한 경우
		if(guIdx == N) {
			// complete code
			if(guSum > inSum) win++;
			else if(inSum > guSum) lose++;
			return;
		}
		
		for(int i=0;i<N;i++) { // 인영이의 카드 index
			// 이미 선택된 i 제외
			if(select[i]) continue;
			
			select[i] = true;
			// 파라미터 guIdx <= 규영이의 index
			if(guCard[guIdx] > inCard[i]) { // 규영이가 승
				perm(guIdx + 1, guSum+guCard[guIdx]+inCard[i], inSum);
			}else { // 인영이가 승
				perm(guIdx + 1, guSum, inSum+guCard[guIdx]+inCard[i]);
			}
			select[i] = false;
		}
	}
}
