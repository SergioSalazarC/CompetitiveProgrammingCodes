import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int p = Integer.parseInt(in.readLine().trim());
        while(p!=0){
            HashMap<String,Integer> map = new HashMap<>();
            StringTokenizer st = new StringTokenizer(in.readLine()," ");
            for(int i=0;i<p;i++){
                String aux = st.nextToken();
                if(!map.containsKey(aux)){
                    map.put(aux,1);
                }else{
                    map.put(aux,map.get(aux)+1);
                }
            }
            int h = Integer.parseInt(in.readLine());
            st = new StringTokenizer(in.readLine()," ");
            for(int i=0;i<h;i++){
                String aux=st.nextToken();
                if(!map.containsKey(aux)){
                    map.put(aux,1);
                    System.out.println(1);
                }else{
                    map.put(aux,map.get(aux)+1);
                    System.out.println(map.get(aux));
                }
            }
            System.out.println();
            p = Integer.parseInt(in.readLine().trim());
        }
    }
}