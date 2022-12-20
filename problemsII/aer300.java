import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class aer300 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(in.readLine());
        StringBuilder sb = new StringBuilder();
        while (x-->0){
            HashSet<Character> s = new HashSet<>();
            String a = in.readLine();
            for (int i = 0; i < a.length(); i++) {
                char t = a.charAt(i);
                if(t=='a' || t=='e' | t=='i' || t=='o' || t=='u'){
                    s.add(t);
                }
            }
            if(s.size()==5) sb.append("SI").append("\n");
            else sb.append("NO").append("\n");
        }
        System.out.print(sb);
    }
}