int level = 0;

void sierpinski(int x1, int y1, int x2, int y2, int x3, int y3, int level) {
  if (level == 0) {
    stroke(255-x1*(255.0/width), 255-y2*(255.0/height),x3*(255.0/width));
    triangle(x1,y1,x2,y2,x3,y3);
    return;
  }
    sierpinski(x1,y1, (x1+x2)/2,(y1+y2)/2, (x1+x3)/2,(y1+y3)/2, level-1);
    sierpinski(x2,y2, (x2+x1)/2,(y2+y1)/2, (x2+x3)/2,(y2+y3)/2, level-1);
    sierpinski(x3,y3, (x3+x1)/2,(y3+y1)/2, (x3+x2)/2,(y3+y2)/2, level-1);
}


void setup() {
  size(800,800);
  frameRate(1);
}

void draw() {
  background(0);
  fill(0,0,0);
  strokeWeight(2);
  sierpinski(0,height, width/2,0, width,height, level);
  level++;
  if (level == 8)
    level = 0;
}