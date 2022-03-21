import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class cf4C {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        HashMap<String,Integer> mapa;
        mapa = new HashMap<>();
        while(n-->0){
            String aux = in.next();
            if(mapa.containsKey(aux)){
                int k = mapa.get(aux);
                mapa.put(aux,k+1);
                System.out.println(aux+""+k);
            }
            else{
                mapa.put(aux,1);
                System.out.println("OK");
            }

        }
    }
}
