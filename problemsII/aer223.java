import java.util.Scanner;

public class aer223 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int casos=in.nextInt();
        while (casos-- > 0) {
            int n = in.nextInt();
            int inicio=-1;
            int fin =-1;
            int maximo=-1;
            int auxi=0;
            for(int i=0;i<n;i++){
                int k = in.nextInt();
                if(k==0){
                    if(i-auxi>maximo){
                        inicio=auxi;
                        fin=i-1;
                        maximo=i-auxi;
                    }
                    auxi=i+1;
                }
                if(i==n-1){
                    if(i-auxi+1>maximo){
                        inicio=auxi;
                        fin=i;
                        maximo=i-auxi+1;
                    }
                }
            }
            if(maximo<=0) System.out.println("SIGUE BUSCANDO");
            else System.out.println(maximo + " -> ["+inicio+","+fin+"]");
        }


    }
}
