import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String aux = in.readLine();
        while(aux!=null){
            int l = aux.length();
            Stack<Character> p= new Stack<>();
            boolean salida=true;
            for(int i=0;i<l && salida;i++){
                char c = aux.charAt(i);
                if(c=='(' || c=='[' || c=='{'){
                    p.add(c);
                }
                if(c==')' || c==']' || c=='}'){
                    if(p.isEmpty()){
                        salida=false;
                        break;
                    }
                    char pop = p.pop();

                    if((c==')' && pop=='(') || (c==']' && pop=='[') || (c=='}' && pop=='{')) continue;
                    else{
                        salida=false;
                        break;
                    }
                }
            }
            if(salida && p.isEmpty()){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
            aux=in.readLine();

        }
    }
}