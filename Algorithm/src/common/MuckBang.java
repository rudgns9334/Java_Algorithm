package common;

import java.util.Arrays;

public class MuckBang {
	
	static public class Food{
		public int amount;
		public int index;
	}
	
	public static void main(String[] args) {
		int[] food_times = {3,1,1,1,1,1};
		long k = 2;
		int answer = 0;
        int length = food_times.length;
        long ssum = 0;
        
        Food[] food = new Food[length];
        for(int i=0;i<length;i++) {
            ssum += food_times[i];
        	food[i] = new Food();
        	food[i].amount = food_times[i];
        	food[i].index = i+1;
        }
        if(ssum<=k) System.out.println(-1);
        else {
        	Arrays.sort(food, (o1, o2) -> o1.amount == o2.amount ? o1.index - o2.index : o1.amount - o2.amount);
            long minV = 0;
            long sum = 0;

            for(int i=0;i<length;i++){
                if(minV < food[i].amount){
                	sum = (food[i].amount-minV)*(length-i);
                	minV = food[i].amount;

                    if(k>=sum){
                        k -= sum;
                    }else {
                        Arrays.sort(food,i,length,(o1, o2)->o1.index - o2.index);
                    	answer = food[i+(int) (k % (length-i))].index;
                        
                        break;
                    }
                }
            }
            System.out.println(answer);
        }
        

	}

}
