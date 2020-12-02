import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int ammount = in.nextInt();
        while(ammount !=0){
            int[] bags = new int[ammount];
            for(int i=0;i<ammount;i++){
                bags[i]=in.nextInt();
            }
            Arrays.sort(bags);
            int max=1;
            int cont=1;
            int aux=0;
            for(int i=0;i<ammount;i++){
                if (aux==bags[i]){
                    cont++;
                }else{
                    max=Math.max(max,cont);
                    cont=1;
                    aux=bags[i];
                }
                if(i==ammount-1){
                    max=Math.max(max,cont);
                }
            }

            ArrayList<Integer>[] mu = new ArrayList[max];
            for(int i=0;i<max;i++){
                mu[i] = new ArrayList<>();
            }
            for(int i=0;i<ammount;i++){
                mu[i%max].add(bags[i]);
            }

            System.out.println(max);
            for(int i=0;i<max;i++){
                for(int j=0;j<mu[i].size();j++){
                    if(j!=mu[i].size()-1){
                        System.out.print(mu[i].get(j)+" ");
                    }
                    else{
                        System.out.print(mu[i].get(j));
                    }
                }
                System.out.println();
            }
            System.out.println();

            ammount=in.nextInt();


        }
    }
}
