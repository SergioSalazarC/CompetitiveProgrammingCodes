import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int i =in.nextInt();
        for(int j=0;j<i;j++){
            int p=in.nextInt();
            int aux=p/100;
            System.out.println(aux);
        }
    }
}
