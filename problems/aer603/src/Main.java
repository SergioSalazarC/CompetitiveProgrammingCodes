import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static int c;
    public static int s;
    public static int[] cortes;
    public static int[][] dp;
    public static boolean[][] memo;

    public static int rec(int si,int sf, int li, int ls){
        if(li==ls) return 0;
        if(si==sf) return 0;
        if(li<0 || ls>c) return 1000000000;
        if(si<0 || sf>s) return 1000000000;
        if (memo[li][ls]) return dp[li][ls];
        memo[li][ls]=true;
        int min=1000000000;
        for(int i=li;i<ls;i++){
            min=Math.min(min,2*(sf-si)+rec(si,cortes[i],li,i)+rec(cortes[i],sf,i+1,ls));
        }
        dp[li][ls]=min;
        return min;
    }



    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine()," ");
        s=Integer.parseInt(st.nextToken());
        c=Integer.parseInt(st.nextToken());
        while(s!=0 && c!=0){
            st = new StringTokenizer(in.readLine()," ");
            dp=new int[c+5][c+5];
            memo=new boolean[c+5][c+5];
            cortes = new int[c];
            for(int i=0;i<c;i++){
                cortes[i]=Integer.parseInt(st.nextToken());
            }
            sb.append(rec(0,s,0,c)+"\n");
            st = new StringTokenizer(in.readLine()," ");
            s=Integer.parseInt(st.nextToken());
            c=Integer.parseInt(st.nextToken());
        }
        System.out.print(sb);
    }
}
