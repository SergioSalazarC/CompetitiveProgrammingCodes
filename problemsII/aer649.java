import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.TreeSet;

public class aer649 {
    public static class Tarea implements Comparable{
        long inicio;
        long fin;
        long repe;

        public Tarea(long inicio, long fin, long repe) {
            this.inicio = inicio;
            this.fin = fin;
            this.repe = repe;
        }




        @Override
        public int compareTo(Object o) {
            Tarea i = (Tarea) o;

            if(inicio==i.inicio){
                return (int) (this.fin-i.fin);
            }
            else{
                return (int) (this.inicio-i.inicio);
            }
        }
    }

    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        while(in.hasNext()){
            long n = in.nextLong();
            long m = in.nextLong();
            long t = in.nextLong()-1;

            PriorityQueue<Tarea> pq = new PriorityQueue();
            for (int i = 0; i < n; i++) {
                int a = in.nextInt();
                int b = in.nextInt()-1;
                pq.add(new Tarea(a,Math.min(b,t),0));
            }

            for (int i = 0; i < m; i++) {
                int a = in.nextInt();
                int b = in.nextInt()-1;
                int c = in.nextInt();
                pq.add(new Tarea(a,Math.min(b,t),c));
            }

            boolean bien=true;
            Tarea actual;
            long fin=-1;

            while(!pq.isEmpty() && bien){
                actual=pq.remove();
                if(actual.inicio<=fin){
                    bien=false;
                    break;

                }
                fin=actual.fin;
                if(actual.repe!=0){
                    if(actual.inicio + actual.repe <= t){
                        pq.add(new Tarea(actual.inicio+actual.repe, Math.min(actual.fin+actual.repe,t),actual.repe));
                    }
                }
            }

            if(bien) System.out.println("NO");
            else System.out.println("SI");
        }

    }
}
