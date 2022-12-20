import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class aer566 {

    static int cap;
    static int lob;

    public static int codificar(int cx, int cy,int ancho){
        return cx*ancho+cy;
    }

    public static boolean BFS(HashMap<Integer,Integer>[] grafo, int s, int t , int parent[], int v){
        boolean[] visited = new boolean[v];
        visited[s]=true;
        LinkedList<Integer> cola = new LinkedList<>();
        cola.addFirst(s);
        parent[s]=-1;
        while(!cola.isEmpty()){
            int aux = cola.remove();
            for(Integer k :  grafo[aux].keySet()){
                if(!visited[k]){
                    if(k==t){
                        parent[t]=aux;
                        return true;
                    }
                    cola.add(k);
                    parent[k]=aux;
                    visited[k]=true;
                }
            }
        }
        return false;
    }

    public static int fordFulkerson(HashMap<Integer,Integer>[] grafo, int s, int t,int v){
        HashMap<Integer,Integer>[] rgrafo = new HashMap[v];
        for(int i=0;i<v;i++){
            rgrafo[i]=new HashMap<>();
            for(Integer k : grafo[i].keySet()){
                rgrafo[i].put(k,grafo[i].get(k));
            }
        }

        int parent[] = new int[v];

        int flujo_maximo=0;

        while(BFS(rgrafo,s,t,parent,v)){

            int flujo=Integer.MAX_VALUE;
            int camino = t;
            while(camino!=s){
                int aux=parent[camino];
                flujo=Math.min(flujo,rgrafo[aux].get(camino));
                camino=parent[camino];
            }

            camino = t;
            while(camino!=s){
                int aux=parent[camino];
                rgrafo[aux].put(camino,rgrafo[aux].get(camino)-flujo);
                if (rgrafo[aux].get(camino) == 0) {
                    rgrafo[aux].remove(camino);
                }
                rgrafo[camino].put(aux,(rgrafo[camino].containsKey(aux) ?  rgrafo[camino].get(aux) : 0)+flujo);
                camino=parent[camino];
            }

            flujo_maximo+=flujo;

            if(flujo_maximo>6) return flujo_maximo;
        }


        return flujo_maximo;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        HashMap<Integer,Integer>[] grafo;
        for(int c=0;c<n;c++){
            StringTokenizer st = new StringTokenizer(in.readLine()," ");
            int largo = Integer.parseInt(st.nextToken());
            int ancho = Integer.parseInt(st.nextToken());
            grafo=new HashMap[largo*ancho];
            for(int i=0;i<largo*ancho;i++){
                grafo[i]=new HashMap<>();
            }
            for(int i=0;i<largo;i++) {
                String aux = in.readLine();
                for (int j = 0; j < ancho; j++) {
                    if (aux.charAt(j) != '#') {
                        int dig = codificar(i, j,ancho);
                        if (i*ancho<=(dig + 1) && (dig + 1)<(i+1)*ancho) grafo[dig].put(dig + 1, 1000);
                        if (i*ancho<=(dig - 1) && (dig - 1)<(i+1)*ancho) grafo[dig].put(dig - 1, 1000);
                        if (0<=(dig + ancho) && (dig + ancho)<largo*ancho) grafo[dig].put(dig + ancho, 1000);
                        if (0<=(dig - ancho) && (dig - ancho)<largo*ancho) grafo[dig].put(dig - ancho, 1000);
                    }
                    if (aux.charAt(j) == 'C') {
                        cap=codificar(i,j,ancho);
                    }
                    if (aux.charAt(j) == 'L') {
                        lob=codificar(i,j,ancho);
                    }
                }
            }
            //Peso de los veertices -> 1
            int numv=grafo.length;
            HashMap<Integer,Integer>[] graforeal = new HashMap[2*numv];
            for(int i=0;i<2*numv;i++){
                graforeal[i]=new HashMap<>();
            }
            for(int i=0;i<grafo.length;i++){
                if(grafo[cap].containsKey(i) || i==cap || i==lob){
                    graforeal[i].put(i+numv,1000);
                }
                else{
                    graforeal[i].put(i+numv,1);
                }
                for(Integer k : grafo[i].keySet()){
                    graforeal[i+numv].put(k,grafo[i].get(k));
                }
            }
            int flujo = fordFulkerson(graforeal,lob,cap,2*numv);
            if(flujo>4){
                System.out.println("IMPOSIBLE");
            }else{
                System.out.println(flujo);
            }
        }
    }
}