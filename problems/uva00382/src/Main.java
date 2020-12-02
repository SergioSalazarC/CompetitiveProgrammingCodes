import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        System.out.println("PERFECTION OUTPUT");
        while(a!=0){
            int b = (a+2)/2;
            HashSet<Integer> div = new HashSet<>();
            for(int i=1;i<=b;i++){
                if(a%i==0){
                    div.add(i);
                    div.add(a/i);
                }
            }
            div.remove(a);
            int total=0;
            for(Integer m : div){
                total+=m;
            }
            String aux = Integer.toString(a);
            int l = aux.length();
            for(int i=l;l<5;l++){
                System.out.print(" ");
            }

            if (total == a) System.out.println(a+"  PERFECT");
            if (total > a) System.out.println(a+"  ABUNDANT");
            if (total < a) System.out.println(a+"  DEFICIENT");
            a=in.nextInt();
        }
        System.out.println("END OF OUTPUT");
    }
}
