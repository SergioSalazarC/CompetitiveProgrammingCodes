import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class aer247 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        while(n!=0){
            boolean flag=true;
            StringTokenizer st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken());
            while(st.hasMoreElements()){
                int b = Integer.parseInt(st.nextToken());
                if(b>a) a=b;
                else{
                    flag=false;
                    break;
                }
            }
            if(flag) System.out.println("SI");
            else System.out.println("NO");
            n = Integer.parseInt(in.readLine());
        }
    }
}
