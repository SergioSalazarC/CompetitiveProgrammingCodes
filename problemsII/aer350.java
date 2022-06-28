import java.util.Scanner;

public class aer350 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double k = in.nextDouble();
        double q = in.nextDouble();
        while(k!=0 && q!=0){
            double m = (k*q)/2;
            System.out.println(m);
            k=in.nextDouble();
            q=in.nextDouble();
        }
    }
}
