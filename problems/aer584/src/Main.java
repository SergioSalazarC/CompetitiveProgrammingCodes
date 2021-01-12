import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        for(int i=0;i<n;i++){
            int h=in.nextInt();
            int e=in.nextInt();
            int p=in.nextInt()*e;
            if(h>p){
                System.out.println("ENCENDIDOS");
            }else if(h<p){
                System.out.println("HORAS");
            }else{
                System.out.println("AMBAS");
            }
        }
    }
}
