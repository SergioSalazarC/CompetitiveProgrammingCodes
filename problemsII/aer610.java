import java.util.Scanner;

public class aer610 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int casos = in.nextInt();
        while(casos-->0){
            int n=in.nextInt();
            int s=in.nextInt();
            int p=in.nextInt();
            int k=in.nextInt();
            boolean[] check = new boolean[n];
            int mitad=n/2;
            if(n%2==1) mitad++;
            int actual=0;
            for(int i=0;i<mitad;i++){
                for(int j=0;j<k+1;j++){
                    actual=(actual+1)%n;
                    if (check[actual]) j--;
                }
                check[actual]=true;
            }
            if(check[s%n] == check[p%n]) System.out.println("No hay abrazo");
            else if(check[s%n]) System.out.println("No quiero irme, Peter!");
            else if(check[p%n]) System.out.println("No quiero irme, Sr. Stark!");
        }
    }
}