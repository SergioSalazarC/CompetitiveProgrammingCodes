import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class aer651 {

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
            if(grafo[i].isEmpty())continue;
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
        }
        return flujo_maximo;
    }



    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int F=in.nextInt();
        int C=in.nextInt();
        int D=in.nextInt();

        while(F!=0 || C!=0 || D!=0){
            //Nodo inicio -> 0
            //Nodo final --> 1
            //Nodo defensa -> 2
            //Nodo centro --> 3
            //Nodo delant --> 4
            //Jugador 1 -> 5
            HashMap<Integer,Integer>[] grafo = new HashMap[40];
            int jug = in.nextInt();
            for (int i = 0; i < 40; i++) {
                grafo[i]=new HashMap<>();
            }
            grafo[2].put(1,F);
            grafo[3].put(1,C);
            grafo[4].put(1,D);

            for (int i = 0; i < jug; i++) {
                grafo[0].put(i+5,1);
                String desc = in.next();
                if(desc.contains("F")){
                    grafo[i+5].put(2,1);
                }
                if(desc.contains("C")){
                    grafo[i+5].put(3,1);
                }
                if(desc.contains("D")){
                    grafo[i+5].put(4,1);
                }
            }


            int sol = fordFulkerson(grafo,0,1,40);
            if(sol>=F+C+D) System.out.println("SI");
            else System.out.println("NO");

            F=in.nextInt();
            C=in.nextInt();
            D=in.nextInt();

        }
    }
}
