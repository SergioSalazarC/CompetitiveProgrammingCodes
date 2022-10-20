import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class cf343E {

    static int val = 0;
    static LinkedList<Integer> solucion = new LinkedList<>();


    public static int busqueda(int[][] memo){
        HashSet<Integer> visitados=new HashSet<>();
        int a=-1;
        int b=-1;
        int max=0;
        for (int i=1;i<memo.length;i++){
            for (int j = 1; j < memo.length; j++) {
                if(memo[i][j]>max){
                    a=i;
                    b=j;
                    max=memo[i][j];
                }
            }
        }

        val+=max;

        visitados.add(a);
        visitados.add(b);

        solucion.addFirst(a);
        solucion.addLast(b);
        while(visitados.size()<memo.length-1){
            max = -1;
            int selec=-1;
            int prim= solucion.getFirst();
            int ult = solucion.getLast();
            for (int i = 1; i < memo.length; i++) {
                if(visitados.contains(i))continue;
                if(memo[i][prim]>max){
                    selec=i;
                    max=memo[i][prim];
                }
                if(memo[i][ult]>max){
                    selec=i;
                    max=memo[i][prim];
                }
            }
            if(memo[selec][prim]>memo[selec][ult]){
                val+=memo[selec][prim];
                solucion.addFirst(selec);
                visitados.add(selec);
            }
            else{
                val+=memo[selec][ult];
                visitados.add(selec);
                solucion.addLast(selec);
            }
        }

        return 1;
    }



    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] input = new int[n+1][n+1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            input[a][b]=c;
            input[b][a]=c;
        }

        int[][] datos = new int[n+1][n+1];

        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= n ; j++) {
                if(i==j)continue;
                List<Edge>[] grafo = createGraph(n+1);
                grafo = setGrafo(input,grafo);
                int aux= maxFlow(grafo,i,j);
                datos[i][j]=aux;
            }
        }

        busqueda(datos);

        System.out.println(val);
        StringBuilder apoyo = new StringBuilder();
        for(Integer k : solucion){
            apoyo.append(k).append(" ");
        }
        System.out.println(apoyo.toString().trim());
    }

    public static List<Edge>[] setGrafo(int[][] input, List<Edge>[] graph){
        for (int i = 1; i < input.length; i++) {
            for (int j = 1; j < input.length; j++) {
                if(input[i][j]!=0) addEdge(graph,i,j,input[i][j]);
            }
        }
        return graph;
    }


    static class Edge {
        int t, rev, cap, f;

        public Edge(int t, int rev, int cap) {
            this.t = t;
            this.rev = rev;
            this.cap = cap;
        }
    }

    public static List<Edge>[] createGraph(int nodes) {
        List<Edge>[] graph = new List[nodes];
        for (int i = 0; i < nodes; i++)
            graph[i] = new ArrayList<>();
        return graph;
    }



    public static void addEdge(List<Edge>[] graph, int s, int t, int cap) {
        graph[s].add(new Edge(t, graph[t].size(), cap));
        graph[t].add(new Edge(s, graph[s].size() - 1, 0));
    }

    static boolean dinicBfs(List<Edge>[] graph, int src, int dest, int[] dist) {
        Arrays.fill(dist, -1);
        dist[src] = 0;
        int[] Q = new int[graph.length];
        int sizeQ = 0;
        Q[sizeQ++] = src;
        for (int i = 0; i < sizeQ; i++) {
            int u = Q[i];
            for (Edge e : graph[u]) {
                if (dist[e.t] < 0 && e.f < e.cap) {
                    dist[e.t] = dist[u] + 1;
                    Q[sizeQ++] = e.t;
                }
            }
        }
        return dist[dest] >= 0;
    }

    static int dinicDfs(List<Edge>[] graph, int[] ptr, int[] dist, int dest, int u, int f) {
        if (u == dest)
            return f;
        for (; ptr[u] < graph[u].size(); ++ptr[u]) {
            Edge e = graph[u].get(ptr[u]);
            if (dist[e.t] == dist[u] + 1 && e.f < e.cap) {
                int df = dinicDfs(graph, ptr, dist, dest, e.t, Math.min(f, e.cap - e.f));
                if (df > 0) {
                    e.f += df;
                    graph[e.t].get(e.rev).f -= df;
                    return df;
                }
            }
        }
        return 0;
    }

    public static int maxFlow(List<Edge>[] graph, int src, int dest) {
        int flow = 0;
        int[] dist = new int[graph.length];
        while (dinicBfs(graph, src, dest, dist)) {
            int[] ptr = new int[graph.length];
            while (true) {
                int df = dinicDfs(graph, ptr, dist, dest, src, Integer.MAX_VALUE);
                if (df == 0)
                    break;
                flow += df;
            }
        }
        return flow;
    }
}
