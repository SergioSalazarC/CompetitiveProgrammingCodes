import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int k=Integer.parseInt(in.readLine().trim());
        for(int i =0;i<k;i++){
            int med = Integer.parseInt(in.readLine().trim());
            StringTokenizer st = new StringTokenizer(in.readLine()," ");
            int anterior=0;
            int masanterior=0;
            int actual=0;
            int pico=0;
            int valle=0;
            for(int j =0;j<med;j++){
                actual=Integer.parseInt(st.nextToken());
                if(j>1){
                    if(masanterior<anterior && actual<anterior){
                        pico++;
                    }else if(masanterior>anterior && actual>anterior){
                        valle++;
                    }
                }
                masanterior=anterior;
                anterior=actual;
            }
            System.out.println(pico+" "+valle);

        }

    }
}
