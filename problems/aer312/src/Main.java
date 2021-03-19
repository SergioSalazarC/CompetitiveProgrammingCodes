import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static long mcd(long a, long b){
        if(b==0) return (a);
        else return (mcd(b, a%b));
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        long m = in.nextLong();
        while(m!=0){
            long total=m;
            long sig=m;
            while(sig!=0){
                sig = in.nextLong();
                m = mcd(m,sig);
                total+=sig;
            }

            long fin = total/m;
            System.out.println(fin);

            m= in.nextLong();

        }




    }
}