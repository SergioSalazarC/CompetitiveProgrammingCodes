import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        for(int i=0;i<n;i++){
            int t=in.nextInt();
            int max=0;
            int min=10000;
            for(int j=0;j<t;j++){
                int aux=in.nextInt();
                max=Math.max(max,aux);
                min=Math.min(min,aux);
            }
            int sol=(max-min);
            sol*=2;
            System.out.println(sol);
        }
    }
}
