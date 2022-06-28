import java.util.Scanner;

public class cf1642A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int casos = in.nextInt();
        while(casos-->0){
            int a1=in.nextInt();
            int a2=in.nextInt();
            int b1=in.nextInt();
            int b2=in.nextInt();
            int c1=in.nextInt();
            int c2=in.nextInt();
            if(a2==b2){
                if(a2==0 || c2>a2){
                    System.out.println(0);
                }
                else{
                    System.out.println(Math.abs(a1-b1));
                }
            }
            else if(b2==c2){
                if(b2==0 || a2>b2){
                    System.out.println(0);
                }
                else{
                    System.out.println(Math.abs(c1-b1));
                }
            }
            else if(a2==c2){
                if(c2==0 || b2> c2){
                    System.out.println(0);
                }
                else{
                    System.out.println(Math.abs(c1-a1));
                }
            }
            else{
                System.out.println(0);
            }
        }
    }
}
