package live.ws01;

public class R1_FactorialTest {
	
	// loop
	static int factorial1(int n) {
		int res = 1;
		
		for(int i=n;i>=1;i--) {
			res*=i;
		}
		return res;
	}
	
	static int factorial2(int n) {
		
		if(n==1) return 1;
		
		return n*factorial2(n-1);
	}
	
	static int rst = 1;
	static void factorial3(int n) { // n값을 기존 누적값에 곱하는 방식으로 계승을 구한다.
		if(n<1) return;
		rst*=n;
		factorial3(n-1);
	}

	public static void main(String[] args) {
		System.out.println(factorial1(5));
		System.out.println(factorial2(5));
		factorial3(5);
		System.out.println(rst);
	}

}
