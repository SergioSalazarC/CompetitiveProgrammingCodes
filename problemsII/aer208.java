import java.util.Scanner;

public class aer208 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long f=in.nextLong();
        long b=in.nextLong();
        while(f!=0 && b!=0){
            b=f-b+1;
            f=(f*(f+1))/2;
            b=(b*(b+1))/2;
            System.out.println(f-b);
            f=in.nextLong();
            b=in.nextLong();
        }


    }
}
