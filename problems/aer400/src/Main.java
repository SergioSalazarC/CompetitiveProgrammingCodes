import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s = in.readLine();
        StringBuilder sb = new StringBuilder();
        while(s!=null){
            int max=0;
            int cont=0;
            int c=0;
            if(s.charAt(0)=='.'){
                while(true){
                    if(s.charAt(cont)=='.'){
                        cont++;
                    }
                    else{
                        max=Math.max(max,cont*2);
                        break;
                    }
                }
            }
            for(int i=cont;i<s.length();i++){
                if(s.charAt(i)=='.'){
                    c++;
                }else{
                    max=Math.max(max,c);
                    c=0;
                }
            }
            max=Math.max(max,c*2);
            if(max%2==0){
                max=max/2-1;
            }else{
                max=max/2;
            }
            sb.append(max);
            sb.append("\n");
            s = in.readLine();
        }
        System.out.print(sb);
    }
}