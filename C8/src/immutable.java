/**
 * immutable
 */
public class immutable {

    public static void main(String[] args) {
        String s1 = "abc";
        Integer i1 = new Integer(5);
        Integer i2 = 5;
        System.out.println(i1 == i2);

        Integer j = 2;
        System.out.println(2 == j);
        System.out.println(j.equals(2));

        String s2 = new String("abc");
        System.out.println(s1 == s2);// 判断的不是内容
        System.out.println(s1.equals(s2));
    }

}