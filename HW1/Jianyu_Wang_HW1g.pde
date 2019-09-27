 //<Jianyu_Wang_HW1g>//
void setup() {
    size( 300,200);
}

float r1=10,r2=20;  //define redius, r1 for first ball, r2 for second
float m1=10,m2=10;   // mass
float v1x = random(1,-1),v1y=random(2,-2);
float v2x = random(3),v2y=random(2);
float x1=random(width-r1,r1),y1=random(height-r1,r1);    //init position for first
float x2=width/2,y2=height/2;    //init position for second
color c1 = color(255, 0, 0);// ball color
color c2 = color(0, 255, 0);
boolean flag=false;

void draw() 
{
    background(0,0,0);
    fill(c1);
    strokeWeight(0);
    circle(x1,y1,r1*2);
    fill(c2);
    circle(x2,y2,r2*2);
    v1x=wall_x(x1,v1x,r1);
    v2x=wall_x(x2,v2x,r2);
    v1y=wall_y(y1,v1y,r1);
    v2y=wall_y(y2,v2y,r2);
    if(collide()&&!flag){
        oncllide(x1,y1,x2,y2);
    }
   // if(flag){
   //   if(!collide()) flag=false;
    //}
    x1+=v1x;
    y1+=v1y;
    x2+=v2x;
    y2+=v2y; 
}

float wall_x(float i,float v,float r)
{   
    if((i-r)<=0)
    {
         return abs(v);
    }
     if(i+r>=width)
     {  
       return -abs(v);
     }
    return v;
}

float wall_y(float i,float v,float r)
{   
    if((i-r)<=0)
    {
        return abs(v);
    }
     if(i+r>=height)
     {  
       return -abs(v);
     }
    return v;
}

boolean collide()
{
    if(sqrt(pow(x1-x2+v1x+v2x, 2)+pow(y1-y2,2))<=(r1+r2))
    {
        return true;
    }
    return false;
}

void oncllide(float x1,float y1,float x2,float y2){
    float ang;
    float ang1=0,ang2=0;
    float ang1t,ang2t;
    //float f=0.0,f1=0.0,f2=0.0,f1f,f2f;
    float v1=0,v1v=0,v2=0,v2v=0,v1t=0;

    v1=sqrt(pow(v1x,2)+pow(v1y,2));
    v2=sqrt(pow(v2x,2)+pow(v2y,2));
    //v1=abs((float)(m1-m2)/(float)(m1+m2)*sqrt(pow(v1x,2)+pow(v1y,2))+(float)(2*m2)/(float)(m1+m2)*sqrt(pow(v2x,2)+pow(v2y,2)));
    //v2=abs((float)(m2-m1)/(float)(m1+m2)*sqrt(pow(v2x,2)+pow(v2y,2))+(float)(2*m1)/(float)(m1+m2)*sqrt(pow(v1x,2)+pow(v1y,2)));
      
    ang=getAngle((float)(x2-x1),(float)(y1-y2));//nNormal

    if(v1x!=0||v1y!=0)
    {
      ang1=getAngle(v1x,-v1y);
    }
    else
      ang1=ang;
    
    if(v2x!=0||v2y!=0)
    {
      ang2=getAngle(v2x,-v2y);
    }
    else
      ang2=ang+PI;
    
    v1v=v1*sin(ang1-ang);//y
    v1=v1*cos(ang1-ang);//x
    v2v=v2*sin(ang2-ang);
    v2=v2*cos(ang2-ang);
    
    v1t=v1;
    v1=((float)(m1-m2)*v1+(float)(2*m2)*v2)/(float)(m1+m2);   //reflect towardness: normal
    v2=((float)(m2-m1)*v2+(float)(2*m1)*v1t)/(float)(m1+m2);
    
    if(v1v>=0){
      v1v=sqrt(pow(v1v,2)+pow(v1,2));
      v1x=v1v*cos(ang+acos(v1/v1v));
      v1y=-v1v*sin(ang+acos(v1/v1v));
    }
    else{
      v1v=sqrt(pow(v1v,2)+pow(v1,2));
      v1x=v1v*cos(ang-acos(v1/v1v));
      v1y=-v1v*sin(ang-acos(v1/v1v));
    }
    if(v2v>=0){
      v2v=sqrt(pow(v2v,2)+pow(v2,2));
      v2x=v2v*cos(ang+acos(v2/v2v));
      v2y=-v2v*sin(ang+acos(v2/v2v));
    }
    else{
      v2v=sqrt(pow(v2v,2)+pow(v2,2));
      v2x=v2v*cos(ang-acos(v2/v2v));
      v2y=-v2v*sin(ang-acos(v2/v2v));
    }
    //flag=true;
    /***************DEBUG******************/
      ang1t=atan(v1y/v1x);
      ang2t=atan(v2y/v2x);
      //f=ang/PI*180;
      //f1=ang1/PI*180;
      //f2=ang2/PI*180;
      //f1f=ang1t/PI*180;
      //f2f=ang2t/PI*180;
      color(200,200,200);
      strokeWeight(1);
      stroke(244,244,244);
      line(x1,y1,x1+cos(ang)*(r2+r1),y1-sin(ang)*(r2+r1));//fa
      stroke(0,240,0);
      line(x1-cos(ang1)*15,y1+sin(ang1)*15,x1,y1);
      line(x2,y2,x2-cos(ang2)*15,y2+sin(ang2)*15);
      stroke(0,0,240);
      line(x1,y1,x1+cos(ang1t)*15,y1-sin(ang1t)*15);
      line(x2,y2,x2+cos(ang2t)*15,y2-sin(ang2t)*15);
      //println("faxian : ",f," rushe1 ",f1," rushe2 ",f2," chushe1 ",f1f," chushe2 ",f2f);
      //println((f1-f)%180," ",(f1f-f)%180," ",(f2-f)%180," ",(f2f-f)%180);      
      println(m1*(pow(v1x,2)+pow(v1y,2))+m2*(pow(v2x,2)+pow(v2y,2)));
}


float getAngle(float dx,float dy)
{
    if(dy>= 0.00){
        return acos(dx/sqrt(pow(dx,2)+pow(dy,2)));
    }
    else{
        return -acos(dx/sqrt(pow(dx,2)+pow(dy,2))); 
    }
   
}