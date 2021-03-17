package javaapplication2;

import java.util.Scanner;

/**
 *
 * @author Sergio
 */
public class JavaApplication2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        int total=0;
        for (int i=0;i<x;i++){
            int aux=in.nextInt();
            int a=in.nextInt();
            int b=in.nextInt();
            for (int z=0;z<aux;z++){
                total=total+a;
                a=a-b;
            }
            System.out.println(total);
            total=0;
        }
    }
    
}