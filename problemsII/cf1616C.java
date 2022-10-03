import java.util.Scanner;

public class cf1616C {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int casos = in.nextInt();
        while(casos-->0){
            int n = in.nextInt();
            double[] mem = new double[n];
            for (int i = 0; i < n; i++) {
                mem[i]=in.nextInt();
            }
            int max =-1;
            if(n==1 || n==2) System.out.println(0);
            else{
                for (int i = 0; i < n-1; i++) {
                    for (int j = i+1; j < n; j++) {
                        double a =i;
                        double b=j;
                        double k = (mem[j]-mem[i])/(b-a);
                        double base = mem[i]-i*k;
                        int cont=0;
                        for (int l = 0; l < n; l++) {
                            double aux = base+l*k-mem[l];
                            if(Math.abs(aux)<1e-9) cont++;
                        }
                        max=Math.max(cont,max);
                    }
                }
                System.out.println(n-max);
            }

        }
    }
}
