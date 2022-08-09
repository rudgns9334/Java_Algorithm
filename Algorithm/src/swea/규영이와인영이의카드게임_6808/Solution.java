package swea.규영이와인영이의카드게임_6808;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int T, winCnt, loseCnt;
	static int[] gyu;
	static boolean[] card;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T;t++) {
			gyu = new int[9];
			card = new boolean[19];
			winCnt = 0;
			loseCnt = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0;i<9;i++) {
				gyu[i] = Integer.parseInt(st.nextToken());
				card[gyu[i]] = true;
			}
			fight(0,0,0);
			
			System.out.println("#" + t + " " + winCnt + " " + loseCnt);
		}
	}
	
	static void fight(int idx, int gSum, int iSum) {
		if( idx == 9 ) {
			if(gSum > iSum) winCnt++;
			else if(iSum > gSum) loseCnt++;
			return;
		}
		for(int i=1;i<=18;i++) {
			if(!card[i]) {
				card[i] = true;
				int gy = gSum;
				int in = iSum;
				if(gyu[idx]>i) gy += gyu[idx] + i;
				else if(gyu[idx]<i) in += gyu[idx] + i;
				fight(idx+1,gy,in);
				card[i] = false;
			}
		}
	}

}
