import java.util.*;

public class aer396 {
    public static class ins implements Comparable{
        int inicial;
        int partido;
        int valor;

        public ins(int inicial, int partido, int valor) {
            this.inicial = inicial;
            this.partido = partido;
            this.valor = valor;
        }

        @Override
        public int compareTo(Object o) {
            ins i = (ins) o;
            return i.valor-this.valor;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int p = in.nextInt();
            int m = in.nextInt();

            PriorityQueue<ins> pq = new PriorityQueue(10);
            for (int i = 0; i < m; i++) {
                int aux=in.nextInt();
                pq.add(new ins(aux,1,aux));
            }
            p -= m;
            for (int i = 0; i < p; i++) {
                ins k = pq.poll();
                k.partido++;
                if(k.inicial%k.partido==0){
                    k.valor=k.inicial/k.partido;
                }
                else{
                    k.valor=k.inicial/k.partido+1;
                }
                pq.add(k);
            }

            System.out.println(pq.poll().valor);
        }
    }


}