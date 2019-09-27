
int level=0;
void setup() {
  size(700,900);
  frameRate(1);
}


void ko(int level,float x1,float y1,float x2, float y2) {
      if(level == 0){
        stroke((y1+y2)*255/2.0/height,(x1+x2)*255/width/2.0,(width-(x1+x2)/2.0)*255/width);
        line(x1, y1,x2, y2);
      }
      else{
          float dx = x2 - x1;
          float dy = y2 - y1;
 
          float xx =x1 + dx / 3.0;
                float xy=y1 + dy / 3.0;
          float yx =x1 + dx * 2.0 / 3.0;
                float yy=y1 + dy * 2.0 / 3.0;
          float zx =(x1 + x2) / 2 + sin(PI/3.0) * (y1 - y2) / 3.0;
          float zy=(y1 + y2) / 2 + sin(PI/3.0) * (x2 - x1) / 3.0;
                ko(level-1, x1,y1, xx,xy);
                ko(level-1, xx,xy, zx,zy);
                ko(level-1, zx,zy, yx,yy);
                ko(level-1, yx,yy, x2,y2);
      }
    }


void draw() {
    background(0);
    strokeWeight(2);
    ko(level, width/2,10, 10,width*sin(PI/3));
    ko(level, width-10,width*sin(PI/3), width/2,10);
    ko(level, 10,width*sin(PI/3),  width-10,width*sin(PI/3));

    level++;
    if (level == 8)
        level = 0;
}