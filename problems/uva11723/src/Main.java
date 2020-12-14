import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int r=in.nextInt();
        int n=in.nextInt();
        int i=1;
        while(r!=0||n!=0){
            int letras =r/n;
            if (r%n==0) letras--;
            if(letras>26) System.out.println("Case "+i+": impossible");
            else System.out.println("Case "+i+": "+letras);
            i++;
            r=in.nextInt();
            n=in.nextInt();
        }
    }
}
