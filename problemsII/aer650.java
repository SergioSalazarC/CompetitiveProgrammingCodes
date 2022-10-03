import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class aer650 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while(in.hasNext()){
            int n = in.nextInt();
            LinkedList<Integer> lista = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                lista.add(in.nextInt());
            }
            Collections.sort(lista,Collections.reverseOrder());
            long dc=0;
            while(!lista.isEmpty()){
                int a = lista.remove(0);
                if(lista.isEmpty())break;
                int b = lista.remove(0);
                if(lista.isEmpty())break;
                int c = lista.remove(0);
                dc+=c;
            }
            System.out.println(dc);

        }
    }
}
