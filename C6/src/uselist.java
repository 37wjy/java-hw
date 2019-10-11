import java.util.ArrayList;

public class uselist{
    public static void main(String[] args) {
        ArrayList<String> a=new ArrayList<String>();
        for (int i = 0; i < 3; i++) {
            a.add("dasdsadsad");//垃圾java 指针只有32位
        }
        System.out.println(a);
    }

    public String toString(){
        StringBuilder b=new StringBuilder();
        b.append("a").append("b");
        return b.toString();
    }
}