package live.ws01;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BufferedReaderScannerTest {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		System.setIn(new FileInputStream("inputTC.txt"));
//		Scanner sc = new Scanner(System.in);
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		
		long start = System.nanoTime();
		
		int Tc = Integer.parseInt(in.readLine());
		for(int tc = 1; tc<=Tc; tc++) {
			int N = Integer.parseInt(in.readLine());
			
			int sum = 0;
			for(int i=0;i<N;i++) {
				StringTokenizer st = new StringTokenizer(in.readLine()," ");
				for(int j=0;j<N;j++) {
					sum += Integer.parseInt(st.nextToken());
				}
			}
			System.out.println("#" + tc + " " + sum);
		}
		
//		sc.close();
		long end = System.nanoTime();
		System.out.println((end-start)/1_000_000_000.0 + "s");
	}

}

// Scanner 썼을 때는 3초
// Buffer 썼을 때는 0.3513467초