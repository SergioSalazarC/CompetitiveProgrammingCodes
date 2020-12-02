import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String first = in.readLine();
        while(!first.equals("0 0")){
            StringTokenizer st = new StringTokenizer(first," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            HashSet<Integer> dic = new HashSet<>();

            for (int i = 0; i< 1000000001 ;i++){
                dic.add(Integer.parseInt(in.readLine()));
            }
            int cont = 0;
            for(int i=0; i<b ; i++){
                if (dic.contains(Integer.parseInt(in.readLine()))) cont++;

            }

            System.out.println(cont);
            first = in.readLine();
        }
    }
}
