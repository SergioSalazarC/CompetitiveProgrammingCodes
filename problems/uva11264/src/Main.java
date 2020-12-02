import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int x=in.nextInt();
        for(int y=0;y<x;y++){

            int total = in.nextInt();

            int[] coins = new int[total];
            for(int i=0;i<total;i++){
                coins[i]=in.nextInt();
            }
            if(total==1){
                System.out.println(1);
                continue;
            }

            int s=0;
            int cont=1;

            for(int i=0;i<total-1;i++){
                if(coins[i+1]>s+coins[i]){
                    cont++;
                    s+=coins[i];
                }
            }

            System.out.println(cont);

        }

    }
}
