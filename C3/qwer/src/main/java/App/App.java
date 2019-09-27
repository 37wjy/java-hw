
class Vec3d{
    private double _x,_y,_z;
    public Vec3d(){_x=0;_y=0;_z=0;}
    public Vec3d(double x,double y,double z){_x=x;_y=y;_z=z;}

    
}

public class App 
{
    public  App() {
        System.out.println("bdsads");
    }
    public static void main( String[] args ) {
        App a=new App();

        a.b();  //b() 不行
        System.out.println( "Hello World!" );
    }

    //method(面向对象) menber(java 的称呼)
    public  void b() {
        System.out.println("dasd");
        
    }
}
