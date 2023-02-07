import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

public class aer252 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String caso = in.readLine();
        while (!caso.equals("XXX")){
            caso=caso.toLowerCase();
            caso=caso.replace(" ","");
            StringBuilder a = new StringBuilder(caso);
            StringBuilder b = new StringBuilder(caso).reverse();
            if(a.toString().equals(b.toString())) System.out.println("SI");
            else System.out.println("NO");
            caso = in.readLine();
        }
    }
}
