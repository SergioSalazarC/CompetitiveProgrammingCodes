import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner in =new Scanner(System.in);
        HashMap<String,String> dic= new HashMap<>();
        String ent = in.nextLine();
        while(!ent.equals("")){
            StringTokenizer token = new StringTokenizer(ent," ");
            String a=token.nextToken();
            String b=token.nextToken();
            dic.put(b,a);
            ent=in.nextLine();
        }

        while(in.hasNext()){
            ent=in.nextLine();
            if (dic.containsKey(ent)){
                System.out.println(dic.get(ent));
            }
            else{
                System.out.println("eh");
            }
        }

    }
}
