import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        HashSet<Character> letras = new HashSet<Character>();
            for(int i =0;i<26;i++){
                int a= 65+i;
                int b= 97+i;
                char may = (char) a;
                char min = (char) b;
                letras.add(may);
                letras.add(min);
            }
            while(in.hasNext()){
                String linea = in.nextLine();
                int let=0;
                int exc=0;
                for(int i=0;i< linea.length();i++){
                    if (letras.contains(linea.charAt(i))) let++;
                    else if (linea.charAt(i)=='!') exc++;
                }
                if(exc>let) System.out.println("ESGRITO");
                else System.out.println("escrito");
            }
        }
    }