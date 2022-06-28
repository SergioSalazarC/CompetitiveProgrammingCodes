import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class aer641 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int v = in.nextInt();
        int s= in.nextInt();
        while(s!=0 && v!=0){
            Queue<Integer> cola = new LinkedList<>();
            int rest = s-v;
            long max;
            long actual = 0;
            int memos=0;
            for(int i=0;i<v;i++){
                int aux=in.nextInt();
                actual+=aux;
                if(memos<=rest){
                    cola.add(aux);
                    memos++;
                }
            }
            max=actual;
            for(int i=0;i<rest;i++){
                int aux = in.nextInt();
                actual-=cola.remove();
                actual+=aux;
                if(memos<=rest){
                    cola.add(aux);
                    memos++;
                }
                max=Math.max(max,actual);
            }
            System.out.println(max);
            v = in.nextInt();
            s= in.nextInt();
        }


    }
}
