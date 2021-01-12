import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine().trim());
        for(int i=0;i<t;i++){
            int n = Integer.parseInt(in.readLine().trim());
            int uno=0;
            int dos=0;
            StringTokenizer st = new StringTokenizer(in.readLine()," ");
            for(int j=0;j<n;j++){
                if(Integer.parseInt(st.nextToken())==1) uno++;
                else dos++;
            }
            if(uno%2==0 && dos%2==0) System.out.println("YES");
            else if(dos%2==1 && uno%2==0 && uno>=2) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
