import java.util.Scanner;

public class aer602 {
    public static long[] fib = new long[47];
    public static boolean[] check = new boolean[47];

    public static long fib(int n){

        if(check[n]) return fib[n];
        check[n]=true;
        long m=fib(n-1)+2*fib(n-2);
        fib[n]=m;
        return m;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        check[1]=true;
        check[2]=true;
        fib[1]=1;
        fib[2]=1;
        fib(46);

        int n=in.nextInt();
        for(int i=0;i<n;i++){
            int k = in.nextInt();
            int dia=0;
            long acum=0;
            while(acum<k){
                dia++;
                acum+=fib[dia];
            }
            System.out.println(dia);
        }

    }
}