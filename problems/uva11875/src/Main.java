import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        for(int i=1;i<=x;i++){
            int a =in.nextInt();
            int b = (a/2)+1;
            for(int j=1;j<=a;j++){
                int aux= in.nextInt();
                if (j==b){
                    System.out.println("Case "+i+": "+aux);
                }
            }
        }
    }
}
