import java.util.Scanner;

public class cf1360D {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        while(n-->0){
            int s = in.nextInt();
            int k = in.nextInt();
            int sol=s;
            for(int i=1;i*i<=s;i++){
                if(s%i==0){
                    if(i<=k){
                        sol=Math.min(sol,s/i);
                    }
                    if(s/i<=k){
                        sol=Math.min(sol,i);
                    }
                }
            }
            System.out.println(sol);
        }
    }
}
