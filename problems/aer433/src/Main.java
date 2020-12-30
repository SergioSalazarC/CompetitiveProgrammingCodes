import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] aux = new int[1430];
        for(int i=0;i<1430;i++){
            int u=i*(i+1)/2;
            aux[i]=u;
        }

        Scanner in=new Scanner(System.in);
        int u=in.nextInt();
        while(u!=0){
            int s=0;
            while(true){
                s++;
                if(aux[s]>=u){
                    break;
                }
            }
            System.out.println(s);
            u=in.nextInt();
        }



    }
}
