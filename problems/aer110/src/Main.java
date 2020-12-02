import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public String last(String frase){
        int total=frase.length();
        String subc="";
        int contador=0;
        while(contador<2){
            char aux = frase.charAt(total-1);
            subc=subc+aux;
            if(aux=='a'||aux=='e'||aux=='i'||aux=='o'||aux=='u'||aux=='A'||aux=='E'||aux=='I'||aux=='O'||aux=='U'){
                contador++;
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String next = in.readLine();
        while(!next.equals("0")){
            Integer versos = Integer.parseInt(next);
            if(versos==2){

            }
        }




    }
}
