import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    public static HashSet<Integer> bateria1;
    public static HashSet<Integer>  bateria2;
    public static HashSet<Integer>  bateria3;
    public static String mensaje;
    public static int longitud;
    public static int[] memo;
    public static boolean[] mark;
    public static int INF =1000000000;



    public static int dp(int index){
        if(index>=longitud) return 0;
        if(mark[index]==true) return memo[index]%1000000007;
        mark[index]=true;
        int max=0;

        int k =Integer.parseInt(mensaje.substring(index,index+1));
        if (k==0){
            max=dp(index+1);
            max= max%1000000007;
        }else{
            if(bateria1.contains(k)){
                if(index == longitud - 1)  max+=dp(index+1)+1;
                else max += dp(index+1);
                max= max%1000000007;

            }
            if(index<=longitud-2){
                k =Integer.parseInt(mensaje.substring(index,index+2));
                if(bateria2.contains(k)){
                    if(index==longitud-2) max+=dp(index+2)+1;
                    else max+=dp(index+2);
                    max= max%1000000007;
                }
            }
            if(index<=longitud-3){
                k =Integer.parseInt(mensaje.substring(index,index+3));
                if(bateria3.contains(k)){
                    if(index==longitud-3) max+=dp(index+3)+1;
                    else max+=dp(index+3);
                    max= max%1000000007;
                }
            }
        }
        max= max%1000000007;

        memo[index]=max;
        return max;

    }


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine().trim());
        while(n!=0){
            bateria1 = new HashSet<>();
            bateria2 = new HashSet<>();
            bateria3 = new HashSet<>();

            StringTokenizer st = new StringTokenizer(in.readLine()," ");
            for(int i=0;i<n;i++){
                String aux =st.nextToken();
                if(aux.length()==1){
                    bateria1.add(Integer.parseInt(aux));
                }
                else if(aux.length()==2){
                    bateria2.add(Integer.parseInt(aux));
                }
                else if(aux.length()==3){
                    bateria3.add(Integer.parseInt(aux));
                }
            }
            mensaje=in.readLine();
            longitud = mensaje.length();
            memo = new int[1010];
            mark = new boolean[1010];

            System.out.println(dp(0));
            n = Integer.parseInt(in.readLine().trim());


        }
    }
}
