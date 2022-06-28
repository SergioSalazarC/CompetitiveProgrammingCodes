import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class aer607 {
    static long[] lista;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        lista=new long[32];
        int casos = Integer.parseInt(in.readLine());
        int k=1;
        for(int i=0;i<32;i++){
            lista[i]=k;
            k*=2;
        }
        while(casos-->0){
            int p = Integer.parseInt(in.readLine());
            if(p==1) System.out.println(0);
            else
            for(int i=0;i<31;i++){
                if(lista[i]<p && lista[i+1]>=p){
                    System.out.println(i+1);
                    break;
                }
            }
        }
    }
}
