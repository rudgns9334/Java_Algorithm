package baekjoon.잃어버린괄호_1541;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	static int ans;
	static List<Character> oper = new ArrayList<>();
	static List<Integer> list = new ArrayList<>();
	static List<Integer> makeNum = new ArrayList<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		ans = 0;
		for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i)>='0' && str.charAt(i)<='9') {
				makeNum.add(str.charAt(i)-'0');
			}else {
				list.add(MakeNum());
				oper.add(str.charAt(i));
			}
		}
		list.add(MakeNum());
		
		boolean m = false;
		int sum = list.get(0);
		int minusSum = 0;
		for (int i = 0; i < oper.size(); i++) {
			if(m) {
				minusSum += list.get(i+1);
			}else {
				if(oper.get(i)=='+') {
					sum += list.get(i+1);
				}else {
					m = true;
					minusSum += list.get(i+1);
				}
			}
		}
		ans = sum - minusSum;
		System.out.println(ans);

	}
	
	static int MakeNum() {
		int num = 0;
		for (int i = 0; i < makeNum.size() ; i++) {
			num *= 10;
			num += makeNum.get(i);
		}
		makeNum.clear();
		return num;
	}

}
