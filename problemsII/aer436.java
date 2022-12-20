import java.util.Scanner;

public class aer436 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            long n=in.nextInt();
            long m=in.nextInt();
            m=m*1000000;
            int i=0;
            while(n<m){
                i++;
                n*=2;
            }
            System.out.println(i);
        }
    }
}