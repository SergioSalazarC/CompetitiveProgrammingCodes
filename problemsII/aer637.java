import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

import static java.lang.Integer.parseInt;

public class aer637 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Character,Integer> map = new HashMap<>();
        map.put('A',5);
        map.put('B',9);
        map.put('C',11);
        map.put('D',7);
        map.put('E',1);
        map.put('F',9);
        map.put('G',9);
        map.put('H',7);
        map.put('I',3);
        map.put('J',13);
        map.put('K',9);
        map.put('L',9);
        map.put('M',7);
        map.put('N',5);
        map.put('O',11);
        map.put('P',11);
        map.put('Q',13);
        map.put('R',7);
        map.put('S',5);
        map.put('T',3);
        map.put('U',7);
        map.put('V',9);
        map.put('W',9);
        map.put('X',11);
        map.put('Y',13);
        map.put('Z',11);
        map.put('?',15);
        map.put('!',19);
        map.put(' ',5);

        int n = parseInt(in.readLine().trim());
        while(n-->0){
            String s = in.readLine();
            int val=0;
            for(int i=0;i<s.length();i++){
                if(i!=0){
                    if(s.charAt(i-1)!=' ' && s.charAt(i)!=' ')val+=3;
                }
                val+=map.get(s.charAt(i));
            }
            System.out.println(val);

        }
    }
}
