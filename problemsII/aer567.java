import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class aer567 {

    static HashMap<Integer,Integer>[] grafo;
    static int size;

    public static int queryindividual(int n){
        //Buscar si existe un ciclo de n a n
        int[] anterior= new int[size+1];
        boolean[] visitado = new boolean[size+1];
        LinkedList<Integer> pila = new LinkedList<>();
        pila.addLast(n);

        boolean finded = false;
        int det = -1;
        while(!pila.isEmpty() && !finded){
            Integer top=pila.removeLast();
            if(visitado[top])continue;
            visitado[top]=true;
            for (Integer k : grafo[top].keySet()) {
                if(anterior[top]==k)continue;
                anterior[k]=top;
                if(grafo[k].containsKey(k)){
                    finded=true;
                    det=k;
                    break;
                }
                if(k==n){
                    finded=true;
                    break;
                }
                pila.addLast(k);
            }
        }

        if(!finded) return -1;
        else if(anterior[n]==n) return grafo[n].get(n);
        else{
            if(det==-1){
                int size= 1;
                int aux=anterior[n];
                int sol = grafo[aux].get(n);
                while(aux!=n){
                    int ant=anterior[aux];
                    if(size%2==1) sol-=grafo[aux].get(ant);
                    else sol+=grafo[aux].get(ant);
                    aux=ant;
                    size++;
                }
                if(size%2==0)return -1;
                else{
                    grafo[n].put(n,sol/2);
                    return sol/2;

                }
            }
            else{
                int aux = det;
                int sol=-grafo[det].get(det);
                while(aux!=n){
                    int ant=anterior[aux];
                    if(size%2==1) sol-=grafo[aux].get(ant);
                    else sol+=grafo[aux].get(ant);
                    aux=ant;
                }
                grafo[n].put(n,sol);

                return sol;

            }
        }

    }

    public static int queryidoble(int n, int m){
        //Buscar si existe un camino de n a m
        int[] anterior= new int[size+1];
        boolean[] visitado = new boolean[size+1];
        LinkedList<Integer> pila = new LinkedList<>();
        pila.addLast(n);

        boolean finded = false;
        while(!pila.isEmpty() && !finded){
            Integer top=pila.removeLast();
            if(visitado[top])continue;
            visitado[top]=true;
            for (Integer k : grafo[top].keySet()) {
                if(anterior[top]==k)continue;
                anterior[k]=top;
                if(k==m){
                    finded=true;
                    break;
                }
                pila.addLast(k);
            }
        }

        if(anterior[m]==0) return -1;
        else if(anterior[m]==n) return grafo[n].get(m);
        else{
            //Mirar recorrido para obtener la solucion
            int size= 1;
            int aux=anterior[m];
            int sol = grafo[aux].get(m);
            while(aux!=n){
                int ant=anterior[aux];
                if(size%2==1) sol-=grafo[aux].get(ant);
                else sol+=grafo[aux].get(ant);
                aux=ant;
                size++;
            }

            if(size%2==0)return -1;
            else{
                grafo[n].put(m,sol);
                grafo[m].put(n,sol);
                return sol;
            }

        }

    }



    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(in.readLine());

        size = Integer.parseInt(st.nextToken());
        int edges = Integer.parseInt(st.nextToken());
        int queris = Integer.parseInt(st.nextToken());

        while(size!=0 || edges!=0 || queris!=0){
            grafo = new HashMap[size+1];
            for (int i = 0; i < size+1; i++) {
                grafo[i]=new HashMap();
            }

            for (int i = 0; i < edges; i++) {
                st = new StringTokenizer(in.readLine());
                int a = Integer.parseInt(st.nextToken());
                if(a==1){
                    int nodo = Integer.parseInt(st.nextToken());
                    int value = Integer.parseInt(st.nextToken());
                    grafo[nodo].put(nodo,value);

                }
                else{
                    int nodoa = Integer.parseInt(st.nextToken());
                    int nodob = Integer.parseInt(st.nextToken());
                    int value = Integer.parseInt(st.nextToken());

                    grafo[nodoa].put(nodob,value);
                    grafo[nodob].put(nodoa,value);
                }
            }


            for (int i = 0; i < queris; i++) {
                st = new StringTokenizer(in.readLine());
                int a = Integer.parseInt(st.nextToken());
                if(a==1){
                    int sol = queryindividual(Integer.parseInt(st.nextToken()));
                    if(sol==-1) sb.append("CUIDADO").append("\n");
                    else sb.append(sol).append("\n");
                }
                else{
                    int s1 = Integer.parseInt(st.nextToken());
                    int s2 = Integer.parseInt(st.nextToken());
                    int sol1 = queryindividual(s1);
                    int sol2 = queryindividual(s2);
                    int sol=0;
                    if(sol1==-1 || sol2==-1)sol = queryidoble(s1,s2);
                    else sol = sol1 + sol2;
                    if(sol==-1) sb.append("CUIDADO").append("\n");
                    else sb.append(sol).append("\n");
                }
            }
            sb.append("---").append("\n");


            st = new StringTokenizer(in.readLine());
            size = Integer.parseInt(st.nextToken());
            edges = Integer.parseInt(st.nextToken());
            queris = Integer.parseInt(st.nextToken());
        }
        System.out.print(sb);




    }
}
