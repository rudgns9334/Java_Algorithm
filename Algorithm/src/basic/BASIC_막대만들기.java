package basic;

public class BASIC_막대만들기 {

	static int[] dp = new int[7];
	public static void main(String[] args) {
		
		dp[1] = 2;
		dp[2] = 5;
		
		// 빨파 -> 빨파파 빨파노
		// 빨노 -> 빨노파 빨노노
		// 파빨 -> 파빨파 파빨노
		// 노빨 -> 노빨파 노빨노
		for (int i = 3; i <= 6; i++) {
			dp[i] = dp[i-1]*2 + dp[i-2];
		}
		
		System.out.println(dp[6]);

	}

}
