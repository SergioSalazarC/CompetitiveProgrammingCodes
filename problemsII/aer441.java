import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class aer441 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s = in.readLine();
        while(s!=null){
            s=s.replace(".","");
            BigInteger a = new BigInteger(s);
            a = a.add(BigInteger.ONE);
            s = a.toString();
            StringBuilder aux = new StringBuilder(s).reverse();
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= s.length(); i++) {
                sb.append(aux.charAt(i-1));
                if(i%3==0 && i!=s.length())sb.append(".");
            }
            sb.reverse();
            System.out.println(sb.toString());
            s = in.readLine();
        }

    }
}
