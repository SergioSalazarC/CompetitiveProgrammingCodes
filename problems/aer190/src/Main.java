import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        long x = in.nextInt();
        long y = in.nextInt();
        long aux=1;
        while(x>=y){
            if(x==y){
                System.out.println(1);
            }else{
                for(long j=y+1;j<=x;j++){
                    aux=aux*j;
                }
                System.out.println(aux);
            }
            aux=1;
            x=in.nextInt();
            y=in.nextInt();
        }
    }
}