package live.ws01;

import java.util.Scanner;

public class ScannerTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("우리는 몇기?");
		int no = sc.nextInt();
		System.out.println("==>우리는 SSAFY" + no + "기!!!!");
		
		System.out.print("우리를 대표하는 한마디?");
		String msg = sc.next();
//		String msg = sc.nextLine(); 이걸로 받아버리면 nextInt()에 있는 \n때문에 바로 처리되어버림
		System.out.println("==>우리를 대표하는 한마디는? " + msg);
		
		sc.close();
	}

}
