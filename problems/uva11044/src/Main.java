import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(in.readLine());
        for(int i =0;i<n;i++){
            StringTokenizer st = new StringTokenizer(in.readLine()," ");
            int a= Integer.parseInt(st.nextToken())/3;
            int b= Integer.parseInt(st.nextToken())/3;
            int c=a*b;
            System.out.println(c);
        }
    }
}
