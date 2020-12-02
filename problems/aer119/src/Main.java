import java.util.Scanner;

public class Main {
    public static int reducir(int t){
        if(t==1){
            return(5);
        }
        if(t==0){
            return(0);
        }
        int lado=1;
        while(true){
            if(t>=lado*lado){
                lado+=1;
            }else{
                break;
            }
        }
        lado--;
        t-=lado*lado;
        int aux=lado*lado+4*lado+reducir(t);
        return(aux);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int sold=in.nextInt();
        while(sold!=0){
            int escudos=reducir(sold);
            System.out.println(escudos);
            sold=in.nextInt();
        }

    }
}
