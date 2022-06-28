import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class aer395 {
    static int[][][][] memo;
    static int[][] tableta;

    static int dp(int f1,int f2,int c1,int c2){
        if(memo[f1][f2][c1][c2]!=-1){
            return memo[f1][f2][c1][c2];
        }
        if(f2-f1==1 && c2-c1==1) return 0;
        int k = tableta[f1][c1];
        boolean igual=true;
        for(int i=f1;i<f2 && igual;i++){
            for(int j=c1;j<c2 && igual;j++){
                if(tableta[i][j]!=k) igual=false;
            }
        }
        if (igual){
            memo[f1][f2][c1][c2]=0;
            return 0;
        }


        int val=1000000000;
        if(f2-f1>1){
            for(int i=f1+1;i<f2;i++){
                val = Math.min(val,dp(f1,i,c1,c2)+dp(i,f2,c1,c2));
            }
        }

        if(c2-c1>1){
            for(int i=c1+1;i<c2;i++){
                val = Math.min(val,dp(f1,f2,c1,i)+dp(f1,f2,i,c2));
            }
        }

        memo[f1][f2][c1][c2]=val+1;
        return(val+1);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){

            StringTokenizer st = new StringTokenizer(in.nextLine()," ");
            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());
            memo = new int[x+1][x+1][y+1][y+1];
            for(int i=0;i<x+1;i++){
                for(int j=0;j<x+1;j++){
                    for(int k=0;k<y+1;k++){
                        Arrays.fill(memo[i][j][k],-1);
                    }
                }
            }

            tableta = new int[x][y];
            for(int i=0;i<x;i++){
                String s = in.nextLine();
                for(int j=0;j<y;j++){
                    tableta[i][j]=s.charAt(j);
                }
            }
            int sol = dp(0,x,0,y);
            System.out.println(sol);
        }


    }
}
