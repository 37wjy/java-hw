//Jianyu_Wang_HW1e
void setup(){
  double sum1=0,sum2=0;
  for(int i=1;i<=100;i++){
    sum1+=1/(double)i;
    sum2+=1/(double)(101-i);
  }
  println(sum1);
  println(sum2);
  println("difference :",sum1-sum2);
  exit();
}