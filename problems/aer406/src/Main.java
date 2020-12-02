import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String caso=in.readLine();
        while(caso!=null){
            char[] carretera = caso.toCharArray();
            char[] carreterafinal = new char[carretera.length];
            Arrays.fill(carreterafinal,'.');


            ArrayList<Character> memo = new ArrayList<>();

            for(int i=0;i<carretera.length;i++){
                if (carretera[i]=='|'){
                    carreterafinal[i]='|';
                    int cont=memo.size()-1;
                    for(int j=1; j<=memo.size(); j++){
                        carreterafinal[i-j]=memo.get(cont);
                        cont--;
                    }

                    memo = new ArrayList<>();

                }
                else if(carretera[i]!='.'){
                    memo.add(carretera[i]);
                }
            }
            String entradas=in.readLine();
            StringTokenizer token = new StringTokenizer(entradas);
            int cantidad=Integer.parseInt(token.nextToken());

            StringBuilder sol = new StringBuilder();

            for(int i=0;i<cantidad;i++){
                int aux=Integer.parseInt(token.nextToken());
                sol.append(carreterafinal[aux-1]);
                if(i!=cantidad-1){
                    sol.append(' ');
                }
            }
            System.out.println(sol);
            caso=in.readLine();

        }

        

    }
}
