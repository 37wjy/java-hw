import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Function;

import javax.lang.model.element.Element;
import javax.swing.JFrame;

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

        for (int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i)+",");//',' 会变成数字值
        }
        System.out.println();

        Iterator<Integer> it=arr.iterator();
        while(it.hasNext()){
            System.out.print(it.next()+",");
        }
        System.out.println();
        
        for (var a : arr) {
            System.out.print(a+",");
        }
        
        
        //for (var a : it) {//无法 遍历
          //  System.out.println(a);
        //}
    }
}
