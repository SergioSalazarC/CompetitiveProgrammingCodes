import java.util.Scanner;

public class aer608 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        while(n!=0){
            int veces=0;
            boolean suena=false;
            for(int i=0;i<n;i++){
                int aux=in.nextInt();
                if(!suena){
                    if(aux<=4){
                        veces++;
                        suena=true;
                    }
                }
                else{
                    if(aux>=7) suena=false;
                }
            }
            System.out.println(veces);
            n=in.nextInt();
        }

    }
}
