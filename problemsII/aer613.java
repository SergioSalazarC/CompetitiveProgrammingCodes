import java.util.Scanner;

public class aer613 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n=in.nextInt();
            int cont = 0;
            int resto = 0;
            while(true){
                resto*=10;
                resto++;
                cont++;
                if(resto%n==0) break;
                else resto = resto%n;
            }
            System.out.println(cont);
        }
    }
}