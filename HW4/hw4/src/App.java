import java.util.HashMap;
import java.util.Map;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Random;
import java.util.concurrent.TimeUnit;



class Vec3d {
    public double x,y,z;
            
    public Vec3d(double xi, double yi, double zi) {
        x = xi; y = yi; z = zi;
    }
    public Vec3d(){
        x=0;
        y=0;
        z=0;
    }

    public void set(double xi, double yi, double zi){
        x = xi; y = yi; z = zi;
    }

    public static Vec3d add(Vec3d a, Vec3d b) {
        return new Vec3d(a.x+b.x,a.y+b.y,a.z+b.z); //TODO:
    }
    public static Vec3d sub(Vec3d a, Vec3d b) {
        return new Vec3d(a.x-b.x,a.y-b.y,a.z-b.z); //TODO:
    }
    public static double dot(Vec3d a, Vec3d b) {
        return a.x*b.x+a.y*b.y+a.z*b.z; //TODO:
    }
    public static Vec3d cross(Vec3d a, Vec3d b) {
        return new Vec3d();
    }
    public String toString(){
        return "("+x+","+y+","+z+")";
    }

}


class Body {
    public String name;
    private double mass;
    private Vec3d x; //position of the body in 3-space
    private double or;
    double v; // velocity
    double ang;
    private double d;
    private Vec3d a; // acceleration
    public String f;
    
    
    public Body(){name="NaN";mass=0;x=new Vec3d();v=0;a=new Vec3d();f="NaN";ang=0;or=0;d=0;}//black hole
    public Body(String name, double mass, double orbDistance, double vel,String father,Vec3d fp,double diameter) {
        this.name=name;
        this.mass=mass;
        f=father;
        this.x = new Vec3d(); // pick a random spot at the correct orbital distance
        v=Double.isNaN(vel)?0:vel;
        this.a = new Vec3d();
        Random r=new Random();
        ang=2*Math.PI*r.nextDouble();
        or=orbDistance;
        x.x=fp.x+Math.sin(ang)*or;
        x.y=fp.y+Math.cos(ang)*or;
        x.z=0;
        d=diameter;
    }

    public Vec3d getPose(){return x;}
    public void zerAcceleration() {
        this.a.set(0,0,0);
    }
   /*  public void addAcceleration(Body b) {
        v.x+= (b.x.x>x.x?1:-1)*6.67e-11*mass*b.mass/Math.pow(b.x.x-x.x,2.0);// add the acceleration due to b to a
        v.y+= (b.x.y>x.y?1:-1)*6.67e-11*mass*b.mass/Math.pow(b.x.y-x.y,2.0);
        v.z+= (b.x.z>x.z?1:-1)*6.67e-11*mass*b.mass/Math.pow(b.x.z-x.z,2.0);
    } */
    public void move(Vec3d fp,double spd){
        ang=ang+v/spd;
        if(ang>2*Math.PI)ang=0;
        x.x=fp.x+Math.sin(ang)*or/spd;
        x.y=fp.y+Math.cos(ang)*or/spd;
    }
    public String toString(){
        return name+"  :"+"("+x.x+","+x.y+","+x.z+")"+"("+Math.sin(ang)*or+","+Math.cos(ang)*or+","+0+")";
    }

}

class Solar{
    Map<String, Body> Solar;

    public Solar(){Map<String, Body> S=new HashMap<String, Body>();Solar=S;}
    public void readIn() {
        File file = new File("solarsystem.dat");
        BufferedReader reader = null;
        String temp = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            temp = reader.readLine();
            Body t0 = new Body();
            Solar.put("NaN", t0);
            while ((temp = reader.readLine()) != null) {
                String[] strArr = temp.split("\\s+");

                Body t = new Body(strArr[0], Double.valueOf(strArr[2]),
                        (Double.valueOf(strArr[4]) + Double.valueOf(strArr[5])) / 2,
                        2*Math.PI/Double.valueOf(strArr[6]),
                        strArr[1], Solar.get(strArr[1]).getPose(),Double.valueOf(strArr[3]));
                Solar.put(strArr[0], t);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
} 

public class App {
    final static double spd = 10;//记得改下，要不地球转一圈要2个小时

    public static void main(String[] args) throws InterruptedException {
        Solar a=new Solar();
        a.readIn();
        String s="Sun",v="Venus",e="Earth",m="Moon";
        //while(true){
          //  TimeUnit.SECONDS.sleep(2);
            for(Body pl:a.Solar.values()){
                
                if(pl.f=="NaN")continue;
                if(pl.name.equals(s)||pl.name.equals(v)||pl.name.equals(e)||pl.name.equals(m)){
                    System.out.println(pl);
                }
                //pl.move(a.Solar.get(pl.f).getPose(), spd);
                
            }        
        //}
        
    }
}