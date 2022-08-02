package basic;

public class BASIC_RecursiveCall {

	public static void main(String[] args) {
//		m1();
//		m2();
//		m2_correct();
//		m2_correct2();
//		m3(5);
		m4(0);
	}

	static int m1_cnt = 10;
	
	static void m1() {
//		{
//			System.out.println("m1()");
//			m1();
//		}
		
//		{
//			// local 변수는 항상 새롭게 만들어진다. 고로 원하는 대로 증가된 값이 나오지 않는다.
//			int i = 10;
//			System.out.println("m1 : i " + i++);
//			m1();
//		}
		
		{
			// static 변수는 ?? 잘 증가가 된다.
			// break를 걸어주는 것이 중요.
			System.out.println("m1 : m1_cnt " + m1_cnt++);
			m1();
		}
	}
	
	static int m2_cnt = 5;
	
	// 출력이 어떻게 나올까? 생각해보고 출력해보기
	static void m2() {
		System.out.println("1 : m2_cnt : " + m2_cnt);
		if(m2_cnt > 0) {
			m2_cnt--;
			m2();
		}
		System.out.println("2 : m2_cnt : " + m2_cnt);
	}
	
	static int m2_correct_cnt = 5;
	
	// 개선해보자.
	// 시작 log가 한번 더 실행된다.
	// 5-4-3-2-1-1-2-3-4-5를 원하는데 현재는 뒷부분이 0-0-0-0-0이다. 고쳐보자.
	static void m2_correct() {
		System.out.println("1 : m2_correct_cnt : " + m2_correct_cnt);
		if(m2_correct_cnt == 0) { // 끝내는 조건
			return;
		}
		m2_correct_cnt--;
		m2_correct();
		
		// 끝내는 조건 뒤에 있는 코드는 필요한 만큼 실행된다.
		System.out.println("2 : m2_correct_cnt : " + m2_correct_cnt);
	}
	
	// 제가 한번 바꿔보겠습니다.
	// 5-4-3-2-1-1-2-3-4-5
	static int m2_correct2_cnt2 = 5;
	static void m2_correct2() {
		// 기저 조건이 맨 위로
		if(m2_correct2_cnt2 == 0) { // 끝내는 조건
			return;
		}
		System.out.println("1 : m2_correct2_cnt2 : " + m2_correct2_cnt2);
		
		m2_correct2_cnt2--;
		m2_correct2();
		m2_correct2_cnt2++;
		
		System.out.println("2 : m2_correct2_cnt2 : " + m2_correct2_cnt2);
	}
	
	static void m3(int m3_cnt) {
		// 파라미터의 m3_cnt 값은 재귀호출을 하면서 계속 감소해서 전달될 것이다 라는 전제
		// 기저조건을 맨위로
		if(m3_cnt == 0) {
			return;
		}
		
		System.out.println("1 : m3_cnt : " + m3_cnt);
		
		// 이건 잘 된다.
//		m3_cnt--;
//		m3(m3_cnt); // 호출 이후 원복시킬 필요가 없을 때는 그외 필요가 없다.
//		m3_cnt++;
		
		// 다르게 해보자.
//		m3(m3_cnt--); // 무한 반복되겠는데... 그치 맞지 전달하고 감소하니까
//		m3(--m3_cnt); // 이러면? 실행은 되지만 끝나고 5까지 도달할 수 없다.
//		m3_cnt++; // 고로 이건 또 다시 넣어줘야행
		
		// 이 방법이 만능이다.
		m3(m3_cnt - 1); // 당연히 된다.
		
		// 끝내는 조건 뒤에 있는 코드는 필요한 만큼 실행된다.
//		System.out.println("2 : m3_cnt : " + m3_cnt);
	}
	
	static int[] m4_intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
	static int m4_even_cnt = 0;
	static int m4_even_sum = 0;
	// 미션 : m4_even_cnt, m4_even_sum 출력
	// 시작은 0부터 파라미터 전달
	static void m4(int m4_cnt) {
		// 기저 조건
		if(m4_cnt==m4_intArray.length) {
			System.out.println(m4_even_cnt + " " + m4_even_sum);
			return;
		}
		// 짝수 cnt, sum 계산
		if(m4_intArray[m4_cnt]%2==0) {
			m4_even_cnt++;
			m4_even_sum += m4_intArray[m4_cnt];
		}
		// 재귀 호출
		m4(m4_cnt+1);
	}
}
