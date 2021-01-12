import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    
    
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine().trim());
        for(int i=0;i<t;i++){
            StringTokenizer st = new StringTokenizer(in.readLine()," ");
            int w=Integer.parseInt(st.nextToken());
            int h=Integer.parseInt(st.nextToken());
            int n=Integer.parseInt(st.nextToken());
            int sal=1;
            while(sal < n && (w%2==0 || h%2==0)){
                if(w%2==0){
                    w/=2;
                    sal*=2;
                }
                if(h%2==0){
                    h/=2;
                    sal*=2;
                }
            }
            if(sal>=n) System.out.println("YES");
            else System.out.println("NO");
        }
        
    }
}
