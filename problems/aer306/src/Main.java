import java.util.Scanner;

public class Main {
    public static void mul(long[][] a, long[][] b){
        long x=(a[0][0]*b[0][0]+a[0][1]*b[1][0])%46337;
        long y=(a[0][0]*b[0][1]+a[0][1]*b[1][1])%46337;
        long z=(a[1][0]*b[0][0]+a[1][1]*b[1][0])%46337;
        long t=(a[1][0]*b[0][1]+a[1][1]*b[1][1])%46337;

        a[0][0]=x;
        a[0][1]=y;
        a[1][0]=z;
        a[1][1]=t;
    }

    public static void elev(long[][] a,long[][] b, long x){
        if(x>1){
            elev(a,b,x/2);
            mul(a,a);

            if(x%2==1){
                mul(a,b);
            }
        }

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        while(x!=0){
            if (x==1||x==2){
                System.out.println(1);
            }else{
                long[][] a = new long[2][2];
                long[][] b = new long[2][2];
                a[0][1]=1;
                a[1][0]=1;
                a[1][1]=1;
                b[0][1]=1;
                b[1][0]=1;
                b[1][1]=1;
                int aux=x;
                elev(a,b,aux-1);
                System.out.println(a[1][1]);
            }
            x=in.nextInt();


        }
    }
}
