//Jianyu_Wang_HW1c

final int n=40;

void setup(){
  size(800,900);
}

void draw(){
     
    int y=width;
    int x=height;
    background(0,0,0);
    
    strokeWeight(2);
    for (int i = 1; i < n; ++i) {
        stroke(70+(180*i/n),40+(140*i/n),110+(140*i/n));
        line(0,((float)x/n)*i,y,((float)x/n)*i); //r
        line(((float)y/n)*i,0,((float)y/n)*i,x); //v
    }
   // exit();
}