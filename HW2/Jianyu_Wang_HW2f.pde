float t=0;
float x1=cos(13*t);
float y1=cos(15*t);

void setup(){
    size(600,600);
    background(0,0,0);
    
}

void draw(){
  
    translate(width/2.0,height/2.0);
    scale(width/2.0,height/2.0);
    float x=cos(13*t);
    float y=cos(15*t);
    stroke(y*255.0/2+255/2,155,x*255.0/2+255/2);
    strokeWeight(4.0/(height+width));
    line(x,y,x1,y1);
    t+=8.0/(height+width);
    x1=x;
    y1=y;
    if(t>3.14)
    {
      t=0;
      x1=cos(13*t);
      y1=cos(15*t);
    }
}