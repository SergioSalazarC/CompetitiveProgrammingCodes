import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class aer392 {
    static int p=1;
    static int a=1;

    public static int recu(int[] posibles, HashSet<Integer> usados, int por_regalar){
        if(usados.size()==p) return 1;
        int sig = -1;
        for(int i=0;i<p;i++){
            if(i==por_regalar) continue;
            if(posibles[i]==-1){
                sig=i;
                break;
            }
        }
        int val=0;
        for(int i=0;i<p && val<2;i++){
            if(usados.contains(i))continue;
            if(por_regalar==i)continue;
            posibles[por_regalar]=i;
            usados.add(i);
            val+=recu(posibles,usados,sig);
            posibles[por_regalar]=-1;
            usados.remove(i);
        }
        return val;


    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        p = in.nextInt();
        a = in.nextInt();
        while(p!=0 || a!=0){

            int[] posibles = new int[p];
            Arrays.fill(posibles,-1);
            HashSet<Integer> regalados = new HashSet<>();

            for(int i=0;i<a;i++){
                int x = in.nextInt()-1;
                int y = in.nextInt()-1;
                regalados.add(y);
                posibles[x]=y;
            }

            int val = -1;
            for(int i=0;i<p;i++){
                if(posibles[i]==-1){
                    val=i;
                    break;
                }
            }
            int sol = recu(posibles,regalados,val);
            if(sol>1) System.out.println("NO");
            else System.out.println("SI");

            p = in.nextInt();
            a = in.nextInt();
        }
    }
}
