import java.util.Scanner;
public class main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n1= in.nextInt();
        for (int x=0;x<n1;x++){
            int aux  = in.nextInt()*in.nextInt();
            if(aux%2==0){
                aux=aux/2;
                System.out.println(aux+" "+aux);
            }else{
                aux=(int)Math.floor(aux/2);
                int aus=aux+1;
                System.out.println(aus+" "+aux);
            }
        }

    }
}