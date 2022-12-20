import java.util.*;

public class aer647 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int casos = in.nextInt();
        while(casos-->0){
            int size = in.nextInt();
            int[] mem = new int[size];
            //Numero aparecido -- Ultima aparicion
            HashMap<Integer,Integer> rep = new HashMap<>();
            int max = -1;
            int first =0;
            int total = 0;
            for (int i = 0; i < size; i++) {
                int a = in.nextInt();
                if(rep.containsKey(a) && rep.get(a)>=first){
                    first=rep.get(a);
                    total = i-first;
                    rep.put(a,i);
                }
                else{
                    rep.put(a,i);
                    total++;
                }
                max=Math.max(max,total);
            }
            System.out.println(max);
        }
    }
}