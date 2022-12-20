import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class aer316 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        StringBuilder sb = new StringBuilder();
        while(n-->0){
            int t = Integer.parseInt(in.readLine());
            int val = 0;
            int maxval = 0;
            int maxin=-1;
            int maxf=-1;
            int ini = 1;
            int fini = 0;
            StringTokenizer st = new StringTokenizer(in.readLine());
            for (int i = 1; i <= t; i++) {
                int next = Integer.parseInt(st.nextToken());
                if(next>0){
                    if(val==0){
                        ini=i;
                        fini=i-1;
                    }
                    val+=next;
                    fini++;
                    if(val>maxval || (val==maxval && (maxf-maxin)>fini-ini)){
                        maxval=val;
                        maxin=ini;
                        maxf=fini;
                    }
                }
                else{
                    if(Math.abs(next)>val){
                        //Nos quedariamos en negativo
                        if(val>maxval){
                            maxin=ini;
                            maxf=fini;
                        }
                        val=0;
                        ini=i+1;
                        fini=i+1;
                    }
                    else{
                        //Podemos querer este dia
                        if(val>maxval || (val==maxval && (maxf-maxin)>fini-ini)){
                            maxval=val;
                            maxin=ini;
                            maxf=fini;
                        }
                        val+=next;
                        fini++;
                    }
                }
            }
            sb.append(maxin);
            sb.append(" ");
            sb.append(maxf);
            sb.append("\n");
        }
        System.out.print(sb);
    }
}