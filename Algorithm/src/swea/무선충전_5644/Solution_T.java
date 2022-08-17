package swea.무선충전_5644;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_T {

	static int T, M, A, ans;
	static int[] pathA, pathB;
	static BC[] bcArray; // 배터리배열
	static int ay, ax, by, bx; // 사람 a, b의 좌표
	// delta
	static int[] dy = {0, -1, 0, 1, 0};
	static int[] dx = {0, 0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken()); // 총 이동 시간
			A = Integer.parseInt(st.nextToken()); // BC 갯수
			
			// path
			pathA = new int[M];
			pathB = new int[M];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				pathA[i] = st.nextToken().charAt(0)-'0';
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				pathB[i] = st.nextToken().charAt(0)-'0';
			}
			
			// BC
			bcArray = new BC[A];
			
			for (int i = 0; i < A; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int p = Integer.parseInt(st.nextToken());
				bcArray[i] = new BC(y,x,c,p);
			}
			
			// 변수 초기화
			ans = 0;
			ay = ax = 1;
			by = bx = 10;
			
			// 풀이
			// 시뮬레이션
			charge(); // 최초 위치에서의 충전
			for (int i = 0; i < M; i++) {
				// a,b 이동
				ay += dy[pathA[i]];
				ax += dx[pathA[i]];
				by += dy[pathB[i]];
				bx += dx[pathB[i]];
				
				// a,b의 현재 위치에서의 충전
				charge();
				
			}
			
			System.out.println("#" + t + " " + ans);
		}
	}
	
	// 충전 처리
	// 중복 순열
	// 현재 T=1... 현재 상태에서 최대값을 구해야 한다.
	static void charge() {
		// 2차원 배열로 중복 순열 구현
		// A, B가 중복된 BC를 선택하는 경우를 포함
		// 그 모든 경우에서 A의 충전량, B의 충전량의 합 (sum)이 최대가 되는 경우 max
		int max = 0; // 경우의 수 중 최대
		for (int i = 0; i < A; i++) { // 모든 BC에 대해서 A가 충전하려는 BC
			// i == j => A, B가 같은 BC에서 ㅊ ㅜㅇ전함
			for (int j = 0; j < A; j++) { // 모든 BC에 대해서 B가 충전하려는 BC
				int sum = 0;// A충전량 + B충전량
				
				int aPower = getPower(bcArray[i], ay, ax); // bcArray[i] 
				int bPower = getPower(bcArray[j], by, bx); // bcArray[j]
				
				// 0이면 거르자
				if(aPower == 0 && bPower == 0) continue;
				
				// 둘중 하나는 power를 가지고 있다.
				// 두 충전소가 다르다.
				if( i != j) {
					sum = aPower + bPower;  // 각각 다른 충전소에서 충전 => 단순히 더한다. (한쪽이 0이어도 상관  X)
				}else { // 두 충전소가 같은 경우
					// a, b 모두 충전이 되었다면 100 충전 => 50, 50 => 100
					// a, b 한쪽만 충전 ? 충전한 값을 선택
					sum = Math.max(aPower, bPower);
				}
				max = Math.max(max, sum); // 현재 i, j의 BC에서 충전한 전기량이 이전 BC 최대값보다 크면 선택
			}
		}
		ans += max;
	}
	
	static int getPower(BC bc, int y, int x) {
		if(Math.abs(bc.y-y) + Math.abs(bc.x - x) <= bc.c) return bc.p;
		return 0;
	}
	
	static class BC {
		int y, x, c, p;
		
		public BC(int y, int x, int c, int p) {
			this.y = y;
			this.x = x;
			this.c = c;
			this.p = p;
		}
	}

}
