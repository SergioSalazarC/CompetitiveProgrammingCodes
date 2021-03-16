import java.util.Scanner;

public class holaMundo {

    public static void main(String[] args) {
   
        Scanner escaner = new Scanner(System.in);
        int x = escaner.nextInt();
        for (int y=1;y<=x;y++){
            System.out.println("Hola mundo.");
        }
    }
    
}