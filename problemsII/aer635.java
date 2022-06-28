import java.util.Scanner;

public class aer635 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        while(n-->0){
            int a = in .nextInt();
            int s = ((a-a%100)/100)+1;
            if(a%100==0) s--;
            System.out.println(s);
        }
    }
}
