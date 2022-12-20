import java.util.Scanner;

public class aer112 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int d, v, t;
        while (sc.hasNextInt()) {
            d = sc.nextInt();
            v = sc.nextInt();
            t = sc.nextInt();

            if (d == 0 && v == 0 && t == 0) {
                break;
            }

            if (d <= 0 || v <= 0 || t <= 0) {
                System.out.println("ERROR");
                continue;
            }

            if (18 * d <= 5 * t * v) {
                System.out.println("OK");
            } else if (3 * d < t * v) {
                System.out.println("MULTA");
            } else {
                System.out.println("PUNTOS");
            }
        }
    }
}
