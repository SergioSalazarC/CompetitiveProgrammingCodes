import java.util.Scanner;

public class aer672 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            int n = in.nextInt();
            long sum = 0;
            long max = 0;
            for (int i = 0; i < n; i++) {
                long x = in.nextLong();
                sum+=x;
                max=Math.max(x,max);
            }
            sum-=max;
            if(max>sum){
                long sol = 2*max;
                System.out.println(sol);
            }
            else{
                long sol=sum+max;
                System.out.println(sol);
            }
        }
    }
}
