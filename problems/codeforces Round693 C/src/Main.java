import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int arr[];
    public static int n;
    public static int[] memo;
    public static  boolean[] mark;

    public static int dp(int i){
        if(i>=n) return 0;
        if(mark[i]) return memo[i];
        int max;
        mark[i]=true;
        max=dp(i+arr[i])+arr[i];
        memo[i]=max;
        return max;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(in.readLine().trim());
        for(int i=0;i<t;i++){
            n=Integer.parseInt(in.readLine());
            StringTokenizer st = new StringTokenizer(in.readLine()," ");
            arr=new int[n];
            memo=new int[n];
            mark=new boolean[n];
            for(int j=0;j<n;j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }
            int max=-1;
            for(int j=0;j<n;j++){
                max=Math.max(max,dp(j));
            }
            System.out.println(max);

        }
    }
}
