/**
 * threadTest
 */
public class threadTest extends Thread{
    private int x,y;
    public static void main(String[] args) {
        Thread a=new threadTest(1, 4);
        Thread b=new threadTest(4, 0);
        a.start();;
        b.start();
    }

    threadTest(int a,int b){
        x=a;
        y=b;
    }

    public void run(){
        System.out.println(x-y);
    }
}