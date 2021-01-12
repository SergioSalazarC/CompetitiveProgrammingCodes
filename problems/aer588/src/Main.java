import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        long n=Long.parseLong(in.readLine(),10);
        //System.out.println(n);
        while(n!=0){
            String base = Long.toString(n,2);
            //System.out.println(base);
            int i=0;
            int j=base.length()-1;
            boolean fin=false;
            while((i<j)&&!fin){
                if(i==0 && base.charAt(j)=='0'){
                    j--;
                }else{
                    if(base.charAt(i)==base.charAt(j)){
                        i++;
                        j--;
                    }else{
                        fin=true;
                    }
                }
            }

            if(fin) System.out.println("NO");
            else System.out.println("SI");
            n=Long.parseLong(in.readLine(),10);
        }
    }
}
