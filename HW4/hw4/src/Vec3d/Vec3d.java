package Vec3d;
/**
 *
 * @author dkruger
 *  由xxx 继续编写2.0系列
 */
public class Vec3d {
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
    
    // Not needed this week
    public static Vec3d cross(Vec3d a, Vec3d b) {
        return new Vec3d();
    }

    public String toString(){
        return "("+x+","+y+","+z+")";
    }

    /*public static void main(String[] args) {
        Vec3d v1 = new Vec3d();
        System.out.println(v1);
        Vec3d v2 = new Vec3d(1,2,3);
        System.out.println(v2);
        Vec3d v3 = new Vec3d(4,1,-1);
        System.out.println(add(v2,v3));
        System.out.println(sub(v2,v3));
        System.out.println(dot(v2,v3));
    }*/
}
