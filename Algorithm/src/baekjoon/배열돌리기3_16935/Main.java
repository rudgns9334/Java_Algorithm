package baekjoon.배열돌리기3_16935;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N, M, R;
	static List<List<Integer>> list = new ArrayList<>();
	static int[] AN;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			List<Integer> map = new ArrayList<>(); 
			for (int j = 0; j < M; j++) {
				map.add(Integer.parseInt(st.nextToken()));
			}
			list.add(map);
		}
		
		AN = new int[R];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < R; i++) {
			AN[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < R; i++) {
			rotate(AN[i]);
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(list.get(i).get(j) + " ");
			}
			System.out.println();
		}
		
	}
	
	static void rotate(int num) {
		int sy = 0, ey = N-1; // sy : 시작 y, ey : 종료 y
		int sx = 0, ex = M-1; // sx : 시작 x, ex : 종료 x
		
		switch(num) {
		case 1:
			while(true) {
				if(ey-sy<1 || ex-sx<1) return;
				
				for (int i = sx; i <= ex; i++) {
					swap(sy, i, ey, i);
				}
				ey--;
				sy++;
			}
		case 2:
			while(true) {
				if(ey-sy<1 || ex-sx<1) return;
				
				for (int i = sy; i <= ey; i++) {
					swap(i, sx, i, ex);
				}
				ex--;
				sx++;
			}
		case 3:
			List<List<Integer>> temp = new ArrayList<>();
			while(true) {
				List<Integer> tmp = new ArrayList<>();
				if(sx>ex) {
					list = temp;
					N = list.size();
					M = list.get(0).size();
					return;
				}
				//left -> top 으로
				for (int i = ey; i >= sy; i--) {
					tmp.add(list.get(i).get(sx));
				}
				sx++;
				temp.add(tmp);
			}
			
		case 4:
			List<List<Integer>> temp2 = new ArrayList<>();
			while(true) {
				List<Integer> tmp = new ArrayList<>();
				if(sx>ex) {
					list = temp2;
					N = list.size();
					M = list.get(0).size();
					return;
				}
				//right -> top 으로
				for (int i = sy; i <= ey; i++) {
					tmp.add(list.get(i).get(ex));
				}
				ex--;
				temp2.add(tmp);
			}
		case 5:
			ex = M/2;
			// 1<->2
			while(true) {
				if(sy>=N/2) break;
				
				for (int i = sx; i < ex; i++) {
					swap(sy, i, sy, i+ex);
				}
				sy++;
			}
			// 1<->4
			sy = 0;
			sx = 0;
			ex = 0;
			ey = N/2;
			while(true) {
				if(sx>=M/2) break;
				
				for (int i = sy; i < ey; i++) {
					swap(i, sx, i+ey, sx);
				}
				sx++;
			}
			
			// 3<->4
			sx = 0;
			ex = M/2;
			ey = N/2;
			while(true) {
				if(ey>=N) return;
				
				for (int i = sx; i < ex; i++) {
					swap(ey, i, ey, i+ex);
				}
				ey++;
			}
			
		case 6:
			// 2<->3
			ex = M/2;
			sy = 0;
			ey = N/2;
			while(true) {
				if(ex>=M) break;
				
				for (int i = sy; i < ey; i++) {
					swap(i, ex, i+ey, ex);
				}
				ex++;
			}
			
			// 3<->4
			sx = 0;
			ex = M/2;
			ey = N/2;
			while(true) {
				if(ey>=N) break;
				
				for (int i = sx; i < ex; i++) {
					swap(ey, i, ey, i+ex);
				}
				ey++;
			}
			
			// 1<->4
			sy = 0;
			sx = 0;
			ex = 0;
			ey = N/2;
			while(true) {
				if(sx>=M/2) return;
				
				for (int i = sy; i < ey; i++) {
					swap(i, sx, i+ey, sx);
				}
				sx++;
			}
		}
	}
	
	static void swap(int sy, int sx, int ey, int ex) {
		int tmp = list.get(sy).get(sx);
		list.get(sy).set(sx, list.get(ey).get(ex));
		list.get(ey).set(ex, tmp);
	}

}
