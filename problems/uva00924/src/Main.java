import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(in.readLine().trim());
        ArrayList<Integer>[] graf = new ArrayList[v];
        for(int i =0;i<v;i++){
            String aux=in.readLine();
            graf[i]=new ArrayList<>();
            StringTokenizer st =  new StringTokenizer(aux," ");
            int p = Integer.parseInt(st.nextToken());
            for(int m=0;m<p;m++){
                graf[i].add(Integer.parseInt(st.nextToken()));
            }
        }
        int casos = Integer.parseInt(in.readLine());
        for(int i =0; i<casos;i++){
            int inicio = Integer.parseInt(in.readLine().trim());
            if(graf[inicio].isEmpty()) System.out.println(0);
            else{
                boolean[] visitados = new boolean[v];
                Queue<Integer> cola = new LinkedList<>();
                int dia=1;
                int amigosact=0;
                int amigosboom=0;
                int diaboom=0;
                cola.add(inicio);
                cola.add(null);
                visitados[inicio]=true;
                while(cola.size()>1){
                    Integer pop = cola.remove();
                    if(pop==null){
                        cola.add(null);
                        if(amigosact>amigosboom){
                            amigosboom=amigosact;
                            diaboom=dia;
                        }
                        amigosact=0;
                        dia++;
                    }
                    else{
                        for(Integer k: graf[pop]){
                            if(!visitados[k]){
                                cola.add(k);
                                visitados[k]=true;
                                amigosact++;
                            }
                        }
                    }
                }
                System.out.println(amigosboom+" "+diaboom);

            }
        }
    }
}
