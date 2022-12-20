import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class aer372 {
    public static String voltear(String m){
        String sol = "";
        for(int i=0;i<m.length();i++){
            if(i==0){
                if(m.charAt(i)==Character.toUpperCase(m.charAt(i))){
                    sol+=(""+Character.toUpperCase(m.charAt(m.length()-1)));
                }
                else{
                    sol+=(""+m.charAt(m.length()-1));
                }
            }
            else{
                sol+=(""+Character.toLowerCase(m.charAt(m.length()-1-i)));
            }
        }
        return sol;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        for (int i = 0; i < n; i++) {
            String l = in.readLine();
            System.out.println(voltear(l));
        }

    }
}