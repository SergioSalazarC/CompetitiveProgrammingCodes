import java.util.*;

public class Main2 {
    public static void main(String[] args) {

        Scanner in= new Scanner(System.in);

        while(in.hasNext()) {
            int v = in.nextInt();
            int e = in.nextInt();
            ArrayList<Integer>[] grafo= new ArrayList[v];
            grafo[0] = new ArrayList<>();
            for(int i=0;i<e;i++){
                int a=in.nextInt();
                int b=in.nextInt();
                if(grafo[a]==null){
                    grafo[a]= new ArrayList<>();
                }
                if(grafo[b]==null){
                    grafo[b]= new ArrayList<>();
                }
                grafo[b].add(a);
                grafo[a].add(b);
            }
            boolean[] visitados = new boolean[v];
            Queue<Integer> cola = new LinkedList<>();
            cola.add(0);
            visitados[0]=true;
            int[] padres = new int[v];
            Arrays.fill(padres, -1);
            boolean morir=true;
            while(cola.size() > 0){
                int superior =cola.remove();
                for(int i=0;i<grafo[superior].size() && morir;i++){
                    int aux= grafo[superior].get(i);
                    if(!visitados[aux]){
                        visitados[aux]=true;
                        padres[aux]=superior;
                        cola.add(aux);
                    }else{
                        if(aux!=padres[superior]){
                            morir=false;
                            break;
                        }
                    }
                }

            }
            if(morir){
                boolean otro=true;
                for(int i=0;i<v;i++){
                    otro=otro && visitados[i];
                }
                if (otro) System.out.println("SI");
                else System.out.println("NO");
            }else{
                System.out.println("NO");
            }
        }
    }
}