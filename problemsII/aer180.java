import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class aer180 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i=0;i<n;i++){
            ArrayList<Integer> al = new ArrayList<>();
            al.add(in.nextInt());
            al.add(in.nextInt());
            al.add(in.nextInt());
            Collections.sort(al);
            int min=al.get(0);
            int med=al.get(1);
            int max=al.get(2);
            if(min+med>max){
                if(min*min+med*med>max*max) System.out.println("ACUTANGULO");
                if(min*min+med*med==max*max) System.out.println("RECTANGULO");
                if(min*min+med*med<max*max) System.out.println("OBTUSANGULO");
            }
            else System.out.println("IMPOSIBLE");

        }
    }
}
