import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Integer v= Integer.parseInt(in.readLine());
        for(int i=0;i<v;i++){
            String aux= in.readLine();
            String hola = aux.substring(4,aux.length());
            System.out.println("Hola, "+hola+".");
        }
    }
}
