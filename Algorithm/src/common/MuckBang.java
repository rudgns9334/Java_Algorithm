package common;

import java.util.Arrays;

public class MuckBang {

	public static void main(String[] args) {
		int[] food_times = {3, 1, 2, 2, 4, 6};
		long k = 17;
		int answer = 0;
        int length = food_times.length;
        int[] sort_food = Arrays.copyOf(food_times, length);
        Arrays.sort(sort_food);
        int cnt = 0;
        int minV = 0;
        long sum = 0;
        long ssum = 0;
        for(int i=0;i<food_times.length;i++) {
        	ssum += food_times[i];
        }
        if(k>=ssum) System.out.println(-1);
        for(int i=0;i<sort_food.length;i++){
            if(minV < sort_food[i]){
            	sum = (sort_food[i]-minV)*(length-i);
            	cnt = minV;
            	minV = sort_food[i];

                if(k>=sum){
                	if(i==length-1) cnt = sort_food[i];
                    k -= sum;
                }else{
                    break;
                }
            }
        }
        for(int i=0;i<food_times.length;i++){
            if(k==0 && food_times[i] > cnt) {
            	answer = i+1;
            	break;
            }
            else if(food_times[i] > cnt) k--;
        }
        if(answer==0) answer = -1;
        System.out.println(answer);

	}

}
