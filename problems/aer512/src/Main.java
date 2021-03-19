import java.util.Scanner;
public class Principal {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n= in.nextInt();
        for(int i=0;i<n;i++){
            int conejo=in.nextInt();
            int total=conejo+in.nextInt();
            double aux =conejo*100/total;

            System.out.println((int)Math.floor(aux));

        }

    }
}