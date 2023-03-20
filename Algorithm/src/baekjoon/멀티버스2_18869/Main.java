package baekjoon.멀티버스2_18869;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int M, N;
	static int[][] space;
	static int[][] sorted;
	static int[] idx;
	static List<String> str = new ArrayList<>();
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		space = new int[M][N];
		sorted = new int[M][N];
		idx = new int[1000001];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				space[i][j] = Integer.parseInt(st.nextToken());
				sorted[i][j] = space[i][j];
			}
			Arrays.sort(sorted[i]);
		}
		
		for (int i = 0; i < M; i++) {
			int cnt = 0;
			idx[sorted[i][0]] = cnt;
			for (int j = 1; j < N; j++) {
				if(sorted[i][j] != sorted[i][j-1]) idx[sorted[i][j]] = ++cnt;
			}
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < N; j++) {
				sb.append(idx[space[i][j]]);
			}
			str.add(sb.toString());
		}
		
		Collections.sort(str);
		
		int cnt = 1;
		int ans = 0;
		for (int i = 1; i < M; i++) {
			if(str.get(i).equals(str.get(i-1))) {
				cnt++;
			}else {
				ans += cnt*(cnt-1)/2;
				cnt = 1;
			}
		}
		ans += cnt*(cnt-1)/2;
		System.out.println(ans);
		
	}

}
