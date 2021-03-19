import java.util.Scanner;
public class main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int i=in.nextInt();
        while(i!=0){
            if(i%9==0) System.out.println("SI");
            else System.out.println("NO");
            i=in.nextInt();
        }
    }
}