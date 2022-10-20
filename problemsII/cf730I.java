import com.sun.source.tree.Tree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class cf730I {
    static int max;
    static int nodocp;
    static int nododepo;
    static TreeSet<Integer> prog = new TreeSet<>();
    static TreeSet<Integer> depo = new TreeSet<>();

    public static void main (String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int cp = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        max=n;
        nodocp = n+1;
        nododepo = n+2;
        List<Edge>[] graph =createGraph(n+4);
        //0 source
        //n+1 => programing
        //n+2 => sport
        //n+3 => target
        addEdge(graph,0,n+1,cp,0);
        addEdge(graph,0,n+2,s,0);


        st = new StringTokenizer(in.readLine()," ");
        for (int i = 1; i <= n; i++) {
            int val = Integer.parseInt(st.nextToken());
            addEdge(graph,n+1,i,1,-val);
        }

        st = new StringTokenizer(in.readLine()," ");
        for (int i = 1; i <=n ; i++) {
            int val = Integer.parseInt(st.nextToken());
            addEdge(graph,n+2,i,1,-val);
        }

        for (int i = 1; i <=n ; i++) {
            addEdge(graph,i,n+3,1,0);
        }
        StringBuilder sol = new StringBuilder();

        int[] costSol = minCostFlow(graph,0,n+3,Integer.MAX_VALUE);

        sol.append(-costSol[1]).append("\n");
        StringBuilder progsol = new StringBuilder();
        for (Integer k : prog) {
            progsol.append(k).append(" ");
        }
        StringBuilder deposol = new StringBuilder();
        for (Integer k : depo) {
            deposol.append(k).append(" ");
        }
        sol.append(progsol.toString().trim()).append("\n");
        sol.append(deposol.toString().trim()).append("\n");
        out.append(sol);
        out.flush();


    }

    static class Edge {
        int to, f, cap, cost, rev;

        Edge(int v, int cap, int cost, int rev) {
            this.to = v;
            this.cap = cap;
            this.cost = cost;
            this.rev = rev;
        }
    }

    public static List<Edge>[] createGraph(int n) {
        List<Edge>[] graph = new List[n];
        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<Edge>();
        return graph;
    }

    public static void addEdge(List<Edge>[] graph, int s, int t, int cap, int cost) {
        graph[s].add(new Edge(t, cap, cost, graph[t].size()));
        graph[t].add(new Edge(s, 0, -cost, graph[s].size() - 1));
    }

    static void bellmanFord(List<Edge>[] graph, int s, int[] dist, int[] prevnode, int[] prevedge, int[] curflow) {
        int n = graph.length;
        Arrays.fill(dist, 0, n, Integer.MAX_VALUE);
        dist[s] = 0;
        curflow[s] = Integer.MAX_VALUE;
        boolean[] inqueue = new boolean[n];
        int[] q = new int[n];
        int qt = 0;
        q[qt++] = s;
        for (int qh = 0; (qh - qt) % n != 0; qh++) {
            int u = q[qh % n];
            inqueue[u] = false;
            for (int i = 0; i < graph[u].size(); i++) {
                Edge e = graph[u].get(i);
                if (e.f >= e.cap)
                    continue;
                int v = e.to;
                int ndist = dist[u] + e.cost;
                if (dist[v] > ndist) {
                    dist[v] = ndist;
                    prevnode[v] = u;
                    prevedge[v] = i;
                    curflow[v] = Math.min(curflow[u], e.cap - e.f);
                    if (!inqueue[v]) {
                        inqueue[v] = true;
                        q[qt++ % n] = v;
                    }
                }
            }
        }
    }

    public static int[] minCostFlow(List<Edge>[] graph, int s, int t, int maxf) {
        int n = graph.length;
        int[] dist = new int[n];
        int[] curflow = new int[n];
        int[] prevedge = new int[n];
        int[] prevnode = new int[n];

        int flow = 0;
        int flowCost = 0;
        while (flow < maxf) {
            bellmanFord(graph, s, dist, prevnode, prevedge, curflow);
            if (dist[t] == Integer.MAX_VALUE)
                break;
            int df = Math.min(curflow[t], maxf - flow);
            flow += df;
            for (int v = t; v != s; v = prevnode[v]) {
                Edge e = graph[prevnode[v]].get(prevedge[v]);
                e.f += df;
                graph[v].get(e.rev).f -= df;
                flowCost += df * e.cost;

                if(prevnode[v]==nodocp && 1<=v && v<=max){
                    prog.add(v);
                }
                else if(prevnode[v]==nododepo && 1<=v && v<=max){
                    depo.add(v);
                }
                else if(v==nodocp && 1<=prevnode[v] && prevnode[v]<=max){
                    prog.remove(prevnode[v]);
                }
                if(v==nododepo && 1<=prevnode[v] && prevnode[v]<=max){
                    depo.remove(prevnode[v]);
                }


            }
        }
        return new int[]{flow, flowCost};
    }

}
