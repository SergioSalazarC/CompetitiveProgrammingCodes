import java.util.Scanner;

public class aer615 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int casos = in.nextInt();
        while(casos-->0){
            int pasos=in.nextInt();
            int factor=in.nextInt();
            int tiempo=in.nextInt();

            int aux=tiempo%(pasos+1);
            System.out.println(factor*aux);
        }
    }
}