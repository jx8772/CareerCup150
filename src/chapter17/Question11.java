package chapter17;

/**
 * Problem: Implement a method rand7() given rand5(). That is, given a method that generates a random number between 0 and 4 (inclusive), write a
 * method that generates a random number between 0 and 6 (inclusive)
 * Created by xiangji on 9/11/14.
 */
public class Question11 {
    public static void main(String[] args){
        int[] arr = new int[7];
        int testNum = 10000000;
        //randomly generate number
        for(int i = 0; i < testNum; i++){
            arr[rand7()]++;
        }
        //calculate the percentage
        for(int i = 0; i < 7; i++){
            System.out.println(i + ": " + (double)arr[i]*100.0/testNum);
        }
    }

    public static int rand7(){
        while(true){
            //randomly generate a number between 0 and 24. Each number's probability is 1/25.
            int num = 5*rand5() + rand5();
            if(num < 21){
                //generate a number between 0 and 6. Each number's probability is 3/21 = 1/7
                return num%7;
            }
        }
    }

    /*generate a number between 0 and 4 inclusive, and each number's probability is equal*/
    public static int rand5(){
        return (int)((Math.random()*100)%5);
    }

}
