package primer;

import java.util.Scanner;

public class Primer {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); 
        int k = in.nextInt();
        int cont = 0;
        boolean aparimp = false;
        boolean alaputa = false;
        for (int t=1;t<=k;t++){
           int n = in.nextInt();
           for (int s=1;s<=n;s++){
               int p = in.nextInt();
               if (p%2==0 && aparimp==false){
                   cont++;
               }else if (p%2==1 && aparimp == false){
                   aparimp = true;
               }else if (p%2==0 && aparimp==true){
                   alaputa = true;
               }
               
           }
        if (alaputa == true){
            System.out.println("NO");
        }else {
            System.out.println("SI " + cont);
        }
        aparimp = false;
        alaputa = false;
        cont = 0;
        }
    }      
}