import java.util.Scanner;

public class Main {

    static boolean pico(int ant, int act, int pos)
    {
        return ((ant < act) && (act > pos));
    }

    public static void main(String[] args) {
        Scanner in = new
                Scanner(System.in);
        int y = in.nextInt();
        while(y != 0) {
            int cont = 0;
            int[] longitudes = new int[1001];
            for (int x = 0; x < y; x++) {
                longitudes[x] = in.nextInt();
            }
            for (int z = 0; z < y; z++) {
                int a = (z-1)%y;
                int c = (z+1)%y;
                if(a<0){
                    a=a+y;
                }
                if(c<0){
                    c=c+y;
                }
                boolean p = pico(longitudes[a], longitudes[z], longitudes[c]);
                if (p) {
                    cont = cont + 1;
                }
            }
            System.out.println(cont);
            y = in.nextInt();
        }
    }
}