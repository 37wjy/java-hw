
int y=20;

int fibo(int n,int[] m){
    if(n==0){m[n]=1;return 1;}
    if(n==1){m[n]=1;print(1,",");return 1;}
    if(m[n]>0)return m[n];
    m[n]=fibo(n-2,m)+fibo(n-1,m);
    print(m[n],",");
    return m[n];
}


void setup(){
    int[] x=new int[y];
    fibo(y-1,x);
    exit();
}