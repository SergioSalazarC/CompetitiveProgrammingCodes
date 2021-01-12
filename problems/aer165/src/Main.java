import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        while(n>=0){
            boolean a = true;
            while(n!=0 && a){
                if(n%2==1){
                    a=false;
                }else{
                    n = n/10;
                }
            }
            if(a) System.out.println("SI");
            else System.out.println("NO");
            n=in.nextInt();
        }
    }
}
