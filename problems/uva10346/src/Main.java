import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();
            int k = in.nextInt();

            int cig = n;
            int butts = n;

            while(butts>=k){
                butts-=(k-1);
                cig++;
            }

            System.out.println(cig);

        }
    }
}
