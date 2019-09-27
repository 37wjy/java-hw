import java.math.BigInteger;

void setup() {
    int y=20;
    for(int i=0;i<=30;i+=3)print(fact(i),",");    //不够长
    println();
    for(int i=0;i<=30;i+=3)print(fact2(i),",");
    println();
    fibo(y);
    println();
    int[] x=new int[y];
    fibo2(y-1,x);
    exit();
}

BigInteger fact2(int n){
    if(n==0){
        return BigInteger.valueOf(0);
    }
    if (n<=1&&n>=-1) {
        return BigInteger.valueOf(n);        
    }
    if(n>0)return fact2(n-1).multiply(BigInteger.valueOf(n));
    else return fact2(n+1).multiply(BigInteger.valueOf(0));
}

BigInteger fact(int n){
    if(n==0)return BigInteger.valueOf(0);
    BigInteger r=new BigInteger("1");
    for(int i=1;i<=n;i++){
        r=r.multiply(BigInteger.valueOf(i));
    }
    return r;
}

void fibo(int n){
    if(n==1)print(1);
    if(n==2)print(1,",",1);
    else{
        print(1,",",1,",");
        int[] a=new int[3];
        a[0]=1;
        a[1]=1;
        for(int i=0;i<n-2;i++){
            a[(i+2)%3]=a[(i+1)%3]+a[i%3];
            print(a[(i+2)%3],",");
        }
    }
}

int fibo2(int n,int[] m){
    if(n==0){m[n]=1;return 1;}
    if(n==1){m[n]=1;print(1,",");return 1;}
    if(m[n]>0)return m[n];
    m[n]=fibo2(n-2,m)+fibo2(n-1,m);
    print(m[n],",");
    return m[n];
}

