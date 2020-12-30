import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t =Integer.parseInt(in.readLine().trim());
        for(int c=0;c<t;c++){
            int n = Integer.parseInt(in.readLine().trim());
            ArrayList<Integer> b = new ArrayList();
            ArrayList<Integer> g = new ArrayList();
            StringTokenizer stb= new StringTokenizer(in.readLine()," ");
            StringTokenizer stg = new StringTokenizer(in.readLine()," ");
            for(int m=0;m<n;m++){
                b.add(Integer.parseInt(stb.nextToken()));
                g.add(Integer.parseInt(stg.nextToken()));
            }
            Collections.sort(b);
            Collections.sort(g);
            int sum=0;
            for(int m=0;m<n;m++){
                sum = sum + b.get(m) * g.get(m);
            }
            System.out.println(sum);

        }
    }
}
