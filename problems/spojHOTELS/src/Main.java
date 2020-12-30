import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine()," ");
        int n =Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        int[] v = new int[n];
        st = new StringTokenizer(in.readLine()," ");
        for(int i=0;i<n;i++){
            v[i]=Integer.parseInt(st.nextToken());
        }
        int curr=0;
        int ini=0;
        int fini=0;
        int max=0;
        while(!(fini==n && curr<m)){
            if(curr<m){
                curr+=v[fini];
                fini++;
            }else if(curr>m){
                curr-=v[ini];
                ini++;
            }else{
                max=m;
                break;
            }
            if(curr<=m){
                max=Math.max(max,curr);
            }
        }
        System.out.println(max);

    }
}
