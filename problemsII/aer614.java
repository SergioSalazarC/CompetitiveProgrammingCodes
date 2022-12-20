import java.util.Scanner;

public class aer614 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        int psa=in.nextInt();
        while(n!=0 && psa!=0){
            long[] anden = new long[psa];
            long[] acum = new long[psa];
            long aux=0;
            for(int i=0;i<psa;i++){
                long k = in.nextInt();
                anden[i]=k;
                aux+=k;
                acum[i]=aux;
            }
            int cola=0;
            int cabeza=n;
            long valor=0;
            for(int i=psa-1;i>=n;i--){
                valor+=anden[i]*(i-n+1);
            }
            long min=valor;
            while(cabeza<psa){
                cola++;
                cabeza++;
                valor+=acum[cola-1];
                valor-=(acum[psa-1]-acum[cabeza-2]);
                min= Math.min(valor,min);
            }

            System.out.println(min);
            n=in.nextInt();
            psa=in.nextInt();
        }
    }
}