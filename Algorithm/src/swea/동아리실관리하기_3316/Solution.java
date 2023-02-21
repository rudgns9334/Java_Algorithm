package swea.동아리실관리하기_3316;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {

	static int T;
	static char[] admins;
	static long ans;
	
	static List<Integer>[][] list;
	
	static long[][] pos;
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		list = new List[4][16];
		init();
		
		for (int t = 1; t <= T; t++) {
			admins = br.readLine().toCharArray();
			ans = 0;
			// 키 담당자 선택
			// 처음은 A가 들고있다.
			// 책임자 선택
			pos = new long[16][admins.length];
			
			for (int i = 0; i < admins.length; i++) {
				solve(i);
			}
			
			for (int i = 0; i < 16; i++) {
				ans += pos[i][admins.length-1];
				ans = ans%1000000007;
			}
			
			System.out.println("#" + t + " " + ans);
			
		}

	}
	/**
	 * 1 : A
	 * 10 : B
	 * 100 : C
	 * 1000 : D
	 * 11 : AB
	 * 111 : ABC 등등..
	 * 각각의 경우의수 저장하기
	 *  */

	static void init() {
		
		for (int i = 0; i < 4; i++) {
			// i = 0 담당자가 A인 경우
			for (int j = 0; j < 16; j++) {
				// 담당자가 i일때 j가 갈 수 있는 경우 를 리스트에 넣기
				list[i][j] = new ArrayList<>();
				int[] tmp = new int[16];
				for (int k = 0; k < 4; k++) {
					if((j & (1 << k)) > 0) {
						int bi = (1 << k) | (1 << i);
						for (int u = 0; u < 16; u++) {
							int a = u & bi;
							if(a == bi) {
								tmp[u]++;
							}
						}
					}
				}
				for (int k = 0; k < 16; k++) {
					if(tmp[k] != 0) {
						list[i][j].add(k);
					}
				}
				
			}
		}
		
	}
	
	static void solve(int cnt) {
		
		if(cnt == 0) {
			int bi = 1 | (1 << (admins[cnt]-'A'));
			for (int j = 0; j < 16; j++) {
				int a = j & bi;
				if(a == bi) {
					pos[j][cnt] = 1;
					
				}
			}
			return;
		}
		int ad = admins[cnt]-'A';
		// 담당자를 어디서...
		for (int i = 0; i < 16; i++) {
			
			if(pos[i][cnt-1] != 0) {
//				int ad = i | (1 << (admins[cnt]-'A'));
				// i가 경우의 수가 존재하는 값
				
				for (int j = 0; j < list[ad][i].size(); j++) {
					int n = list[ad][i].get(j);
					pos[n][cnt] += pos[i][cnt-1];
					pos[n][cnt] %= 1000000007;
				}
			}
		}
	}

}
