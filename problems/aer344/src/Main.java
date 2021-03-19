import java.util.Scanner;

public class C {
    public static void main(String args[]) {
        Scanner in =new Scanner(System.in);
        int n=in.nextInt();
        for(int i=0;i<n;i++){
            int k=in.nextInt();
            int hembras=0;
            int machos=0;
            for(int j=0;j<k;j++){
                String aux=in.next();
                if(aux.charAt(0)=='H') hembras++;
                else machos++;
                if(aux.charAt(1)=='H') hembras++;
                else machos++;
            }
            if(hembras==machos) System.out.println("POSIBLE");
            else System.out.println("IMPOSIBLE");
        }
    }
}