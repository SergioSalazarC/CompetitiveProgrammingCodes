import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class aer642 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();
            int[] grafo = new int[n];
            for (int i = 0; i < n; i++) {
                grafo[i]=in.nextInt()-1;
            }

            int[] visitados = new int[n];
            int ciclos = 0;
            int index = 1;
            for (int i = 0; i < n; i++) {
                index++;
                if(visitados[i]!=0) continue;
                Queue<Integer> cola = new LinkedList<>();
                cola.add(i);
                while(!cola.isEmpty()){
                    Integer k = cola.remove();
                    if(visitados[k]==0){
                        visitados[k]=index;
                        cola.add(grafo[k]);
                    }
                    else{
                        if(visitados[k]==index) ciclos++;
                    }
                }

            }
            System.out.println(ciclos);


        }
    }
}
