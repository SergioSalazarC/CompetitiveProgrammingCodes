import java.util.Random;

public class gen {
    public static void main(String[] args) {
        for (int it = 0; it < 1000; it++) {
            Random r = new Random();

            int lineas = r.nextInt(5)+1;
            int nodos = r.nextInt(10)+2;
            System.out.println(nodos+" "+lineas);

            for (int i = 0; i < lineas; i++) {
                int size = r.nextInt(5)+1;
                int inicio = r.nextInt(nodos)+1;
                System.out.print(inicio+" ");
                for (int j = 0; j < size; j++) {
                    int s = r.nextInt(5)+1;
                    int n = r.nextInt(nodos)+1;
                    System.out.print(s+" ");
                    System.out.print(n+" ");
                }
                System.out.println();
            }
        }


    }
}
