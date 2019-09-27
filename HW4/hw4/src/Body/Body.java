package Body;

import java.util.Random;
import Vec3d.Vec3d;

/**
 *
 * @author dkruger
 * 
 */

public class Body {
    private String name;
    private double mass;
    private Vec3d x; //position of the body in 3-space
    private Vec3d v; // velocity
    private Vec3d a; // acceleration
    
    public Body(){name="NaN";mass=0;x=new Vec3d();v=new Vec3d();a=new Vec3d();}
    public Body(String name, double mass, double orbDistance, double vel,Body fatherPos) {
        this.name=name;
        this.mass=mass;
        this.x = new Vec3d(); // pick a random spot at the correct orbital distance
        this.v = new Vec3d();
        this.a = new Vec3d();
        Random r=new Random();
        double or=2*Math.PI*r.nextDouble();

    }
    
    public void zerAcceleration() {
        this.a.set(0,0,0);
    }
    public void addAcceleration(Body b) {
        v.x+= (b.x.x>x.x?1:-1)*6.67e-11*mass*b.mass/Math.pow(b.x.x-x.x,2.0);// add the acceleration due to b to a
        v.y+= (b.x.y>x.y?1:-1)*6.67e-11*mass*b.mass/Math.pow(b.x.y-x.y,2.0);
        v.z+= (b.x.z>x.z?1:-1)*6.67e-11*mass*b.mass/Math.pow(b.x.z-x.z,2.0);
    }

    public String toString(){
        return name+"  :"+"("+x.x+","+x.y+","+x.z+")"+"("+v.x+","+v.y+","+v.z+")";
    }
    
  //  public static void main(String[] args) {
        
        /* double earthmass = 5.97e24;
        double earthOrbitalDistance = 160e9; // meters from sun
        double earthVel = 29783; // Find this!!
        double moonMass = 7.349e22; //TODO
        double moonOrbitalDistance = 3.844039e8; // TODO
        double moonVel = 1023;//TODO
        // start earth and moon at the random places in circular orbits
        Body earth = new Body("Earth", earthmass, earthOrbitalDistance, earthVel);
        Body moon = new Body("Moon", moonMass, moonOrbitalDistance, moonVel);
        System.out.println(earth); // print out position, velocity
        System.out.println(moon);
        //earth.zerAcceleration();
        //earth.addAcceleration(moon); */
    //}
}
