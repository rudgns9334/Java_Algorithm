package swea.원재의메모리복구하기_1289;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			String bit = br.readLine();
			int bit_l = bit.length(); // 비트 길이
			boolean reverse = false;
			int cnt = 0;
			for(int i=0;i<bit_l;i++) {
				if(!reverse) { //reverse = false;
					if(bit.charAt(i)=='1') {
						reverse = !reverse;
						cnt++;
					}
				}else { // reverse = true;
					if(bit.charAt(i)=='0') {
						reverse = !reverse;
						cnt++;
					}
				}
			}
			System.out.println("#"+tc+" "+cnt);
		}
	}

}
