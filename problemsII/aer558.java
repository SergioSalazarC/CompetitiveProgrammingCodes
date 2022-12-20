import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class aer558 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n= in.nextInt();
            HashMap<String,String> map =new HashMap<>();
            HashMap<String,Integer> may = new HashMap<>();
            LinkedList<String> lista = new LinkedList<>();
            for(int i=0;i<n;i++){
                String nex =in.next();
                lista.addLast(nex);
                int mayus=0;
                for(int j=0;j<nex.length();j++){
                    if(nex.charAt(j)>=65 && nex.charAt(j)<=90) mayus++;
                }
                if(map.containsKey(nex.toUpperCase())){
                    if(may.get(nex.toUpperCase())<mayus){
                        map.put(nex.toUpperCase(),nex);
                        may.put(nex.toUpperCase(),mayus);
                    }
                }else{
                    map.put(nex.toUpperCase(),nex);
                    may.put(nex.toUpperCase(),mayus);
                }
            }
            for(String x:lista){
                System.out.println(map.get(x.toUpperCase()));
            }
            System.out.println("---");
        }
    }
}