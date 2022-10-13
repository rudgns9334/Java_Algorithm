package baekjoon.볼록껍질_1708;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_T {
	static int N;
	static long sx, sy;
	static long[][] point; // point[3][0] 4번째 x 좌표
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		point = new long[N][2];
		
		
		// point 배열에 입력 저장
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			point[i][0] = Long.parseLong(st.nextToken());
			point[i][1] = Long.parseLong(st.nextToken());
		}
		
		// 시작점 sx, sy 지점 ( 맨 앞의 점을 시작점으로)
		sx = point[0][0];
		sy = point[0][1];
		// 시작점을 y가 가장 작은 점, y가 같은 점이 있다면 x가 가장 작은 점 계산 => sy, sx로
		for (int i = 1; i < N; i++) {
			if(point[i][1] < sy) {
				sx = point[i][0];
				sy = point[i][1];
			}else if(point[i][1] == sy) {
				if(point[i][0] < sx) {
					sx = point[i][0];
					sy = point[i][1];
				}
			}
		}
		// sx, sy는 가장 낮은 (가장 왼쪽)
		
		// point 배열을 반시계방향으로 정렬
		Arrays.sort(point, (p1, p2) ->{
			long ret = ccw(sx, sy, p1[0], p1[1], p2[0], p2[1]);
			if(ret > 0 ) { // 반시계방향
				return -1;
			}else if( ret < 0 ) { // 시계방향
				return 1;
			}else {
				long diff = distance(sx, sy, p1[0], p1[1]) - distance(sx, sy, p2[0], p2[1]);
				return diff > 0 ? 1 : -1;
			}
		});
		
		// Stack 객체 생성
		// 시작점을 stack에 넣는다.
		Stack<long[]> stack = new Stack<>();
		stack.add(new long[] {sx, sy});
		// 시작점을 제외한 모든 점을 순회
		// for문을 이용해서 각 i점에 대해서
		// stack에 들어가있는 이전 2개의 점과 i점과의 ccw를 확인
		// 반시계방향이 아니면 계속 꺼낸다. 반복적으로
		// => stack에 i점을 넣는다.
	
		for (int i = 1; i < N; i++) {
			long[] next = point[i]; // 따지려는 점
			while(stack.size() > 1) {
				// next가 이전 2개의 점과 반시계방향인지 따져봐서 아니면 계속 반시계 방향이ㅣ 만들어지도록 기존 점을 삭제
				long[] first = stack.get(stack.size()-2);
				long[] second = stack.get(stack.size()-1);
				int ret = ccw(first[0], first[1], second[0], second[1], next[0], next[1]);
				if( ret <= 0 ) stack.pop();
				else break;
			}
			stack.add(point[i]); // 새로 추가
			
		}
		// stack에 들어가있는 점들이 바로 블록 껍질을 구성하는 점들이므로
		System.out.println(stack.size());
	}
	
	static int ccw(long x1, long y1, long x2, long y2, long x3, long y3) {
		long ccw = (x1*y2 + x2*y3 + x3*y1)-(x2*y1 + x3*y2 + x1*y3);		
		// ret는 양수 음수 여부를 따져서 반시계방향(1), 시계방향(-1) 여부를 리턴, 같으면 (0)
		if(ccw > 0 ) return 1;
		else if(ccw < 0) return -1;
		else return 0;
	}
	
	static long distance(long x1, long y1, long x2, long y2) {
		// 피타고라스 거리를 계산해서 return;
		long dis = (x1-x2)*(x1-x2) + (y1-y2)*(y1-y2);
		return dis;
	}
	
}
