package chapter9;
import java.util.Set;
import java.util.HashSet;
//cc150 Q9.6
public class Question6 {
    public static void main(String[] args){
        Set<String> rs = generateParens(10);
        return;
    }

    public static Set<String> generateParens(int remaining){
        Set<String> set = new HashSet<String>();
        if(remaining == 0){
            set.add("");
        }
        else{
            Set<String> prev = generateParens(remaining-1);
            //get each parens from the previous level
            for(String s : prev){
                for(int i = 0; i < s.length(); i++){
                    if(s.charAt(i) == '('){
                        String insert = insertParens(s,i);
                        //hashset automatically checks for duplicates
                        set.add(insert);
                    }
                }
                set.add("()"+s);
            }
        }
        return set;
    }

    private static String insertParens(String s, int index){
        String left = s.substring(0, index+1);
        String right = s.substring(index+1, s.length());
        return left + "()" + right;
    }
}
