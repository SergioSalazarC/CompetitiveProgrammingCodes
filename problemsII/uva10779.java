import java.util.*;

public class uva10779 {

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

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int caso = 1;
        int t = in.nextInt();
        while(t-->0){
            int n = in.nextInt();
            int m = in.nextInt();

            List<Edge>[] grafo = createGraph(n+m+2);
            for (int i = 1; i < m+1; i++) {
                addEdge(grafo,i,m+n+1,1);
            }

            //Lectura de Bob
            {
                int lim = in.nextInt();
                int[] cromos = new int[m + 1];
                for (int j = 1; j < lim + 1; j++) {
                    cromos[in.nextInt()]++;
                }
                for (int j = 1; j < m + 1; j++) {
                    if (cromos[j] != 0) {
                        addEdge(grafo, 0, j, cromos[j]);
                    }
                }
            }

            //Lectura de amigos
            for (int i = 2; i <= n; i++) {
                int lim = in.nextInt();
                int[] cromos = new int[m+1];
                for (int j = 1; j < lim+1; j++) {
                    cromos[in.nextInt()]++;
                }
                for (int j = 1; j <= m; j++) {
                    if(cromos[j]>1){
                        addEdge(grafo,m+i,j,cromos[j]-1);
                    }
                    else if(cromos[j]==0){
                        addEdge(grafo,j,m+i,1);
                    }
                }
            }

            long sol = maxFlow(grafo,0,n+m+1);
            System.out.println("Case #"+ caso+": "+sol);

            caso++;

        }
    }
}
