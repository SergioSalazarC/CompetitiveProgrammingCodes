import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int h = in.nextInt()*100;
        while(h!=0){
            double u = in.nextInt()*100;
            int d = in.nextInt()*100;
            int f = in.nextInt();
            double baja = u*f/100;
            int cont = 0;
            boolean conseguido = false;

            int dist=0;

            while(true){
                dist += u;
                cont++;
                if (dist>h){
                    conseguido=true;
                    break;
                }
                if(u-baja<0) u=0;
                else u = u-baja;
                dist -= d;
                if(dist<0){
                    break;
                }

            }

            if(conseguido) System.out.println("success on day "+cont);
            else System.out.println("failure on day "+cont);

            h = in.nextInt()*100;

        }
    }
}
