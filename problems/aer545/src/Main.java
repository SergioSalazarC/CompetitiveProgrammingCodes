import java.util.Scanner;

public class Fuerzas {
    public static void main (String[]Args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int d= in.nextInt();
            int n = in.nextInt();
            int min=2000000000;
            int vact=0;
            for(int i=0; i<n; i++){
                int k=in.nextInt();
                int s=in.nextInt();
                int cal=0;
                if (k>=0){
                    cal=k+d/s;
                    min=Math.min(min,cal);
                }
            }
            System.out.println(min);
        }
    }
}