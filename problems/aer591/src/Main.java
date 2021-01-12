
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String kk=in.readLine();
        while(kk!=null){
            int t=Integer.parseInt(kk);
            int anillos =t/2;
            if(t%2==1) anillos++;

            long[] pesos = new long[anillos];
            for(int i=0;i<t;i++){
                StringTokenizer st = new StringTokenizer(in.readLine()," ");
                for(int j=0;j<t;j++){
                    int max=Math.max(i,j);
                    int min=Math.min(i,j);
                    max = -max+(t-1);
                    int aux=Math.min(min,max);
                    pesos[aux]+= Long.parseLong(st.nextToken());

                }
            }
            StringBuilder sb = new StringBuilder();
            for(int i=anillos-1;i>=0;i--){
                sb.append(pesos[i]);
                sb.append(" ");
            }
            System.out.println(sb.toString().trim());
            kk=in.readLine();
        }
    }
}
