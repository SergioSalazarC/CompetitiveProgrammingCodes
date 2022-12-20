import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class aer299 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int calles=in.nextInt();
            int cruces=in.nextInt();
            ArrayList<IntPair>[] grafo= new ArrayList[calles];
            for(int i=0;i<calles;i++){
                grafo[i]=new ArrayList<>();
            }

            for(int i=0;i<cruces;i++){
                int a=in.nextInt()-1;
                int b=in.nextInt()-1;
                int d=in.nextInt();
                grafo[a].add(new IntPair(b,d));
                grafo[b].add(new IntPair(a,d));
            }

            boolean[] visitados = new boolean[calles];
            PriorityQueue<IntPair> pq = new PriorityQueue();
            visitados[0]=true;
            for(IntPair k:grafo[0]){
                if(!visitados[k.n]){
                    pq.add(new IntPair(k.n,k.d));
                }
            }
            int distancia=0;
            int cogidos=0;

            while(!pq.isEmpty() && cogidos < calles-1){
                IntPair top = pq.remove();
                if(!visitados[top.n]){
                    cogidos++;
                    distancia+=top.d;
                    visitados[top.n]=true;
                    for(IntPair k:grafo[top.n]){
                        if(!visitados[k.n]){
                            pq.add(new IntPair(k.n,k.d));
                        }
                    }
                }
            }

            if(cogidos==calles-1){
                System.out.println(distancia);
            }
            else{
                System.out.println("Imposible");
            }

        }
    }

    public static class IntPair implements Comparable{
        int n;
        int d;

        public IntPair(int n,int d) {
            this.n = n;
            this.d=d;
        }

        @Override
        public int compareTo(Object o) {
            IntPair i = (IntPair)o;
            return this.d-i.d;
        }
    }
}