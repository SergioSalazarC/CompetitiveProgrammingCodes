import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int m=Integer.parseInt(in.readLine());
        for(int q=0;q<m;q++) {
            int n = Integer.parseInt(in.readLine());
            int[] rojos = new int[n];
            int[] azules =new int[n];
            for (int i = 0; i < n - 1; i++) {
                StringTokenizer st = new StringTokenizer(in.readLine(), " ");
                for (int j = i+1; j < n; j++) {
                    if(Integer.parseInt(st.nextToken())==0){
                        rojos[i]++;
                        rojos[j]++;
                    }else{
                        azules[i]++;
                        azules[j]++;
                    }
                }
            }
            int total=n*(n-1)*(n-2)/6;
            int notri=0;
            for(int k=0;k<n;k++){
                notri+=rojos[k]*azules[k];
            }
            notri/=2;
            total-=notri;
            System.out.println(total);
        }
    }
}
