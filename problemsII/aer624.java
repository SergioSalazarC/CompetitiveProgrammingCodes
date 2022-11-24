import java.util.HashSet;
import java.util.Scanner;

public class aer624 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        while(n!=0){
            int sol=0;
            int act=0;
            HashSet<Integer> mem = new HashSet<>();
            for (int i = 0; i < n; i++) {
                int a = in.nextInt();
                if(mem.contains(a)){
                    act--;
                    mem.remove(a);
                }
                else{
                    mem.add(a);
                    act++;
                }
                sol = Math.max(sol,act);
            }
            System.out.println(sol);
            n= in.nextInt();
        }
    }
}
