import java.io.PrintWriter;
import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        PrintWriter pw = new PrintWriter(System.out);

        for (int p = 0; p < n; p++) {
            int nodos = in.nextInt();
            int aristas = in.nextInt();
            ArrayList<Integer>[] grafo = new ArrayList[nodos];
            for(int j=0; j<nodos; j++){
                grafo[j]=new ArrayList<>();
            }
            for (int i = 0; i < aristas; i++) {
                int a = in.nextInt() - 1;
                int b = in.nextInt() - 1;
                grafo[a].add(b);
                grafo[b].add(a);
            }
            boolean[] visitados = new boolean[nodos];
            int maximo = 0;
            for (int r = 0; r < nodos; r++) {
                if (!visitados[r]) {
                    int inicial=r;
                    Queue<Integer> cola = new LinkedList<>();
                    cola.add(inicial);
                    int contador = 1;
                    visitados[inicial] = true;
                    while (cola.size() > 0) {
                        Integer pop = cola.remove();
                        for (int i = 0; i < grafo[pop].size(); i++) {
                            int aux = grafo[pop].get(i);
                            if (!visitados[aux]) {
                                cola.add(aux);
                                visitados[aux] = true;
                                contador++;
                            }
                        }

                    }
                    maximo = Math.max(maximo, contador);
                }
            }
            pw.println(maximo);
        }
        pw.flush();
        pw.close();
    }
}