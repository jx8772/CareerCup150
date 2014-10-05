package chapter17;

/**
 * Problem: Since XML is very verbose, you are given a way of encoding it where each tag gets mapped to a pre-defined integer value. There's an example
 * in the CTCI book (17.10), I will ignore it here for simplity.
 * Created by xiangji on 9/11/14.
 */
public class Question10 {
    public static void main(String[] args){
        Element root = new Element("family");
        Attribute a1 = new Attribute("lastName", "Ji");
        Attribute a2 = new Attribute("state", "CA");
        root.insert(a1);
        root.insert(a2);

        Element child = new Element("person", "Some Message");
        Attribute a3 = new Attribute("firstName", "Xiang");
        child.insert(a3);

        root.insert(child);

        String s = encodeToString(root);
        System.out.println(s);
    }

    public static void encode(String s, StringBuilder sb){
        sb.append(s);
        sb.append(" ");
    }

    public static void encode(Attribute a, StringBuilder sb){
        sb.append(a.getTagCode()).append(" ");
        sb.append(a.value).append(" ");
    }

    public static void encode(Element e, StringBuilder sb){
        //process namecode
        encode(e.getNameCode(), sb);

        //process attributes
        for(Attribute a : e.attributes){
            encode(a, sb);
        }
        encode("0", sb);

        //process value (if any), otherwise process children
        if(e.value != null && !e.value.equals("")){
            encode(e.value, sb);
            encode("0", sb);
        }
        else{
            for(Element child : e.children){
                encode(child, sb);
            }
        }
        encode("0", sb);
    }

    public static String encodeToString(Element e){
        StringBuilder sb = new StringBuilder();
        if(e == null){
            return sb.toString();
        }
        encode(e, sb);
        return sb.toString();
    }


}
