import java.util.*;

public class aer326 {

    public static int N;
    public static int M;

    public static boolean limites(int x, int y){
        return x>=0 && y>=0 && x<=N && y<=M;
    }

    public static int codificar(Pair aux){
        return (aux.x+(aux.y*(N+1)));
    }

    static class UnionFind {
        private ArrayList<Integer> p, rank, setSize;
        private int numSets;

        public UnionFind(int N) {
            p = new ArrayList<>(N);
            rank = new ArrayList<>(N);
            setSize = new ArrayList<>(N);
            numSets = N;
            for (int i = 0; i < N; i++) {
                p.add(i);
                rank.add(0);
                setSize.add(1);
            }
        }

        public int findSet(int i) {
            if (p.get(i) == i) return i;
            else {
                int ret = findSet(p.get(i)); p.set(i, ret);
                return ret; } }

        public Boolean isSameSet(int i, int j) { return findSet(i) == findSet(j); }

        public void unionSet(int i, int j) {
            if (!isSameSet(i, j)) { numSets--;
                int x = findSet(i), y = findSet(j);
                if (rank.get(x) > rank.get(y)) { p.set(y, x); setSize.set(x, setSize.get(x) + setSize.get(y)); }
                else{
                    p.set(x, y); setSize.set(y, setSize.get(y) + setSize.get(x));
                    if (rank.get(x) == rank.get(y)) rank.set(y, rank.get(y) + 1); } } }
    }




    public static class Pair{
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }



        @Override
        public String toString() {
            return  x+" "+y ;
        }
    }





    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            N = in.nextInt();
            M = in.nextInt();
            int k = in.nextInt();
            int n=in.nextInt();
            boolean[][] grafo = new boolean[N+1][M+1];
            LinkedList<Pair> pila = new LinkedList<>();
            UnionFind conjuntos = new UnionFind((N+2)*(M+1));
            for(int i=0;i<n;i++){
                pila.addFirst(new Pair(in.nextInt(),in.nextInt()));
            }
            grafo[0][0]=true;
            grafo[N][M]=true;


            Pair nod = null;
            boolean salida=true;
            while(!pila.isEmpty() && salida){
                nod = pila.removeFirst();
                for(int i=-k;i<=k&& salida;++i){
                    for(int j=-k;j<=k&& salida;++j){
                        if(i*i+j*j<=k*k && limites(i+nod.x,j+nod.y) && grafo[i+nod.x][j+nod.y]){
                            conjuntos.unionSet(codificar(nod),codificar(new Pair(nod.x+i,nod.y+j)));
                            if (conjuntos.isSameSet(0,codificar(new Pair(N,M)))) salida=false;
                        }
                    }
                }
                grafo[nod.x][nod.y]=true;
            }
            if(salida){
                System.out.println("NUNCA SE PUDO");
            }else{
                System.out.println(nod);
            }
        }
    }
}