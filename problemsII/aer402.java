import java.io.*;
import java.util.*;

public class aer402 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        while(n!=0){
            int better=n;
            int resta=n;
            int aux = (int) Math.round(Math.sqrt(n));
            for(int i=1;i<=aux;i++){
                if(n%i==0){
                    int largo = n/i;
                    int menos=largo-i;
                    if(menos<=resta){
                        resta=menos;
                        better=largo;
                    }
                }
            }
            System.out.println(better);
            n=in.nextInt();
        }


    }
}