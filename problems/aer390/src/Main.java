import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int i = Integer.parseInt(in.readLine().trim());
        for(int s=0;s<i;s++){
            StringTokenizer st = new StringTokenizer(in.readLine()," ");
            int mag = Integer.parseInt(st.nextToken());
            int ama = Integer.parseInt(st.nextToken());
            int cia = Integer.parseInt(st.nextToken());

            String aux = st.nextToken();
            for(int j=0;j<aux.length() && mag>=0 && ama>=0 && cia>=0 ;j++){
                char m = aux.charAt(j);
                if(m=='M') mag--;
                if(m=='C') cia--;
                if(m=='A') ama--;
                if(m=='R') {ama--; mag--;}
                if(m=='N') {ama--; mag--; cia--;}
                if(m=='V') {ama--; cia--;}
                if(m=='L') {cia--; mag--;}
            }

            if(mag>=0 && cia>=0 && ama>=0){
                System.out.println("SI "+ mag + " "+ama + " "+cia);
            }else{
                System.out.println("NO");
            }

        }


    }
}