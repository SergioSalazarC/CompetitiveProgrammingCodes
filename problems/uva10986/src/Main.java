import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.lang.Math;

public class Main {



    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        int n = in.nextInt();
        for(int i=0;i<n;i++){
            int nodos=in.nextInt();
            int cables=in.nextInt();
            int inicio=in.nextInt();
            int fin=in.nextInt();
            ArrayList<IntPair>[] graf = new ArrayList[nodos];
            for(int j=0;j<nodos;j++){
                graf[j]=new ArrayList<>();
            }
            for(int j=0;j<cables;j++){
                int a=in.nextInt();
                int b=in.nextInt();
                int c=in.nextInt();
                graf[a].add(new IntPair(c,b));
                graf[b].add(new IntPair(c,a));
            }

            PriorityQueue<IntPair> pq = new PriorityQueue<>();
            pq.offer(new IntPair(0,inicio)); //offer==add
            int[] dist = new int[nodos];
            Arrays.fill(dist,1000000000);
            dist[inicio]=0;

            while(!pq.isEmpty()){
                IntPair top = pq.poll(); //poll==remove
                int distop=top.d;
                int vtop=top.v;
                if(distop > dist[vtop]) continue;
                    for(IntPair aux: graf[vtop]){
                        int disaux=aux.d;
                        int vaux=aux.v;
                        if(dist[vtop]+disaux >= dist[vaux]) continue;
                        dist[vaux]=dist[vtop]+disaux;
                        pq.offer(new IntPair(dist[vaux],vaux));
                    }
            }
            System.out.println(dist[fin]);
        }

    }


    public static class IntPair implements Comparable{
        public int d;
        public int v;
        public IntPair(int dist, int vert){
            this.d=dist;
            this.v=vert;
        }
        @Override
        public int compareTo(Object o) {
            IntPair k= (IntPair) o;
            if(k.d==this.d){
                return(this.v-k.v);
            }else{
                return(this.d-k.d);
            }
        }
    }


}
