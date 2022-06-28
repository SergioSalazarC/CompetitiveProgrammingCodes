import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class cf1542B {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int casos = Integer.parseInt(in.readLine());
        for(int i=0;i<casos;i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            long n = Integer.parseInt(st.nextToken());
            long a = Integer.parseInt(st.nextToken());
            long b = Integer.parseInt(st.nextToken());
            if(a==1){
                if((n-1) % b==0) System.out.println("Yes");
                else System.out.println("No");
            }
            else{
                long aux=1;
                boolean correcto=false;
                while(aux<=n){
                    if(aux%b==n%b){
                        correcto=true;
                        break;
                    }
                    aux=aux*a;
                }
                if(correcto) System.out.println("Yes");
                else System.out.println("No");
            }
        }
    }
}
