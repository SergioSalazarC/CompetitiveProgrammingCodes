import java.util.Scanner;

public class aer597 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int casos = in.nextInt();
        while(casos-->0){
            int p = in.nextInt();
            int[] personas =new int[p];
            for(int i=0;i<p;i++){
                personas[i]=in.nextInt();
            }
            int actual=Integer.MAX_VALUE;
            int cont=0;
            for(int i=p-1;i>=0;i--){
                int aux = personas[i];
                if(aux<actual){
                    actual=aux;
                }
                else{
                    cont++;
                }
            }
            System.out.println(cont);
        }
    }
}
