import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static int INF=100000000;

    public static char[] a;
    public static char[] b;
    public static int sizea;
    public static int sizeb;
    public static int[][] grid;
    public static boolean[][] mark;


    public static int dp(int punta, int puntb){
        if(punta >= sizea && puntb >= sizeb) return 0;
        if(punta>=sizea && puntb < sizeb ) return sizeb-puntb;
        if(punta<sizea && puntb>=sizeb) return sizea-punta;
        if (mark[punta][puntb]){
            return grid[punta][puntb];
        }
        int best;
        mark[punta][puntb]=true;
        if(a[punta]==b[puntb]){
            best=dp(punta+1,puntb+1);
        }
        else{
            int t1=dp(punta,puntb+1)+1;
            int t2=dp(punta+1,puntb)+1;
            int t3=dp(punta+1,puntb+1)+1;
            best = Math.min(t1,Math.min(t2,t3));
        }
        grid[punta][puntb]=best;
        return best;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine().trim());
        for(int i=0;i<t;i++){
            a = in.readLine().toCharArray();
            b = in.readLine().toCharArray();
            mark= new boolean[2100][2100];
            grid= new int[2100][2100];
            sizea = a.length;
            sizeb = b.length;
            System.out.println(dp(0,0));
        }
    }
}
