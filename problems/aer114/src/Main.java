import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a=in.nextInt();
        for(int i =0;i<a;i++){
            int dig = in.nextInt();
            if(dig>=5) System.out.println(0);
            else if(dig==0||dig==1) System.out.println(1);
            else if(dig==2) System.out.println(2);
            else if(dig==3) System.out.println(6);
            else if(dig==4) System.out.println(4);
        }

    }
}
