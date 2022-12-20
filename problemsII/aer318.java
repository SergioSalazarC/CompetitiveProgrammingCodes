import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class aer318 {
    public static class IntPair implements Comparable{
        int nodo;
        int tiempo;

        public IntPair(int nodo, int tiempo) {
            this.nodo = nodo;
            this.tiempo = tiempo;
        }

        @Override
        public int compareTo(Object o) {
            IntPair i = (IntPair) o;
            return this.tiempo-i.tiempo;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();
            ArrayList<IntPair>[] grafo = new ArrayList[n+1];
            for(int i=0;i<n+1;i++){
                grafo[i]=new ArrayList<>();
            }
            int[]  carga = new int[n+1];
            for(int i=1;i<=n;i++){
                carga[i]=in.nextInt();
            }
            int m = in.nextInt();
            for(int i=0;i<m;i++){
                int a=in.nextInt();
                int b=in.nextInt();
                int t=in.nextInt();
                grafo[a].add(new IntPair(b,t+carga[b]));
            }
            int[] dist=new int[n+1];
            Arrays.fill(dist,1000000000);
            dist[1]=carga[1];
            PriorityQueue<IntPair> pq = new PriorityQueue();
            pq.add(new IntPair(1,carga[1]));

            while(!pq.isEmpty()){
                IntPair top = pq.poll();
                if(top.tiempo>dist[top.nodo]) continue;
                for(IntPair aux : grafo[top.nodo]){
                    if(dist[top.nodo]+aux.tiempo >= dist[aux.nodo]) continue;
                    dist[aux.nodo]= dist[top.nodo]+aux.tiempo;
                    pq.offer(new IntPair(aux.nodo,dist[aux.nodo]));
                }
            }

            if(dist[n]==1000000000) System.out.println("IMPOSIBLE");
            else System.out.println(dist[n]);

        }
    }
}