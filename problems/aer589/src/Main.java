import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        long n= in.nextLong();
        while(n!=0){
            long cont=0;
            long max=in.nextLong();
            for(int i=0;i<n-1;i++){
                long aux= in.nextLong();
                if(aux>max){
                    long extr=aux-max;
                    cont = cont + (extr*(i+1));
                    max=aux;
                }else{
                    cont = cont + (max-aux);
                }
            }
            System.out.println(cont);
            n=in.nextLong();
        }
    }
}
