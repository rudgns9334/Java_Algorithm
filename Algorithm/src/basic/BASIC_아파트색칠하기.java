package basic;

public class BASIC_아파트색칠하기 {
	
	static int memoi[] = new int[11]; // 0 dummy

	public static void main(String[] args) {
		memoi[1] = 2;
		memoi[2] = 3;
		
		for (int i = 3; i <= 10; i++) {
			// 규칙 ( 수식 )을 i라는 일반화된 식으로 표현
			
			memoi[i] = memoi[i-1] + memoi[i-2];
		}

	}

}
