import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class aer330 {
    static HashMap<String,Integer> mapa;

    static int nota(String m){
        String aux = m.substring(0,m.length()-1);
        int val=0;
        if(mapa.containsKey(aux)){
            val=mapa.get(aux);
        }
        else{
            String t=aux.substring(0,aux.length()-1);
            val=mapa.get(t);
            if(aux.charAt(aux.length()-1)=='#'){
                val++;
            }
            else{
                val--;
            }
        }
        val+=12*(Integer.parseInt(String.valueOf(m.charAt(m.length()-1)))-1);
        return val;
    }



    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        mapa = new HashMap<>();
        mapa.put("Do",0);
        mapa.put("Re",2);
        mapa.put("Mi",4);
        mapa.put("Fa",5);
        mapa.put("Sol",7);
        mapa.put("La",9);
        mapa.put("Si",11);
        while(n!=0){
            int[] piano = new int[84];
            for(int i=0;i<n;i++){
                piano[nota(in.next())]++;
            }
            boolean os = true;
            LinkedList<Integer> cola = new LinkedList<>();
            StringBuilder sb = new StringBuilder("");
            for(int i=0;i<84;i++){
                int aux = piano[i];
                if(os && aux==0) continue;
                else if(os && aux!=0){
                    os=false;
                    sb.append(piano[i]+" ");
                }
                else if(!os && aux==0){
                    cola.addFirst(0);
                }
                else{
                    cola.addFirst(aux);
                    while(!cola.isEmpty()){
                        int s = cola.removeLast();
                        sb.append(s+" ");
                    }
                }
            }
            System.out.println(sb.toString().trim());
            n = in.nextInt();
        }

    }
}