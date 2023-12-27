import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class cf1833E {

    static boolean[] check;
    static boolean[] ciclo;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        while (n-->0){
            int t = in.nextInt();
            check = new boolean[t];
            ciclo = new boolean[t];
            int ciclos = 0;
            int cc = 0;
            int[] grafo = new int[t];

            for (int i = 0; i < t; i++) {
                grafo[i]=(in.nextInt()-1);
            }

            for (int i = 0; i < t; i++) {
                if(check[i])continue;
                HashSet<Integer> visitados = new HashSet<>();
                visitados.add(i);
                cc++;
                LinkedList<Integer> cola = new LinkedList<>();
                cola.addLast(i);
                while(!cola.isEmpty()){
                    int k = cola.removeFirst();
                    if(check[k]==true){
                        if (!visitados.contains(k)) cc--;
                        if(visitados.contains(k) && grafo[grafo[k]]!=k) ciclos++;
                        break;
                    }
                    else{
                        check[k]=true;
                        cola.addLast(grafo[k]);
                    }
                    visitados.add(k);
                }
            }

            int max = cc;
            int min = ciclos;
            if(cc!=ciclos) min++;

            System.out.println(min +" "+max);



        }



    }
}
