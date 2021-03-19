package javaapplication3;

import java.util.Scanner;
public class JavaApplication3 {    
    public static void main(String[] args) {
        Scanner in =  new Scanner(System.in);
        int diasusados=0;
        int k= in.nextInt();
        while(k!=0){
            for(int i=0;i<k;i++){
                int n= in.nextInt();
                int p=in.nextInt();
                if(diasusados<n){
                    diasusados=n;
                }else{
                    int aux= (diasusados-n)%p;
                    diasusados=diasusados+(p-aux);
                }
            }
            System.out.println(diasusados);
            diasusados=0;
            k=in.nextInt();
        }        
    }   
}