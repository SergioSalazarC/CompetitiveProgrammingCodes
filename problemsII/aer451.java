import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class aer451 {

    public static void unir(ArrayList<Estacion> estaciones){
        for (int i = 0; i < estaciones.size(); i++) {
            for (int j = i+1; j < estaciones.size(); j++) {
                Estacion a = estaciones.get(i);
                Estacion b = estaciones.get(j);

                if(a.tiempo>b.tiempo){
                    long tarda = (60-a.tiempo)+b.tiempo;
                    if(tarda == 0 || tarda==60){
                        grafo[a.nodo].add(new Pair(b.nodo,0));
                        grafo[b.nodo].add(new Pair(a.nodo, 0));
                    }
                    else{
                        grafo[a.nodo].add(new Pair(b.nodo,tarda));
                        grafo[b.nodo].add(new Pair(a.nodo, 60-tarda));
                    }
                }
                else{
                    long tarda = (60-b.tiempo)+a.tiempo;
                    if(tarda == 0 || tarda==60){
                        grafo[b.nodo].add(new Pair(a.nodo,0));
                        grafo[a.nodo].add(new Pair(b.nodo, 0));
                    }
                    else{
                        grafo[b.nodo].add(new Pair(a.nodo,tarda));
                        grafo[a.nodo].add(new Pair(b.nodo, 60-tarda));
                    }

                }

            }
        }
    }


    public static ArrayList<Pair>[] grafo;
    public static class Estacion{
        int nodo;
        long tiempo;

        public Estacion(int nodo, long tiempo) {
            this.nodo = nodo;
            this.tiempo = tiempo;
        }
    }

    public static class Pair implements Comparable{
        int nodo;
        long dist;

        public Pair(int nodo, long dist) {
            this.nodo = nodo;
            this.dist = dist;
        }

        @Override
        public int compareTo(Object o) {
            Pair i = (Pair) o;
            return Long.compare(this.dist,i.dist);
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s = in.readLine();
        while(s!=null){
            StringTokenizer st = new StringTokenizer(s);
            int n = Integer.parseInt(st.nextToken());
            int lineas = Integer.parseInt(st.nextToken());

            HashSet<Integer> salidas = new HashSet<>();
            HashSet<Integer> llegadas = new HashSet<>();

            ArrayList<Estacion>[] hs = new ArrayList[n+1];

            for (int i = 0; i < n+1; i++) {
                hs[i] = new ArrayList<>();
            }

            grafo = new ArrayList[lineas];
            for (int i = 0; i < lineas; i++) {
                grafo[i] = new ArrayList<>();
            }

            for (int i = 0; i < lineas; i++) {
                long distancia=0;
                st = new StringTokenizer(in.readLine());
                int inicio = Integer.parseInt(st.nextToken());
                if(inicio==1)salidas.add(i);
                if(inicio==n)llegadas.add(i);

                hs[inicio].add(new Estacion(i,0));
                while(st.hasMoreTokens()){
                    distancia+= Integer.parseInt(st.nextToken());
                    int nodo = Integer.parseInt(st.nextToken());
                    hs[nodo].add(new Estacion(i,distancia));
                    if(nodo==1)salidas.add(i);
                    if(nodo==n)llegadas.add(i);
                }
            }

            for (int i = 0; i < n+1; i++) {
                if(hs[i].size()>1) unir(hs[i]);
            }

            long mejor=Long.MAX_VALUE;

            for(Integer inicio : salidas){
                PriorityQueue<Pair> pq = new PriorityQueue<>();
                pq.offer(new Pair(inicio,0)); //offer==add
                long[] dist = new long[lineas];
                Arrays.fill(dist,1000000000);
                dist[inicio]=0;

                while(!pq.isEmpty()){
                    Pair top = pq.poll(); //poll==remove
                    if(llegadas.contains(top.nodo)){
                        mejor = Math.min(mejor,top.dist);
                    }
                    if(top.dist > dist[top.nodo]) continue;
                    for(Pair aux: grafo[top.nodo]){
                        if(dist[top.nodo]+aux.dist >= dist[aux.nodo]) continue;
                        dist[aux.nodo]=dist[top.nodo]+aux.dist;
                        pq.offer(new Pair(aux.nodo,dist[aux.nodo]));
                    }
                }
            }

            if(mejor == Long.MAX_VALUE) System.out.println("Hoy no vuelvo");
            else System.out.println(mejor);

            s = in.readLine();


        }
    }
}