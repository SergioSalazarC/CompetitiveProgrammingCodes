import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class aer528 {
    public static long func(long k){
        long aux = k*(k-1);
        aux=aux/2;
        return aux;
    }


    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int n =(int) in.nextFloat();
        while(n!=0){
            long ceros=0;
            long g1=0;
            long l1=0;
            long unos=0;
            for(int i=0;i<n;i++){
                float aux = in.nextFloat();
                if(aux==0) ceros++;
                else if(aux==1) unos++;
                else if (aux>1) g1++;
                else l1++;
            }
            long a=func(g1);
            long b=func(l1);
            long c=func(unos);
            long d=func(ceros);
            long e=unos*l1;
            long f=unos*g1;
            long g=ceros*l1;
            long h=ceros*g1;
            long i=unos*ceros;

            long aux = a+b+c+d+e+f+g+h+i;
            System.out.println(aux);
            n=in.nextInt();

        }


    }
}