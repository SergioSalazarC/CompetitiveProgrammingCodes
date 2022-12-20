import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

import static java.lang.System.in;

public class aer639 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int s = in.nextInt();
            int[] tarta = new int[s];
            long total = 0;
            for (int i = 0; i < s; i++) {
                tarta[i]=in.nextInt();
                total+=tarta[i];
            }

            long t1=tarta[0];
            long t2=tarta[1];
            long t3=total-(t1+t2);
            long best=Math.max(Math.max(t1,t2),t3)-Math.min(Math.min(t1,t2),t3);
            int index=1;
            for (int i = 2; i < s; i++) {
                t3-=tarta[i];
                t2+=tarta[i];
                long bestaux=Math.max(Math.max(t1,t2),t3)-Math.min(Math.min(t1,t2),t3);
                best=Math.min(best,bestaux);

                while(true){
                    long t2aux=t2-tarta[index];
                    long t1aux=t1+tarta[index];
                    if(Math.abs(t2aux-t1aux)<Math.abs(t2-t1)){
                        index++;
                        t2=t2aux;
                        t1=t1aux;
                    }
                    else{
                        break;
                    }
                }
                bestaux=Math.max(Math.max(t1,t2),t3)-Math.min(Math.min(t1,t2),t3);
                best=Math.min(best,bestaux);

            }
            System.out.println(best);

        }
    }
}