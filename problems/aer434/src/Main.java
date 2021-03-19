package javaapplication1;

import java.util.Scanner;

public class JavaApplication1 {

    public static void main(String[] args) {
        Scanner in=  new Scanner(System.in);
        int h=in.nextInt();
        for(int i=0;i<h;i++){
            int a=in.nextInt();
            int b=in.nextInt();
            if(a<=b){
                System.out.println("ROMANCE");
            }else{
                System.out.println("PRINCIPIO");
            }
        }
    }
    
}