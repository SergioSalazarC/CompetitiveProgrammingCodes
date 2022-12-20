import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class aer510 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        while(n!=0){
            boolean[] signo = new boolean[n];
            LinkedList<Integer> positivos = new LinkedList<>();
            LinkedList<Integer> negativos = new LinkedList<>();
            for(int i=0;i<n;i++){
                int k = in.nextInt();
                if(k>0){
                    signo[i]=true;
                    positivos.add(k);
                }
                else{
                    signo[i]=false;
                    negativos.add(k);
                }
            }
            Collections.sort(positivos);
            Collections.sort(negativos,Collections.reverseOrder());
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<n;i++){
                if(signo[i]){
                    int aux = positivos.removeFirst();
                    sb.append(aux+" ");
                }
                else{
                    int aux = negativos.removeFirst();
                    sb.append(aux+" ");
                }
            }
            System.out.println(sb.toString().trim());
            n=in.nextInt();
        }


    }
}