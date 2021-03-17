import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int x = in.nextInt();

        while (x != 0) {
            if (x%2==0){
                System.out.println("DERECHA");
            }else{
                System.out.println("IZQUIERDA");
            }
            x=in.nextInt();

        }
    }
}