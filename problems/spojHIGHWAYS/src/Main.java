import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        for(int casos=0;casos<t;casos++){
            StringTokenizer st = new StringTokenizer(in.readLine(), " ");
            int cit = Integer.parseInt(st.nextToken());
            int hig = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken())-1;
            int end =Integer.parseInt(st.nextToken())-1;
            ArrayList<IntPair>[] graf =new ArrayList[cit];

            for(int aux=0;aux<cit;aux++){
                graf[aux] = new ArrayList<>();
            }

            for(int aux=0;aux<hig;aux++){
                st=new StringTokenizer(in.readLine()," ");
                int a=Integer.parseInt(st.nextToken())-1;
                int b=Integer.parseInt(st.nextToken())-1;
                int d=Integer.parseInt(st.nextToken());
                graf[a].add(new IntPair(b,d));
                graf[b].add(new IntPair(a,d));

            }

            PriorityQueue<IntPair> pq = new PriorityQueue<>();
            pq.offer(new IntPair(start,0));
            int[] dist=new int[cit];
            Arrays.fill(dist,1000000000);
            dist[start]=0;

            while(!pq.isEmpty()){
                IntPair top = pq.poll();
                int distop=top.d;
                int vtop=top.x;
                if(distop > dist[vtop]) continue;
                for(IntPair aux:graf[vtop]){
                    int disaux=aux.d;
                    int vaux=aux.x;
                    if(dist[vtop]+disaux >= dist[vaux]) continue;
                    dist[vaux]=dist[vtop]+disaux;
                    pq.offer(new IntPair(vaux,dist[vaux]));

                }
            }

            if(dist[end]==1000000000) System.out.println("NONE");
            else System.out.println(dist[end]);


        }
    }


    public static class IntPair implements Comparable{
        int x;
        int d;

        public IntPair(int xx, int dd){
            x=xx;
            d=dd;
        }


        @Override
        public int compareTo(Object o) {
            IntPair n = (IntPair)o;
            return (this.d-n.d);
        }
    }
}
