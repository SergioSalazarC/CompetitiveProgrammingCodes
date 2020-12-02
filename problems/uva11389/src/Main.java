import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int drivers = in.nextInt();
        int cota = in.nextInt();
        int multa = in.nextInt();
        while(drivers!=0 && cota!=0 && multa != 0){
            int sum=0;
            int[] rutas = new int[drivers];
            int[] rutas2 = new int[drivers];
            for(int i=0;i<drivers;i++){
                rutas[i]=in.nextInt();
            }
            for(int i=0;i<drivers;i++){
                rutas2[i]=in.nextInt();
            }

            Arrays.sort(rutas);
            Arrays.sort(rutas2);

            int[] aux = new int[drivers];
            for(int i=0;i<drivers;i++){
                aux[i]+=rutas[i]+rutas2[drivers-1-i];
            }
            for(int i=0;i<drivers;i++){
                if(aux[i]>cota){
                    sum+=(aux[i]-cota)*multa;
                }
            }

            System.out.println(sum);

            drivers = in.nextInt();
            cota = in.nextInt();
            multa = in.nextInt();
        }
    }
}
