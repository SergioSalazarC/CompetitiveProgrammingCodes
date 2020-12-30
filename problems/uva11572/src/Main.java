import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {



    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(in.readLine().trim());
        for(int i=0;i<n;i++){
            int maxsize=0;
            int c=Integer.parseInt(in.readLine().trim());
            HashMap<Integer,Integer> pos = new HashMap<>();
            Queue<Integer> cadena= new LinkedList<>();
            for(int j=0; j<c;j++){
                int h=Integer.parseInt(in.readLine().trim());
                if(pos.containsKey(h)){
                    maxsize=Math.max(maxsize,pos.size());
                    int aux=-1;
                    while(aux!=h && !cadena.isEmpty()){
                        aux=cadena.remove();
                        pos.remove(aux);
                    }
                    pos.put(h,j);
                    cadena.add(h);
                }else{
                    pos.put(h,j);
                    cadena.add(h);
                }
            }
            maxsize=Math.max(maxsize,pos.size());
            System.out.println(maxsize);
        }
    }
}
