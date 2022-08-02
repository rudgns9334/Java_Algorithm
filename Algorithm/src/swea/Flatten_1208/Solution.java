package swea.Flatten_1208;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int[] boxes = new int[100];
	static int dump;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for(int tc=1;tc<=10;tc++) {
			dump = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0;i<100;i++) {
				boxes[i] = Integer.parseInt(st.nextToken());
			}
			
			Dump(dump);
			System.out.println("#"+tc+" "+ (boxes[findMax()]-boxes[findMin()]));
		}
	}
	
	static void Dump(int d) {
		if(d==0) return;
		int maxIdx = findMax();
		int minIdx = findMin();
		boxes[maxIdx]--;
		boxes[minIdx]++;
		Dump(d-1);
	}

	static int findMax() {
		int max = Integer.MIN_VALUE;
		int idx = 0;
		for (int i = 0; i < boxes.length; i++) {
			if(max < boxes[i]) {
				max = boxes[i];
				idx = i;
			}
		}
		return idx;
	}
	
	static int findMin() {
		int min = Integer.MAX_VALUE;
		int idx = 0;
		for (int i = 0; i < boxes.length; i++) {
			if(min > boxes[i]) {
				min = boxes[i];
				idx = i;
			}
		}
		return idx;
	}
}
