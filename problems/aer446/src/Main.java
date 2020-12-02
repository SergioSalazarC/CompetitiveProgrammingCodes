import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int c=Integer.parseInt(in.readLine());
        for(int i=0; i<c;i++){
            String caso = in.readLine();
            StringTokenizer st = new StringTokenizer(caso," ");
            String niet= st.nextToken();
            int n = Integer.parseInt(st.nextToken());
            if (n==1){
                System.out.println("FALSA");
            }
            else{
                boolean ndicho =true;
                for(int j=1;j<=n;j++){
                    String aux = st.nextToken();
                    if(aux.equals(niet)){
                        ndicho=false;
                        if(j==n) System.out.println("VERDADERA");
                        else{
                            System.out.println("FALSA");
                            break;
                        }
                    }
                }
                if(ndicho) System.out.println("FALSA");
            }
        }
    }
}
