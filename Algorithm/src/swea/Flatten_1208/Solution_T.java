package swea.Flatten_1208;
import java.io.FileInputStream;
import java.util.Scanner;

// Array 사용
// Scanner 사용
public class Solution_T {

	
	    static int[] floor;
	    static int dump,minIdx,maxIdx;
	    public static void main(String[] args)throws Exception {
	        System.setIn(new FileInputStream("input.txt"));
	        Scanner sc = new Scanner(System.in);

	        long start = System.nanoTime();
	        for(int t=1;t<=10;t++) {
	            dump = sc.nextInt();
	            floor = new int[100];

	            for(int i=0;i<100;i++) {
	                floor[i] = sc.nextInt();
	            }

	            minIdx = 0;
	            maxIdx = 0;
	            for(int i=0;i<dump;i++) {
	                // 최소, 최대의 index
	                reset();
	                // 최대, 최소 차이 비교 
	                int gap = floor[maxIdx] - floor[minIdx];
	                if(gap == 0 || gap == 1) break;
	                // 평탄화 작업 
	                floor[maxIdx]--;
	                floor[minIdx]++;
	            }
	            reset(); // 최종적인 min,max의 index 계산 
	            int result = floor[maxIdx] - floor[minIdx];

	            System.out.println("#" + t + " " + result);
	        }
	            long end = System.nanoTime();
	            System.out.println("duration : " + (end-start));
	        }
	    
        static void reset() {
            for(int i = 0;i<100;i++) {
                if(floor[i] < floor[minIdx]) minIdx = i;
                if(floor[i] > floor[maxIdx]) maxIdx = i;
            }
        }

}
