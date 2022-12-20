import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class aer571 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String next=in.readLine();
        StringBuilder sb = new StringBuilder();
        while(next!=null){
            HashMap<Integer,String> dic = new HashMap<>();
            int t =Integer.parseInt(next);
            int[] viajes = new int[t];
            for(int i=0;i<t;i++){
                StringTokenizer st = new StringTokenizer(in.readLine(), " ");
                dic.put(i,st.nextToken());
                viajes[i]=Integer.parseInt(st.nextToken());
            }
            int max=-1;
            for(int i=0;i<t;i++){
                int actval=viajes[i];
                max= Math.max(actval,max);
                if(max==actval){
                    sb.append("NO HAY\n");
                }else{
                    boolean escrito=false;
                    for(int j=i-1;j>=0;j--){
                        int auxval=viajes[j];
                        if(auxval>actval){
                            sb.append(dic.get(j)+"\n");
                            escrito=true;
                            break;
                        }
                    }
                    if(!escrito)sb.append("NO HAY\n");
                }
            }
            sb.append("---\n");
            next=in.readLine();
        }
        System.out.print(sb);

    }

}