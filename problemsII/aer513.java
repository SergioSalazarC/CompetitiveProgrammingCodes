import java.util.Scanner;

public class aer513 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n=in.nextInt();
            StringBuilder sb = new StringBuilder();
            long acum=0;
            for(int i=1;i<=n;i++){
                long s = in.nextLong();
                long m = i*s-acum;
                sb.append(m+" ");
                acum+=m;
            }
            System.out.println(sb.toString().trim());
        }
    }
}