import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class aer601 {

    public static class Par implements Comparable{
        int nodo;
        int distancia;

        public Par(int nodo, int distancia) {
            this.nodo = nodo;
            this.distancia = distancia;
        }

        @Override
        public int compareTo(Object o) {
            Par i = (Par) o;
            return this.distancia-i.distancia;
        }
    }

    public static int dijkstra(int n, ArrayList<Par>[] grafo, int cant, int tiempo_limite){
        int[] distancias = new int[cant+1];
        Arrays.fill(distancias,1000000000);

        PriorityQueue<Par> pq = new PriorityQueue<>();
        pq.add(new Par(n,0));
        distancias[n]=0;

        while(!pq.isEmpty()){
            Par top = pq.remove();
            if (top.distancia > distancias[top.nodo]) continue;
            for (Par aux : grafo[top.nodo]) {
                if (aux.distancia + distancias[top.nodo] < distancias[aux.nodo]) {
                    distancias[aux.nodo] = aux.distancia + distancias[top.nodo];
                    pq.add(new Par(aux.nodo, distancias[aux.nodo]));
                }
            }
        }
        int solucion=0;
        for (int i=1; i<=cant;i++){
            if(i!=n){
                if(distancias[i]<=tiempo_limite)solucion++;
            }
        }
        return solucion;

    }

    /*
    5 5 20 5
    1 2 5
    1 4 10
    2 4 7
    3 4 15
    4 5 10
    3 1 10 2
    2 3 5
    3 2 6
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int nodos = in.nextInt();
            int salida= in.nextInt();
            int tiempo = in.nextInt();
            int aristas = in.nextInt();

            ArrayList<Par>[] grafo = new ArrayList[nodos+1];

            for (int i = 0; i < nodos+1; i++) {
                grafo[i]=new ArrayList<>();
            }
            for (int i = 0; i < aristas; i++) {
                int a = in.nextInt();
                int b= in.nextInt();
                int s = in.nextInt();
                grafo[b].add(new Par(a,s));
            }
            int solucion=dijkstra(salida,grafo,nodos,tiempo);


            System.out.println(solucion);
        }



    }
}