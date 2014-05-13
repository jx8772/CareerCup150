package chapter9;

//cc150 Q9.1
//when i is 37, A[i] will overflow
public class Question1 {
    public static void main(String[] args){
        System.out.println(childClimbStair(10));
    }

    //method 1: bottom to top, dp
    public static int childClimbStair(int n){
        //A[i] is how many ways to climb to i steps
        int[] A = new int[n+1];
        A[0] = 1;
        A[1] = 1;
        A[2] = 2;
        for(int i = 3; i < A.length; i++){
            A[i] = A[i-1] + A[i-2] + A[i-3];
        }
        return A[A.length-1];
    }
    //method 2: top to bottom, recursive
//    public static int childClimbStair(int n){
//        if(n<0){
//            return 0;
//        }
//        else if(n== 0){
//            return 1;
//        }
//        else{
//            return childClimbStair(n-1) + childClimbStair(n-2) + childClimbStair(n-3);
//        }
//    }
}
