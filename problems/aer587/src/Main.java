import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(in.readLine());
        for(int i=0;i<n;i++){
            String k = in.readLine();
            int l = k.length();
            int cont=l/2;
            for(int j=0;j<l/2;j++){
                if(k.charAt(j*2)==k.charAt((j*2)+1)) cont++;
            }
            System.out.println(cont);
        }
    }
}
