import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class aer420 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n =Integer.parseInt(in.readLine());

        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(in.readLine(), " ");
            int a=Integer.parseInt(st.nextToken());
            String b="0"+st.nextToken();
            int inicio=0;
            int fin=0;
            int acumulado=0;
            int apariciones=0;
            while(fin<b.length()){
                if(acumulado<a){
                    fin++;
                    if(fin==b.length())continue;
                    acumulado+=b.charAt(fin)-48;
                }
                else if(acumulado>a){
                    inicio++;
                    acumulado-=b.charAt(inicio)-48;
                }
                else{
                    apariciones++;
                    fin++;
                    if(fin==b.length())continue;
                    acumulado+=b.charAt(fin)-48;

                }
            }
            System.out.println(apariciones);
        }
    }
}