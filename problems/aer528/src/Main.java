import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String x = in.readLine();
        int cant = Integer.parseInt(x);
        while(cant!=0){
            int ceros=0;
            int unos=0;
            int enteros=0;
            int decimales=0;
            String entry = in.readLine();
            StringTokenizer token = new StringTokenizer(entry," ");

            for(int i=0;i<cant;i++){
                String aux=token.nextToken();
                if(aux.equals("0")){
                    ceros++;
                    continue;
                }
                if(aux.equals("1")){
                    unos++;
                    continue;
                }
                int contener= aux.indexOf("0.");
                if(contener==0){
                    decimales++;
                }
                else{
                    enteros++;
                }
            }
            int sol=0;

            for(int i=0;i<ceros;i++){
                sol=sol+(cant-(1));
                cant--;
            }
            for(int i=0;i<unos;i++){
                sol=sol+(cant-(1));
                cant--;
            }

            sol=sol+((enteros*(enteros-1))/2);
            sol=sol+((decimales*(decimales-1))/2);

            System.out.println(sol);
            x = in.readLine();
            cant = Integer.parseInt(x);
        }
    }
}
