import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class aer573 {
    static int INF = 1000000000;
    static int est;
    static int[][] estados;
    static int[][] memo;
    static boolean[]pasar;

    static int dp(int estado, int delegados, int objetivo){
        if(delegados>=objetivo) return 0;
        if(estado>=est) return INF;
        if(memo[estado][delegados]!=-1) return memo[estado][delegados];
        if(pasar[estado]){
            int pasar = dp(estado+1,delegados,objetivo);
            memo[estado][delegados]=pasar;
            return memo[estado][delegados];
        }
        else{
            int coger = estados[estado][1]+dp(estado+1,delegados+estados[estado][0],objetivo);
            int pasar = dp(estado+1,delegados,objetivo);
            memo[estado][delegados]=Math.min(coger,pasar);
            return memo[estado][delegados];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String k=in.readLine();

        while(k!=null){
            memo=new int[105][5005];
            for(int i=0;i<105;i++) Arrays.fill(memo[i],-1);
            est = Integer.parseInt(k);
            pasar = new boolean[est];
            //0-> Aporte del estado 1->Coste del estado
            estados = new int[est][2];
            int votantes=0;
            int ganados=0;
            int perdidos=0;
            for(int i=0;i<est;i++){
                StringTokenizer st = new StringTokenizer(in.readLine()," ");
                int value=Integer.parseInt(st.nextToken());
                votantes+=value;
                int donal=Integer.parseInt(st.nextToken());
                int contr=Integer.parseInt(st.nextToken());
                int indec=Integer.parseInt(st.nextToken());
                //donal+a=contr+indec-a+1
                //a=(contr+indec-donal+1)/2
                int a=(contr+indec-donal+1)/2;
                if((contr+indec-donal+1)%2==1)a++;
                if(a>indec){
                    pasar[i]=true;
                    perdidos=value;
                }
                else if(a<=0){
                    pasar[i]=true;
                    ganados=value;
                }
                else{
                    estados[i][0]=value;
                    estados[i][1]=(a<0 ? 0 : a);
                }
            }
            int a=(perdidos+(votantes-perdidos-ganados)-ganados+1)/2;
            if((perdidos+(votantes-perdidos-ganados)-ganados+1)%2==1)a++;
            int max=dp(0,0,a);
            if(max>=INF) System.out.println("IMPOSIBLE");
            else System.out.println(max);
            k=in.readLine();
        }
    }
}
