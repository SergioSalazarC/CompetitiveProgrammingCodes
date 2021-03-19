import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new
                Scanner(System.in);
        int x = in.nextInt();
        for (int y=1;y<=x;y++){
            int m = in.nextInt();
            String k = in.next();
            int n = in.nextInt();
            if (m<n){
                System.out.println("MAL");
                }
            else{
                System.out.println("BIEN");
            }
        }
    }
}