import java.util.HashMap;
import java.util.Scanner;

public class aer674 {

    public static long ceros(long x){
        long sol=0;
        while(x>0){
            x/=5;
            sol+=x;
        }

        return sol;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long d = in.nextLong();
        long n = in.nextLong();

        while(!(n==0 && d==0)){
            long low = 1;
            long gigh= (long) (1E14+1);

            long fond;

            while(low<gigh){
                long mid = (gigh+low)/2;
                long cmid = ceros(mid);
                if(cmid>=n){
                    gigh =mid;
                }
                else{
                    low=mid+1;
                }
            }
            fond=low;

            boolean max = false;

            while(fond%d!=0 && ceros(fond)==n && fond<Long.MAX_VALUE){
                fond++;
                if(fond==Long.MAX_VALUE-1) max=true;
            }

            if(max){
                if(Long.MAX_VALUE%d==0) fond=Long.MAX_VALUE;
            }


            if(ceros(fond)!=n) System.out.println("NINGUNO");
            else System.out.println(fond);
            d = in.nextLong();
            n = in.nextLong();
        }

    }
}
