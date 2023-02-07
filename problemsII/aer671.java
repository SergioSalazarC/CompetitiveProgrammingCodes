import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class aer671 {

    public static class Suceso implements Comparable{
        int time;
        boolean entra;

        public Suceso(int time, boolean entra) {
            this.time = time;
            this.entra = entra;
        }

        @Override
        public int compareTo(Object o) {
            Suceso i = (Suceso) o;
            if(this.time==i.time){
                if(!this.entra)return -1;
                else return 1;
            }
            return this.time-i.time;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        while(n!=0){
            LinkedList<Suceso> l = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                int a = in.nextInt();
                int b = in.nextInt();
                l.add(new Suceso(a,true));
                l.add(new Suceso(b,false));
            }

            int mejor=0;
            int cantmejor=0;
            int actual=0;
            int last=0;

            Collections.sort(l);

            for(Suceso s : l){
                if(s.entra){
                    actual++;
                    last = s.time;
                }
                else{
                    if(actual>mejor){
                        mejor=actual;
                        cantmejor=s.time-last;
                    }
                    else if(actual==mejor){
                        cantmejor+=s.time-last;
                    }
                    actual--;
                }
            }
            System.out.println(mejor+" "+cantmejor);
            n = in.nextInt();
        }




    }
}