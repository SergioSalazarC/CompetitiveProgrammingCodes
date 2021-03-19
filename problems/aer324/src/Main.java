import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static int gcd(int a, int b){
        return(b==0 ? a : gcd(b, a%b));
    }
    public static int lcm(int a, int b){
        return (a*(b/gcd(a,b)));
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        while(s!=0){
            boolean[] visitado = new boolean[s];
            int[] cadena = new int[s];
            for(int i=0;i<s;i++){
                cadena[i]=in.nextInt()-1;
            }
            int mcm =1;

            for(int i=0;i<s;i++){
                int aux=cadena[i];
                int cont=0;
                while(!visitado[i]){
                    cont++;
                    visitado[aux]=true;
                    aux=cadena[aux];
                    if(aux==cadena[i]){
                        mcm = lcm(mcm,cont);
                    }
                }
            }

            System.out.println(mcm);

            s = in.nextInt();


        }
    }
}