import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        for(int i=0;i<a;i++){
            int c=in.nextInt()*in.nextInt();
            int t=in.nextInt();
            int auxx=t % c;
            int aux=0;
            if(auxx==0){
                aux=t/c;
            }else{
                aux=t/c+1;
            }
            System.out.println(aux);
        }
    }
}
