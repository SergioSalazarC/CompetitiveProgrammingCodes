import java.util.Scanner;

public class Main {
    public static int mcd(int a, int b){ return(b==0 ? a: mcd(b,a%b)); }
    public static int mcm(int a, int b){ return(a*b/mcd(a,b)); }
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int n=in.nextInt();
        while(n!=0){
            int b=1;
            for(int i=0;i<n;i++){
                b=mcm(in.nextInt(),b);
            }
            System.out.println(b);
            n=in.nextInt();
        }
    }
}