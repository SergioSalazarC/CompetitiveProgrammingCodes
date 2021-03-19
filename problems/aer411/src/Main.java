import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int ts = in.nextInt();
        while(ts!=0){
            int total=0;
            int cont=0;
            boolean tam=true;
            while(true){
                int q =in.nextInt();
                if(q==0){
                    break;
                }
                if(total+q>ts){
                    tam=false;
                    break;
                }
                total+=q;
                cont++;
            }
            if(!tam){
                while(true){
                    if(in.nextInt()==0)break;
                }
            }

            System.out.println(cont);
            ts = in.nextInt();

        }
    }
}