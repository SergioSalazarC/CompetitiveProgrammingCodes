import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int c = Integer.parseInt(in.readLine());
        for(int i =0;i<c;i++){
            String caso = in.readLine();
            StringTokenizer st = new StringTokenizer(caso, " ");
            int a =1;
            int resultado=0;
            boolean sr=true; //true + false -
            while(true){
                if (a % 2==1){
                    int h = Integer.parseInt(st.nextToken());
                    if (sr) resultado+=h;
                    else resultado-=h;
                    if(a!=1)System.out.print(resultado);
                }else{
                    String aux=st.nextToken();
                    if(aux.equals("+"))sr=true;
                    else if(aux.equals("-"))sr=false;
                    else{
                        System.out.println();
                        break;
                    }
                    if(a!=2)System.out.print(", ");
                }
                a++;
            }
        }
    }
}
