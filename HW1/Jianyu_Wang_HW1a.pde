//jianyu wang hw1a
void setup(){
    size(600, 400);
}

int x=10,y=10,r=20;
int flag=0;
int speed=10;

void draw(){
    background(0,0,0);
    fill(100+(x/9),100+(y/15),0);
    circle(x,y,r);
    switch (flag) {
        case 0 :
            x+=speed;if(x>=600-r)flag=1;
        break;
        case 1 :
            y+=speed;if(y>=400-r)flag=2;
        break;    
        case 2 :
            x-=speed;if(x<=r)flag=3;
        break;
        case 3 :
            y-=speed;if(y<=r)flag=0;
        break;  
    }

}
