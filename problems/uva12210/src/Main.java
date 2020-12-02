import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String inp = in.readLine();
        StringTokenizer tok= new StringTokenizer(inp," ");
        int b = Integer.parseInt(tok.nextToken());
        int s = Integer.parseInt(tok.nextToken());
        int contador=1;
        while(b!=0 && s!=0){
            if (b<=s){
                for(int i=0;i<b+s;i++){
                    in.readLine();
                }
                System.out.println("Case "+contador+": 0");
                contador++;
            }else{
                int min=2000000000;
                for(int i=0;i<b;i++){
                    int x=Integer.parseInt(in.readLine());
                    min=Math.min(min,x);
                }
                int aux=b-s;
                System.out.println("Case "+contador+": "+aux+" "+min);
                contador++;

                for(int i=0;i<s;i++){
                    in.readLine();
                }
            }

            inp = in.readLine();
            tok= new StringTokenizer(inp," ");
            b = Integer.parseInt(tok.nextToken());
            s = Integer.parseInt(tok.nextToken());

        }

    }
}
