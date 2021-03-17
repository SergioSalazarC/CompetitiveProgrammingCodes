import java.util.Scanner;
public class JavaApplication2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        for(int i=0;i<x;i++){
            int y=in.nextInt();
            int aux=0;
            for(int j=0;j<y;j++){
                if(in.nextInt()%2==0) aux++;
            }
            System.out.println(aux);
        }
    }    
}