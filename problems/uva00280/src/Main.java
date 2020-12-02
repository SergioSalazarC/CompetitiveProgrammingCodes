import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int vertices = Integer.parseInt(in.readLine());

        while(vertices!=0) {
            ArrayList<Integer>[] graf = new ArrayList[vertices + 1];

            for(int i=0;i<=vertices;i++){
                graf[i] = new ArrayList<>();
            }
            while (true) {
                String aux = in.readLine();
                if (aux.equals("0")) break;
                StringTokenizer st = new StringTokenizer(aux, " ");
                int i = Integer.parseInt(st.nextToken());

                while (true) {
                    int a = Integer.parseInt(st.nextToken());
                    if (a == 0) break;
                    else {
                        graf[i].add(a);
                    }
                }
            }

            

            String sig = in.readLine();
            StringTokenizer st = new StringTokenizer(sig, " ");
            int casos = Integer.parseInt(st.nextToken());
            for (int i = 0; i < casos; i++) {
                int aux = Integer.parseInt(st.nextToken());
                boolean[] visitados = new boolean[vertices + 1];
                Queue<Integer> cola = new LinkedList<>();

                cola.add(aux);
                while (cola.size() > 0) {
                    Integer pop = cola.remove();
                    if(graf[pop].isEmpty()) continue;
                    for (Integer k : graf[pop]) {
                        if (!visitados[k]) {
                            cola.add(k);
                            visitados[k] = true;
                        }
                    }
                }
                ArrayList<Integer> novisit = new ArrayList<>();
                for (int p = 1; p <= vertices; p++) {
                    if (!visitados[p]) novisit.add(p);
                }
                int lo = novisit.size();
                if(lo==0){
                    System.out.println(0);
                }else{
                    String am = novisit.toString().replaceAll("\\p{P}", "");
                    System.out.println(lo + " " + am);
                }

            }
            vertices = Integer.parseInt(in.readLine());
        }
    }
}
