import java.util.ArrayList;
import java.util.Iterator;

/**
 * arrlist
 */
public class arrlist {

    public static void main(String[] args) {
        ArrayList<Integer> arr=new ArrayList<>();
        
        for (int i = 0; i < 20; i++) {
            arr.add(i);
        }
        System.out.println(arr);

        Iterator<Integer> it=arr.iterator();//在新建的时候会复制，空的时候会无限遍历
        while(it.hasNext()){
            System.out.print(it.next()+",");
        }
        System.out.println();
        
        for (var a : arr) {
            System.out.print(a+",");
        }
    }
}