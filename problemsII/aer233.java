import java.util.Scanner;

public class aer233 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        while(n!=0){
            int aux=n;
            StringBuilder sb = new StringBuilder();
            while(aux!=0){
                if(aux>9){
                    sb.append("9");
                    aux-=9;
                }
                else{
                    sb.append(aux);
                    aux=0;
                }
            }
            System.out.println(sb.reverse());
            n=in.nextInt();
        }


    }
}