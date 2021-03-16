import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String aux = in.readLine().trim();
        while(aux.charAt(0) != '-'){
            StringBuilder sb = new StringBuilder();
            int total=0;
            int l = aux.length();
            for(int i=0;i<(2*l)-1;i++){
                if(i%2==0){
                    sb.append(aux.charAt(i/2));
                    total+=aux.charAt(i/2)-48;
                }else{
                    sb.append(" + ");
                }
            }
            sb.append(" = "+total);
            System.out.println(sb);
            aux = in.readLine().trim();
        }

    }
}