import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        for(int i=0;i<n;i++){
            int max=-1;
            int min=1000000000;
            int c=in.nextInt();
            for(int j=0;j<c;j++){
                int aux=in.nextInt();
                max=Math.max(max,aux);
                min=Math.min(min,aux);
            }
            int s= (max-min+1)-c;
            System.out.println(s);
        }
    }
}
