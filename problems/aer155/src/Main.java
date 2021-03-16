import java.util.Scanner;

public class Main2 {
    public static void main(String[] Args) {
        Scanner in = new Scanner(System.in);
        int a= in.nextInt();
        int b=in.nextInt();
        while(a>=0 && b>=0){
            int k=2*a+2*b;
            System.out.println(k);
            a=in.nextInt();
            b=in.nextInt();
        }

    }
}