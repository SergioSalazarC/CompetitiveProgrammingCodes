import java.util.Scanner;

public class aer269 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t-->0){
            long s = in.nextInt();
            long anterior = 0;
            long acumulado = 0;
            while(s!=0){
                anterior += s;
                acumulado+= 2*anterior;
                s=in.nextInt();
            }
            System.out.println(acumulado);
        }

    }
}
