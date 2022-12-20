import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class aer564 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int s = Integer.parseInt(in.readLine());
        for(int i=0;i<s;i++){
            System.out.println(Integer.parseInt(in.readLine())/3);
        }
    }
}