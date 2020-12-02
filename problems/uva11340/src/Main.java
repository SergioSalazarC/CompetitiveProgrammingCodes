import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int casos = Integer.parseInt(in.readLine().trim());
        for(int i =0;i<casos;i++){
            int caract = Integer.parseInt(in.readLine().trim());
            HashMap<Character,Integer> dic=new HashMap<>();
            for(int j =0;j<caract;j++){
                StringTokenizer st = new StringTokenizer(in.readLine()," ");
                char a = st.nextToken().charAt(0);
                int b = Integer.parseInt(st.nextToken());
                dic.put(a,b);
            }
            int lin = Integer.parseInt(in.readLine().trim());
            int total=0;
            for(int j=0;j<lin;j++){
                String l = in.readLine();
                for(int m=0;m<l.length();m++){
                    char aux=l.charAt(m);
                    if(dic.containsKey(aux)){
                        total+=dic.get(aux);
                    }
                }
            }

            int ent=total/100;
            Integer dec=total % 100;

            if(dec.toString().length()==1){
                System.out.println(ent+".0"+dec+"$");
            }else{
                System.out.println(ent+"."+dec+"$");
            }


        }

    }
}
