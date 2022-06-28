import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class cf580C {

    public static class IntPair{
        int x;
        int y;

        public IntPair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int cat = in.nextInt();
        int[] cats = new int[n+1];
        for(int i=1;i<=n;i++){
            cats[i]=in.nextInt();
        }
        ArrayList<Integer>[] grafo = new ArrayList[n+1];
        for(int i=0; i<=n;i++) grafo[i]=new ArrayList<>();
        while(in.hasNext()){
            int a=in.nextInt();
            int b=in.nextInt();
            grafo[a].add(b);
            grafo[b].add(a);
        }
        LinkedList<IntPair> cola = new LinkedList<>();
        boolean[] visitados = new boolean[n+1];
        cola.add(new IntPair(1,cats[1]));
        int solucion=0;
        visitados[1]=true;
        while(cola.size()>0){
            IntPair pop = cola.removeFirst();
            if(pop.y>cat) continue;
            if(grafo[pop.x].size()==1 && pop.x!=1) solucion++;
            for(Integer k : grafo[pop.x]){
                if(!visitados[k]){
                    if(cats[k]==0) cola.add(new IntPair(k,0));
                    else cola.add(new IntPair(k,pop.y+1));
                    visitados[k]=true;
                }
            }
        }
        System.out.println(solucion);
    }
}
