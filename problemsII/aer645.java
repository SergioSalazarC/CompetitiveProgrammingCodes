import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class aer645 {

    public static class Par implements Comparable{
        int nodo;
        int dist;


        public Par(int nodo, int dist) {
            this.nodo = nodo;
            this.dist = dist;
        }

        @Override
        public int compareTo(Object o) {
            Par i = (Par)o;
            return this.dist-i.dist;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int nodos = in.nextInt();
            int ars = in.nextInt();
            ArrayList<Par>[] grafo = new ArrayList[nodos];
            for (int i = 0; i < nodos; i++) {
                grafo[i]=new ArrayList<>();
            }
            for (int i = 0; i < ars; i++) {
                int a =in.nextInt()-1;
                int b = in.nextInt()-1;
                int cost=in.nextInt();
                grafo[a].add(new Par(b,cost));
                grafo[b].add(new Par(a,cost));
            }

            PriorityQueue<Par> pq = new PriorityQueue<>();

            boolean[] visitado= new boolean[nodos];
            visitado[0]=true;
            for (Par x: grafo[0]) {
                pq.add(x);
            }
            int coste=0;
            int cant=1;
            while (!pq.isEmpty()){
                Par top=pq.remove();
                if(!visitado[top.nodo]){
                    visitado[top.nodo]=true;
                    cant++;
                    coste+=top.dist;
                    for (Par x: grafo[top.nodo]) {
                        pq.add(x);
                    }
                }
            }

            if(cant<nodos){
                System.out.println("No hay puentes suficientes");
            }
            else{
                System.out.println(coste);
            }
        }
    }
}