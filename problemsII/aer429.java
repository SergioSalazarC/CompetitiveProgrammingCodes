import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class aer429 {
    public static class Numero implements Comparable{
        int a;

        public Numero(int a) {
            this.a = a;
        }

        @Override
        public int compareTo(Object o) {
            Numero i = (Numero) o;
            return i.a-this.a;
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        while(n!=0){

            PriorityQueue<Numero> pq = new PriorityQueue<>();
            for (int i = 0; i < n; i++) {
                pq.add(new Numero(in.nextInt()));
            }
            int m = in.nextInt();
            boolean solucion = true;
            for (int i = 0; i < m; i++) {
                int a = in.nextInt();
                if(solucion){
                    if(pq.isEmpty()){
                        solucion=false;
                        continue;
                    }
                    int angar = pq.remove().a;
                    if(angar>=a)pq.add(new Numero(angar-a));
                    else solucion=false;
                }

            }
            if(solucion) System.out.println("SI");
            else System.out.println("NO");

            n=in.nextInt();
        }

    }
}
