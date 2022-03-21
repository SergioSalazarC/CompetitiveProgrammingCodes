import java.util.Scanner;

public class cf1638B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i=0;i<n;i++){
            int s = in.nextInt();
            int par=-1;
            int impar=-1;
            boolean correcto=true;
            for(int j=0;j<s;j++){
                int aux= in.nextInt();
                if(aux%2==0){
                    if(par<=aux) par=aux;
                    else correcto=false;
                }
                if(aux%2==1){
                    if(impar<=aux) impar=aux;
                    else correcto=false;
                }
            }
            if(correcto) System.out.println("Yes");
            else System.out.println("No");
        }
    }
}
