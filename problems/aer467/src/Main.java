import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int a=Integer.parseInt(in.readLine().trim());
        for(int i=0;i<a;i++){
            StringTokenizer st =new StringTokenizer(in.readLine()," ");
            String a1= st.nextToken().toLowerCase();
            st.nextToken();
            String b1=st.nextToken().toLowerCase();
            if(a1.equals(b1)) System.out.println("TAUTOLOGIA");
            else System.out.println("NO TAUTOLOGIA");
        }
    }
}
