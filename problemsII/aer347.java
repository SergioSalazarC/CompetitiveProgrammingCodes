
import java.util.Scanner;

public class aer347 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int ancho = in.nextInt();
        int largo = in.nextInt();

        while(ancho!=0 || largo!=0){

            int sol = 0;
            while(ancho>=10 && largo>=10){
                int max = Math.max(ancho,largo);
                int min = Math.min(ancho,largo);

                int podre = max/min;

                if(ancho>largo){
                    ancho-=podre*largo;
                    sol+=podre;
                }
                else{
                    largo-=podre*ancho;
                    sol+=podre;
                }
            }

            System.out.println(sol);
            ancho = in.nextInt();
            largo = in.nextInt();

        }
    }
}
