import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int puntos = in.nextInt();
            int carret = in.nextInt();

            ArrayList<Integer>[] graf = new ArrayList[puntos];
            for(int i=0;i<puntos;i++){
                graf[i]=new ArrayList<>();
            }
            for (int i=0;i<carret;i++){
                int a=in.nextInt()-1;
                int b=in.nextInt()-1;
                graf[a].add(b);
                graf[b].add(a);
            }

            boolean[] visit = new boolean[puntos];
            visit[0]=true;
            Queue<Integer> cola = new LinkedList<>();
            cola.add(0);
            while(cola.size()>0){
                int pop = cola.remove();
                for(Integer aux: graf[pop]){
                    if(visit[aux]) continue;
                    cola.add(aux);
                    visit[aux]=true;
                }

            }
            boolean g=true;
            for(int i=0;i<puntos;i++){
                g=g&&visit[i];
            }


            if(g) System.out.println("BICI");
            else System.out.println("A PIE");


        }



    }
}
