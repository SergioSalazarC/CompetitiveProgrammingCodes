import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class aer292 {

    public static class IntPair implements Comparable{
        int n;
        int d;

        public IntPair(int n, int d) {
            this.n = n;
            this.d = d;
        }

        @Override
        public int compareTo(Object o) {
            IntPair i = (IntPair) o;
            return this.d-i.d;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int nodos = in.nextInt();
            int edges = in.nextInt();
            LinkedList<IntPair>[] grafo =  new LinkedList[nodos+1];
            LinkedList<IntPair>[] grafoinvertido =  new LinkedList[nodos+1];

            for(int i=0;i<nodos+1;i++){
                grafo[i]=new LinkedList<>();
                grafoinvertido[i] =new LinkedList<>();
            }

            for(int i=0;i<edges;i++) {
                int a = in.nextInt();
                int b = in.nextInt();
                int d = in.nextInt();

                grafo[a].add(new IntPair(b, d));
                grafoinvertido[b].add(new IntPair(a, d));
            }

            int inicio=in.nextInt();
            int casos=in.nextInt();

            PriorityQueue<IntPair> pq = new PriorityQueue<>();
            pq.offer(new IntPair(inicio,0));
            int[] dist = new int[nodos+1];
            Arrays.fill(dist,1000000000);
            dist[inicio]=0;
            while(!pq.isEmpty()){
                IntPair top = pq.poll(); //poll==remove
                int distop=top.d;
                int vtop=top.n;
                if(distop > dist[vtop]) continue;
                for(IntPair aux: grafo[vtop]){
                    int disaux=aux.d;
                    int vaux=aux.n;
                    if(dist[vtop]+disaux >= dist[vaux]) continue;
                    dist[vaux]=dist[vtop]+disaux;
                    pq.offer(new IntPair(vaux,dist[vaux]));
                }
            }

            pq = new PriorityQueue<>();
            pq.offer(new IntPair(inicio,0));
            int[] distancia = new int[nodos+1];
            Arrays.fill(distancia,1000000000);
            distancia[inicio]=0;
            while(!pq.isEmpty()){
                IntPair top = pq.poll(); //poll==remove
                int distop=top.d;
                int vtop=top.n;
                if(distop > distancia[vtop]) continue;
                for(IntPair aux: grafoinvertido[vtop]){
                    int disaux=aux.d;
                    int vaux=aux.n;
                    if(distancia[vtop]+disaux >= distancia[vaux]) continue;
                    distancia[vaux]=distancia[vtop]+disaux;
                    pq.offer(new IntPair(vaux,distancia[vaux]));
                }
            }
            int cont=0;
            boolean bien=true;
            for(int i=0;i<casos;i++){
                int q=in.nextInt();
                if(bien){
                    cont+=dist[q];
                    cont+=distancia[q];
                }
                if(cont >=1000000000){
                    bien=false;
                }
            }
            if(bien){
                System.out.println(cont);
            }
            else{
                System.out.println("Imposible");
            }
        }
    }
}