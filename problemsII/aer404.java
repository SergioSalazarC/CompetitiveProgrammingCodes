import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class aer404 {

    public static String s;
    public static HashSet<String> aceptados;

    public static int[][] memo;
    public static boolean[][] check;

    public static int sol(int indice_inicial, int indice_final){
        if(indice_final==indice_inicial && indice_inicial==s.length())return 1;
        if(indice_final>=s.length() || indice_inicial>=s.length()) return 0;

        if(check[indice_inicial][indice_final]) return memo[indice_inicial][indice_final];
        check[indice_inicial][indice_final]=true;

        StringBuilder aux = new StringBuilder();
        for (int i = indice_inicial; i <= indice_final ; i++) {
            aux.append(s.charAt(i));
        }
        int value = 0;
        if(aceptados.contains(aux.toString())){
            value+=sol(indice_final+1,indice_final+1);
            value+=sol(indice_inicial,indice_final+1);
        }
        memo[indice_inicial][indice_final]=value;
        return value;


    }


    public static void main(String[] args) throws IOException {
        aceptados = new HashSet<>();
        aceptados.add("X");
        aceptados.add("I");
        aceptados.add("II");
        aceptados.add("III");
        aceptados.add("IV");
        aceptados.add("V");
        aceptados.add("VI");
        aceptados.add("VII");
        aceptados.add("VIII");
        aceptados.add("IX");

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        s = in.readLine();
        while(s!=null){
            memo = new int[s.length()+1][s.length()+1];
            check = new boolean[s.length()+1][s.length()+1];

            System.out.println(sol(0,0));


            s=in.readLine();
        }

    }
}
