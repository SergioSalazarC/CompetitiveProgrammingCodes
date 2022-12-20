import java.util.Scanner;

public class aer538 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n  = in.nextInt();
        int m = in.nextInt();
        while(n!=0 || m!=0){
            if(n<m) System.out.println("SENIL");
            else System.out.println("CUERDO");
            n  = in.nextInt();
            m = in.nextInt();
        }
    }
}
