import java.text.DecimalFormat;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(new Locale("en","US"));
        DecimalFormat df = new DecimalFormat("#0.000");
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        for(int i=1;i<=n;i++){
            double d=in.nextDouble();
            double v=in.nextDouble();
            double u=in.nextDouble();

            double fast = d/u;
            double sh = Math.sqrt(u*u-v*v);
            if(v>=u|| u == 0 || v == 0){
                System.out.println("Case "+i+": can't determine");
            }else{
                sh = d/sh;
                String sol = df.format(sh-fast);

                System.out.println("Case "+i+": "+sol);
            }

        }
    }
}
