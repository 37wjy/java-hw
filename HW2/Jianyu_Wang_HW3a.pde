int step=75;

void setup(){
    int x=0,y=75;
    int x1=75,y1=0;
    size(900,900);
    background(0,0,0);
    do{
        do{
            stroke((y)*255.0/height,(x1+y)*100.0/height+100,(x1)*255.0/width);
            strokeWeight(1);
            line(x,y,x1,y1);
            x1+=step;
        }while(x1<=width);
        y+=75;
        x1=75;
    }while(y<=height);
   
}