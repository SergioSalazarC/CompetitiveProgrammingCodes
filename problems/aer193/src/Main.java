import java.util.Scanner;
public class main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        while(n!=0){
            if(n%10==0){
                System.out.println("NO");
            }else{
                int aux=n;
                int invertido=0;
                int resto;
                while(aux>0){
                    resto=aux%10;
                    invertido=invertido*10+resto;
                    aux /=10;
                }
                n=n+invertido;
                aux=n;
                boolean salida=true;
                while(aux>0 && salida){
                    int digito= aux%10;
                    salida=salida && (digito%2==1);
                    aux /=10;
                }
                if(salida) System.out.println("SI");
                else System.out.println("NO");

            }
            n=in.nextInt();
        }
    }

}