import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class aer648 {
    static Integer[] diana;
    static int INF = 1000000000;

    static int[][] memo;
    static StringBuilder sol;

    public static int dp(int objetivo, int indice){
        int n = diana.length;
        if(objetivo==0) return 0;
        if(objetivo<0) return INF;
        if(indice>=n) return INF;
        if(memo[objetivo][indice]!=0) return memo[objetivo][indice];
        int a = dp(objetivo-diana[indice],indice)+1;
        int b = dp(objetivo,indice+1);
        memo[objetivo][indice]=Math.min(a,b);
        return Math.min(a,b);

    }

    public static void print_DP(int objetivo, int indice){
        if(objetivo==0 || objetivo<0 || indice>=diana.length) return;
        int aux = dp(objetivo-diana[indice],indice)+1;
        if(aux ==memo[objetivo][indice]){
            sol.append(diana[indice]).append(" ");
            print_DP(objetivo-diana[indice],indice);
        }
        else{
            print_DP(objetivo,indice+1);
        }
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            sol = new StringBuilder();

            int obj = in.nextInt();
            int pos = in.nextInt();
            memo = new int[obj+5][pos+2];
            diana = new Integer[pos];
            for (int i = 0; i < pos; i++) {
                diana[i]=in.nextInt();
            }
            Arrays.sort(diana, Collections.reverseOrder());

            int aux = dp(obj,0);
            if(aux!=1000000000){
                print_DP(obj,0);
                System.out.print(aux+": ");
                System.out.println(sol.toString().trim());
            }
            else {
                System.out.println("Imposible");
            }

        }




    }
}
