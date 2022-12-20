import java.util.Scanner;

public class aer369 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        while(n!=0){
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<n;i++){
                sb.append(1);
            }
            System.out.println(sb);
            n=in.nextInt();
        }
    }
}