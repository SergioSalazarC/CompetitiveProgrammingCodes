import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class aer364 {

    static String func(String x){
        String sol="";
        for(int i=0;i<x.length();i++){
            if(x.charAt(i)==' '){
                sol+=" ";
            }
            else if(x.charAt(i)=='Z'){
                sol+="A";
            }
            else{
                char m = (char) (x.charAt(i)+1);
                sol+=""+m;
            }
        }
        return sol;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String h=in.readLine();
        while(!h.equals("FIN")){
            System.out.println(func(h));
            h=in.readLine();
        }
    }
}