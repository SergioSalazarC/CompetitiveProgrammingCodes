import java.util.*;

public class Main2 {
    public static void main(String[] args) {

        Scanner in= new Scanner(System.in);

        while(in.hasNext()){
            int nodos=in.nextInt();
            int aristas=in.nextInt();
            ArrayList<Integer>[] grafo =new ArrayList[nodos];
            for(int i=0;i<nodos;i++){
                grafo[i]= new ArrayList<>();
            }
            for(int i=0;i<aristas;i++){
                int a=in.nextInt();
                int b=in.nextInt();                
                grafo[a].add(b);
                grafo[b].add(a);
            }

            int[] visitados = new int[nodos];
            int color = 1;
            boolean bipartito=true;
            Queue<Integer> cola = new LinkedList<>();
            cola.add(0);
            cola.add(null);
            while(cola.size()>1 && bipartito){
                Integer pop = cola.remove();
                if(pop==null){
                    if (color==1) color=2;
                    else if (color==2) color=1;
                    cola.add(null);
                }
                else{
                    visitados[pop]=color;
                    for(int i=0;i<grafo[pop].size();i++){
                        int aux= grafo[pop].get(i);
                        if(visitados[pop]==visitados[aux]){
                            bipartito=false;
                            break;
                        }else if(visitados[aux]==0){
                            cola.add(aux);
                        }
                    }
                }
                if(cola.size()<=1){
                    for(int i=0;i<nodos;i++){
                        if(visitados[i]==0){
                            cola.add(i);
                            break;
                        }
                    }
                }
            }
            if(bipartito) System.out.println("SI");
            else System.out.println("NO");

        }
    }
}