import java.util.Scanner;

public class aer638 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        while(n-->0){
            int a=in.nextInt();
            int b = in.nextInt();
            int quedan = a-1;
            if(b%quedan==0){
                int aux = b/quedan;
                int sol= b+aux;
                int sool=sol-1;
                if(sool<0) sool=0;
                if(sol<0) sol=0;
                System.out.println(sool+" "+sol);
            }
            else{
                int aux = b/quedan;
                int sol= b+aux;
                if(sol<0)sol=0;
                System.out.println(sol+" "+sol);
            }
        }
    }
}
