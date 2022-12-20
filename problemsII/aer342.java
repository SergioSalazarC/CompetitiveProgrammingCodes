import java.util.Scanner;

public class aer342 {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int ini=in.nextInt();
        int fini=in.nextInt();
        int n=in.nextInt();
        while(ini!=0 || fini!=0 || n!=0){
            int preg = in.nextInt();
            int pi=ini;
            int pf=fini;
            for(int i=0;i<preg;i++){
                int q = in.nextInt();
                if(q<=n){
                    if(pi<q) pi=q;
                }
                if(q>n){
                    if(pf>=q) pf=q-1;
                }
            }
            if(pi==pf) System.out.println("LO SABE");
            else System.out.println("NO LO SABE");

            ini=in.nextInt();
            fini=in.nextInt();
            n=in.nextInt();
        }
    }
}