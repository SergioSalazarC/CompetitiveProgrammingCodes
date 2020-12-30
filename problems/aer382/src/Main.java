import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n= in.nextInt();
        for(int i=0;i<n;i++){
            int longitud=in.nextInt();
            int antenas=in.nextInt();

            ArrayList<IntPair> carr = new ArrayList();
            for(int j=0;j<antenas;j++){
                int a = in.nextInt();
                int b = in.nextInt();
                carr.add(new IntPair(a-b,a+b));
            }

            Collections.sort(carr);
            int estado=0;
            boolean salida=true;
            while(estado<longitud && !carr.isEmpty()){
                IntPair aux = carr.get(0);
                if(aux.a>estado){
                    salida=false;
                    break;
                }
                else if(aux.a<=estado && aux.b>estado){
                    carr.remove(0);
                    estado=aux.b;
                }else if(aux.a<=estado && aux.b<=estado){
                    carr.remove(0);
                }
            }
            if(estado<longitud) salida=false;

            if(salida) System.out.println("SI");
            else System.out.println("NO");
        }

    }

    public static class IntPair implements Comparable{
        int a;
        int b;

        public IntPair( int x, int y){
            a=x;
            b=y;
        }

        @Override
        public int compareTo(Object o) {
            return (this.a-((IntPair) o).a);
        }
    }
}
