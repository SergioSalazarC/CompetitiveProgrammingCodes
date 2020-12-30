import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int INF=1000000000;
    private static int a;
    private static int t;
    private static int memo[][][];
    private static boolean mark[][][];
    private static int ob[];
    private static int nb[];
    private static int pb[];
    private static int cantbomb;

    public static int dp(int o, int n, int bombona){
        o=Math.min(o,21);
        n=Math.min(n,79);
        if(o >= t && n>=a) return 0;
        if(bombona>=cantbomb) return INF;
        if(o<30 && n<90){
            if(mark[o][n][bombona]==true)return memo[o][n][bombona];
        }

        int mejor=Math.min(dp(o,n,bombona+1),dp(o+ob[bombona],n+nb[bombona],bombona+1)+pb[bombona]);


        if(o<30 && n<90){
            mark[o][n][bombona]=true;
            memo[o][n][bombona]=mejor;
        }

        return mejor;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(in.readLine().trim());
        for(int i=0;i<n;i++){
            if(i!=0)in.readLine();
            StringTokenizer st = new StringTokenizer(in.readLine()," ");
            memo = new int[30][90][1100];
            mark = new boolean[30][90][1100];
            t=Integer.parseInt(st.nextToken());
            a=Integer.parseInt(st.nextToken());
            cantbomb=Integer.parseInt(in.readLine());
            ob = new int[cantbomb];
            nb = new int[cantbomb];
            pb = new int[cantbomb];
            for(int j=0;j<cantbomb;j++){
                st = new StringTokenizer(in.readLine()," ");
                ob[j]=Integer.parseInt(st.nextToken());
                nb[j]=Integer.parseInt(st.nextToken());
                pb[j]=Integer.parseInt(st.nextToken());
            }
            System.out.println(dp(0,0,0));
        }



    }
}
