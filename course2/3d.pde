PShape earth;

void setup() {
    size( 800, 800,P3D); //P3D 3d模式
    PImage img=loadImage("earth.jpg");//minh
    noStroke();
    sphereDetail(1000);
    earth=createShape(SPHERE,500);
    earth.setTexture(img);
    frameRate(60);
}

float x=0,y=0;
float vx=0.0;

void draw() {
 
  translate(width/2, height/2, -800);
  rotateX(x*PI/180.0);
  rotate(y*PI/180.0);
  sphere(100);
  shape(earth); 
  x+=vx;

}



void mousePressed(){
    if(mouseButton==LEFT){//判按键
      vx+=1.0;
    }
    else{
      vx--;
    }
}