import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String aux = in.readLine();
        while(!aux.equals("-1")){

            int fails = 0;

            String palab = in.readLine();
            String guess = in.readLine();

            HashSet<Character> inp = new HashSet<>();
            HashSet<Character> dich = new HashSet<>();
            for(int i=0;i<palab.length();i++){
                inp.add(palab.charAt(i));
            }

            for(int i=0;i<guess.length() && fails<7;i++){
                char abc = guess.charAt(i);

                if(inp.contains(abc)){
                    inp.remove(abc);
                }
                else{
                    if(!dich.contains(abc)){
                        fails++;
                    }
                }

                dich.add(abc);

            }
            System.out.println("Round "+aux);
            if(inp.isEmpty()){
                System.out.println("You win.");
            }
            else if(fails >= 7){
                System.out.println("You lose.");
            }
            else{
                System.out.println("You chickened out.");
            }

            aux = in.readLine();


        }
    }
}
