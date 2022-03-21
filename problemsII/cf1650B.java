import java.util.Scanner;

public class cf1650B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        while(n-->0){
            long i= in.nextLong();
            long j=in.nextLong();
            long a=in.nextLong();

            long sol1 = j/a+j%a;

            long jaux=j-(j%a)-1;
            long sol2=-1;
            if(jaux>=i){
                sol2=jaux/a+jaux%a;
            }
            System.out.println(Math.max(sol1,sol2));
        }
    }
}
