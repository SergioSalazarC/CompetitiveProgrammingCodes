import java.io.*;

import java.util.*;




public class Main {

    public static int dp(int[] memo,int x){
        if(x<=0) return 0;

        if(memo[x]!=-1){
            return memo[x];
        }

        if(x==2 || x==1){
            return 1;
        }

        int sol=0;
        if(x<=10&&x>=1){
            sol++;
        }
        for(int i=1;i<=x && i<11;i++){
            sol=(sol+dp(memo,x-1-i))%1000000007;
        }
        memo[x]=sol;
        return sol;



    }


    public static void main(String[] Args) throws IOException {

        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        int[] memo = new int[100001];
        memo[1]=1;
        memo[2]=1;
        memo[0]=0;
        Arrays.fill(memo,-1);
        for(int i=0;i<n;i++){
            int caso = in.nextInt();
            System.out.println(dp(memo,caso));


        }

    }
}