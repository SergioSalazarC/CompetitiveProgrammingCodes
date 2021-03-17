import java.util.Scanner;
public class concurso {
    public static void main(String[] args) {
        Scanner in = new
                Scanner(System.in);
        for (int i = in.nextInt(); 1 <= i; i--) {
            String z = in.next();
            int r = 0;
            int cont = 0;
            while (r <= (z.length()-1)) {
                if (z.charAt(r) == '.') {
                    cont = cont + 1;
                    r = r + 3;
                }
                else if (z.charAt(r) == 'X') {
                    r = r + 1;
                }
            }
            System.out.println(cont);

        }
    }
}