import java.util.Scanner;
public class main {
    public static boolean rec(boolean[] memo,boolean[] comprobado,int n){
        boolean aux;
        if(comprobado[n]==false){
            comprobado[n]=true;
            if(n%3==0){
                memo[n]=(rec(memo,comprobado,n-5) || rec(memo,comprobado,n/3));
                aux=memo[n];
            }else{
                memo[n]=rec(memo,comprobado,n-5);
                aux=memo[n];
            }

        }else{
            aux=memo[n];
        }
        return(aux);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
            int n=in.nextInt();
            boolean[] memo= new boolean[200001];
            boolean[] comprobado = new boolean[200001];
            memo[1]=true;
            memo[3]=true;
            comprobado[1]=true;
            comprobado[2]=true;
            comprobado[3]=true;
            comprobado[4]=true;
            comprobado[5]=true;
            while(n!=0){
                boolean p=rec(memo,comprobado,n);
                if (p){
                    System.out.println("SI");
                }else{
                    System.out.println("NO");
                }
                n=in.nextInt();
            }
    }
}