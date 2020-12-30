import java.util.Scanner;
public class Main {
    public static long[] memo;
    public static boolean[] mark;
    public static long dp(int coin){
        if(coin==0) return 0;
        if(coin >1000000000) return 0;
        if(coin<=1000000 && mark[coin]==true) return memo[coin];
        long max = Math.max(coin,dp(coin/2)+dp(coin/3)+dp(coin/4));
        if(coin<1000000){
            mark[coin]=true;
            memo[coin]=max;
        }
        return max;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        mark = new boolean[1000001];
        memo= new long[1000001];
        while(in.hasNextInt()){
            int a=in.nextInt();
            System.out.println(dp(a));
        }
    }
}