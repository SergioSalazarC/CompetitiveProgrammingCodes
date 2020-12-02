import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static boolean rec(ArrayList<Integer> lista, int valor){
        if(valor==0) return true;
        if(valor<0) return false;
        if(lista.size()==1){
            if(valor-lista.get(0)==0) return true;
            else return false;
        }
        boolean salida = false;
        for(int i=0;i<lista.size()-1 && !salida;i++){
            ArrayList<Integer> aux = new ArrayList<>(lista.subList(i+1,lista.size()));
            int escogido = lista.get(i);
            salida=salida || rec(aux,valor-escogido);
        }
        return(salida);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(in.readLine());
        for(int i=0;i<cases;i++){
            int distance = Integer.parseInt(in.readLine());
            int bars = Integer.parseInt(in.readLine());
            ArrayList<Integer> sizes = new ArrayList<>();
            String auxsize = in.readLine();
            StringTokenizer token = new StringTokenizer(auxsize," ");
            for(int a=0;a<bars;a++){
                sizes.add(Integer.parseInt(token.nextToken()));
            }
            if(rec(sizes,distance)) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
