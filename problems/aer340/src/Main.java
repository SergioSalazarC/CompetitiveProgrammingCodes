import java.util.Scanner;

public class C {
    public static void main(String args[]) {
        Scanner in =new Scanner(System.in);
        int n= in.nextInt();
        for(int i=0;i<n;i++){
            int a=in.nextInt();
            int b=in.nextInt();
            int c=4+3*(a-1)+3*(b-1)+(a-1)*(b-1)*2;
            System.out.println(c);
        }
    }
}