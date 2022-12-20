import java.util.Scanner;

public class aer611 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int yr = in.nextInt();
            String nombre=in.nextLine();
            int obras = in.nextInt();
            int min=1000000000;
            String obra="";
            int cont=0;
            for(int i=0;i<obras;i++){
                int ano = in.nextInt();
                String aux = in.nextLine().trim();
                if(yr<=ano) cont++;
                if(yr<=ano && ano<min){
                    min=ano;
                    obra=aux;
                }
            }
            if(min==1000000000) System.out.println("NINGUNA");
            else if(cont==obras) System.out.println("TODAS");
            else System.out.println(obra);
        }
    }
}