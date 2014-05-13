package chapter5;

public class Question2 {
    public static void main(String[] args) {
        double d = 0.875;
        printDecimalToBinary(d);
    }

    public static void printDecimalToBinary(double d) {
        if(d < 0 || d > 1) {
            System.out.println("ERROR");
            return;
        }
        StringBuilder sb = new StringBuilder(".");

        for(int i = 1; i <= 32; i++){
            double minus = Math.pow(2,-i);
            if(d >= minus){
                sb.append("1");
                d = d - minus;
            } else {
                sb.append("0");
            }
            if(d == 0) {
                break;
            }
        }
        if(d != 0){
            System.out.println("ERROR");
        } else {
            System.out.println(sb.toString());
        }
    }
}
