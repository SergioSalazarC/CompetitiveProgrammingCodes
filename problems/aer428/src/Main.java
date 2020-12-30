import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static String convertir(String numero, int baseOrigen, int baseDestino) {
        int numeroBase10 = Integer.parseInt(numero, baseOrigen);
        String numeroBaseB = Integer.toString(numeroBase10, baseDestino);
        return numeroBaseB;
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int a=in.nextInt();
        for(int i=0;i<a;i++){
            String auxx=String.valueOf(in.nextInt());
            String m = convertir(auxx,10,5);
            int aux=0;
            for(int j=0;j<m.length();j++){
                if(m.charAt(j)=='4'){
                    aux++;
                }
                if(aux>1){
                    break;
                }
            }
            if(aux>1) System.out.println("SI");
            else System.out.println("NO");

        }
    }
}
