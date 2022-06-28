import java.util.HashMap;
import java.util.Scanner;

public class aer636 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int a = in.nextInt()*10;
            int b = in.nextInt();

            StringBuilder sb = new StringBuilder().append("0.");
            HashMap<Integer,Integer> map = new HashMap<>();
            int i=1;
            int puro=-1;
            while(!map.containsKey(a)){
                map.put(a,i);
                i++;
                int aux=a/b;
                a=a%b;
                sb.append(aux);
                if(a==0){

                    puro=0;
                    break;
                }

                a*=10;
            }
            if(puro==0){
                System.out.println(sb);
            }
            else{
                puro=map.get(a);
                sb.insert(puro+1,"|");
                sb.append("|");
                System.out.println(sb);
            }



        }
    }
}
