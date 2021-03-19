import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b=in.nextInt();
        int c=in.nextInt();

        while(!(a==0 && b==0 && c==0)){
            int s =b+c;
            if(s<=a){
                System.out.println(s);
            }else{
                int aux=s-a;
                s=a-aux;
                System.out.println(s);
            }

            a = in.nextInt();
            b=in.nextInt();
            c=in.nextInt();
        }
    }
}