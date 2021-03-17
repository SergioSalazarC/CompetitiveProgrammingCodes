import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine()," ");
        int n=Integer.parseInt(st.nextToken());
        int d=Integer.parseInt(st.nextToken());
        int esc=Integer.parseInt(st.nextToken());
        int serp= Integer.parseInt(st.nextToken());

        while(n!=0 || d!=0 || esc!=0 || serp!=0){

            HashMap<Integer,Integer> caminos = new HashMap<>();

            for(int i=0;i<esc+serp;i++){
                st = new StringTokenizer(in.readLine()," ");
                caminos.put(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            }

            boolean[] visitados = new boolean[n*n+1];
            Queue<Integer> cola = new LinkedList<>();
            visitados[1]=true;
            cola.add(null);
            cola.add(1);
            int tiradas=0;
            int sol=-1;

            while(cola.size()>1 && sol==-1){
                Integer pop = cola.remove();
                if(pop==null){
                    cola.add(null);
                    tiradas++;
                }
                else{
                    for(int i=1;i<=d;i++){
                        Integer nuevo = pop+i;
                        if(caminos.containsKey(nuevo)){
                            nuevo=caminos.get(nuevo);
                        }
                        if(nuevo==n*n){
                            sol=tiradas;
                            break;
                        }
                        if(nuevo>n*n){
                            continue;
                        }
                        if(!visitados[nuevo]){
                            visitados[nuevo]=true;
                            cola.add(nuevo);
                        }
                    }
                }
            }

            System.out.println(sol);


            st = new StringTokenizer(in.readLine()," ");
            n=Integer.parseInt(st.nextToken());
            d=Integer.parseInt(st.nextToken());
            esc=Integer.parseInt(st.nextToken());
            serp= Integer.parseInt(st.nextToken());

        }




    }
}