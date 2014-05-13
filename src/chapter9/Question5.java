package chapter9;
import java.util.ArrayList;

//cc150 Q9.5
public class Question5 {
    public static void main(String[] args) {
        String s = "abcd";
        ArrayList<String> rs = permutations(s);
        return;
    }

    public static ArrayList<String> permutations(String s){
        ArrayList<StringBuilder> rs_sb = new ArrayList<StringBuilder>();
        rs_sb.add(new StringBuilder(""));
        for(int i = 0; i < s.length(); i++){
            ArrayList<StringBuilder> current = new ArrayList<StringBuilder>();
            for(StringBuilder temp : rs_sb){
               for(int j = 0; j < temp.length()+1; j++){
                   temp.insert(j, s.charAt(i));
                   current.add(new StringBuilder(temp));
                   temp.deleteCharAt(j);
               }
           }
            rs_sb = new ArrayList<StringBuilder>(current);
        }
        ArrayList<String> rs = new ArrayList<String>();
        for(StringBuilder sb : rs_sb) {
            rs.add(sb.toString());
        }
        return rs;
    }
}
