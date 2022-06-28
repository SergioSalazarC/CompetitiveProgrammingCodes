import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class aer605 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String h = in.readLine();
        while(!".".equals(h.trim())){
            StringTokenizer st = new StringTokenizer(h," ");
            int v=0;
            int i=0;
            while(st.hasMoreElements()){
                String m = st.nextToken();
                if(m.charAt(0)=='V') v++;
                if(m.charAt(0)=='I') i++;
            }
            if(v>i) System.out.println("VERANO");
            if(i>v) System.out.println("INVIERNO");
            if(i==v) System.out.println("EMPATE");
            h = in.readLine();

        }

    }
}
