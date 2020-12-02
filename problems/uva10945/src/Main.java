import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String fr = in.readLine();
        while(!fr.equals("DONE")){

            fr=fr.replaceAll(" ","");
            fr=fr.replaceAll("[.]","");
            fr=fr.replaceAll(",","");
            fr=fr.replaceAll("!","");
            fr=fr.replaceAll("[?]","");

            fr=fr.toLowerCase();

            int inc = 0;
            int des = fr.length()-1;
            boolean s = false;

            while ((inc<des) && (!s)){
                if (fr.charAt(inc)==fr.charAt(des)){
                    inc++;
                    des--;
                } else {
                    s = true;
                }
            }

            if(s) System.out.println("Uh oh..");
            else System.out.println("You won't be eaten!");

            fr=in.readLine();





        }
    }
}
