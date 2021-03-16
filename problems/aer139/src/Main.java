import java.util.HashSet;
import java.util.Scanner;

public class Main2 {
    public static String cubifinito(int x , HashSet<Integer> almacen){
        almacen.add(x);
        int aux=x;
        int acumulado=0;
        while(aux>0){
            acumulado= acumulado+ (int) Math.pow(aux%10,3);
            aux/=10;
        }
        if (acumulado==1 || almacen.contains(acumulado) || acumulado==x) return(x + " - "+acumulado+" ");
        else{
            return (x+ " - " +cubifinito(acumulado,almacen));
        }

    }

    public static void main(String[] Args) {
        Scanner in = new Scanner(System.in);
        int n =in.nextInt();
        while(n!=0){
            HashSet<Integer> almacen = new HashSet<>();
            if(n==1){
                System.out.println("1 -> cubifinito.");
            }else{
                String sol= cubifinito(n,almacen);
                if(sol.charAt(sol.length()-2)=='1' && sol.charAt(sol.length()-3)==' '){
                    System.out.println(sol+"-> cubifinito.");
                }else{
                    System.out.println(sol+"-> no cubifinito.");
                }
            }

            n=in.nextInt();
        }


    }
}