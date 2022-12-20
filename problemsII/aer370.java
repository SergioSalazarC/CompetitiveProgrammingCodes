import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class aer370 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int s = Integer.parseInt(in.readLine());
        for(int i=0;i<s;i++){
            StringTokenizer st = new StringTokenizer(in.readLine(), "-");
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            if((b-1==a && a%2==0)||(a-1==b && b%2==0)){
                System.out.println("SI");
            }else{
                System.out.println("NO");
            }

        }

    }
}