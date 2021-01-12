import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int INF=1000000001;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine()," ");
        int racimos = Integer.parseInt(st.nextToken());
        int necesatios = Integer.parseInt(st.nextToken());

        while(racimos!=0 || necesatios!=0){
            int[] vi = new int[racimos];
            st = new StringTokenizer(in.readLine()," ");
            for(int i=0;i<racimos;i++){
                vi[i]=Integer.parseInt(st.nextToken());
            }
            int m=0;
            int n=0;
            int reco=0;
            int min=INF;
            while(!(m>=racimos && reco<necesatios)){
                if(reco<necesatios){
                    reco+=vi[m];
                    if(reco>=necesatios) min=Math.min(min,reco);
                    m++;
                }
                else if(reco>necesatios){
                    reco-=vi[n];
                    if(reco>=necesatios) min=Math.min(min,reco);
                    n++;
                }else{
                    break;
                }

            }
            if(necesatios==0) System.out.println("0");
            else if (min==INF) System.out.println("IMPOSIBLE");
            else System.out.println(min);

            st = new StringTokenizer(in.readLine()," ");
            racimos = Integer.parseInt(st.nextToken());
            necesatios = Integer.parseInt(st.nextToken());

        }
    }
}
