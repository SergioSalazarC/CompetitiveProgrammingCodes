import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class aer368 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int h=in.nextInt();
        int c=in.nextInt();
        while(h!=0 && c!=0){
            int sol = (h/c)+1;
            if(h%c==0) sol--;
            sol*=10;
            System.out.println(sol);
            h=in.nextInt();
            c=in.nextInt();
        }


    }
}