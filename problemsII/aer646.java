import java.util.*;

public class aer646 {

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
            int query = in.nextInt();
            for (int i = 0; i < query; i++) {
                int a = in.nextInt()-1;
                int b = in.nextInt()-1;
                int d = in.nextInt();
                boolean[] visit = new boolean[nodos];

                Queue<Integer> cola = new LinkedList<>();
                cola.add(a);
                while(!cola.isEmpty()){
                    int t = cola.remove();
                    for(Par x: grafo[t]){
                        if(x.dist>=d){
                            if(!visit[x.nodo]){
                                cola.add(x.nodo);
                                visit[x.nodo]=true;
                                if(x.nodo==b) break;
                            }
                        }
                    }
                }
                if(visit[b]) System.out.println("SI");
                else System.out.println("NO");


            }

        }
    }
}