import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new
                Scanner(System.in);
        String elemento = in.next();
        int[] cantidad = {2,2,6,2,6,2,10,6,2,10,6,2,14,10,6,2,14,10,6};
        String[]electrones = {"1s","2s","2p","3s","3p","4s","3d","4p","5s","4d","5p","6s","4f","5d","6p","7s","5f","6d","7p"};

        while (!elemento.equals("Exit")){
            int x = in.nextInt();
            int vueltas = 0;
            while(x>=0){
                if(x==0){
                    System.out.println("1s0");
                    x = -1;
                }else if (x<=cantidad[vueltas]){
                    System.out.println(electrones[vueltas] + x);
                    x= -1;
                }else {
                    System.out.print(electrones[vueltas] + cantidad[vueltas] + ' ');
                    x=x-cantidad[vueltas];
                    vueltas=vueltas+1;
                }

            }

            elemento = in.next();
        }

    }
}