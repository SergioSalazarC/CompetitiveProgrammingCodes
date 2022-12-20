import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class aer563 {

    public static int[][] memo;
    public static HashMap<Character,Integer> cant;

    public static int bfs(int ini, int fini, ArrayList<Integer>[] grafo){
        if(memo[ini][fini]!=0) return(memo[ini][fini]);
        int aux=0;
        boolean[] visitados = new boolean[cant.size()];
        visitados[ini]=true;
        LinkedList<Integer> cola= new LinkedList<>();
        cola.add(ini);
        cola.add(null);
        while(cola.size()>1){
            Integer top = cola.removeFirst();
            if(top==null){
                cola.addLast(null);
                aux++;
                continue;
            }
            for(Integer ady : grafo[top]){
                if(!visitados[ady]){
                    if(ady==fini){
                        memo[ini][fini]=aux+1;
                        return (aux+1);
                    }
                    visitados[ady]=true;
                    cola.addLast(ady);
                }
            }
        }
        return 0;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine()," ");
        int f = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        while(f!=0 && c!=0 & w!=0){

            char[][] kb = new char[f][c];
            int counter =0;
            cant = new HashMap<>();

            for(int i=0;i<f;i++){
                String aux = in.readLine();
                for(int j=0;j<c;j++){
                    kb[i][j] = aux.charAt(j);
                    if(!cant.containsKey(kb[i][j])) {
                        cant.put(kb[i][j],counter);
                        counter++;
                    }
                }
            }

            ArrayList<Integer>[] grafo = new ArrayList[cant.size()];
            for(int i=0;i<cant.size();i++){
                grafo[i]=new ArrayList<>();
            }
            memo = new int[cant.size()][cant.size()];

            HashSet<Character> carvis = new HashSet<>();

            for(int i=0;i<f;i++){
                for(int j=0;j<c;j++){
                    char t = kb[i][j];
                    if(carvis.contains(t))continue;
                    else{
                        carvis.add(t);
                        int iaux= (f+i-1)%f;
                        int jaux= (c+j-1)%c;
                        grafo[cant.get(t)].add(cant.get(kb[iaux][j]));
                        grafo[cant.get(t)].add(cant.get(kb[i][jaux]));
                        int fa = (i+1)%f;
                        while(kb[fa][j]==kb[i][j] && fa!=i){
                            fa = (fa+1)%f;
                        }
                        grafo[cant.get(t)].add(cant.get(kb[fa][j]));
                        int cd = (j+1)%c;
                        while(kb[i][cd]==kb[i][j] && cd!=j){
                            cd = (cd+1)%c;
                        }
                        grafo[cant.get(t)].add(cant.get(kb[i][cd]));

                    }
                }
            }


            for(int query = 0 ;query<w ; query++){
                int sol=0;
                String aux = in.readLine();
                aux= kb[0][0] + aux;
                int cambios = aux.length()-1;
                for(int i=0;i<cambios;i++){
                    if(aux.charAt(i)==aux.charAt(i+1)) continue;
                    sol+=bfs(cant.get(aux.charAt(i)),cant.get(aux.charAt(i+1)),grafo);
                }
                System.out.println(sol);
            }
            System.out.println("---");
            st = new StringTokenizer(in.readLine()," ");
            f = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
        }
    }
}