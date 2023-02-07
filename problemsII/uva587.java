import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.StringTokenizer;

public class uva587 {
    static HashMap<String , Integer> trad;

    static double R2 = 1.0/Math.sqrt(2);
    static double[]ns = {1,R2,0,-R2,-1,-R2,0,R2};
    static double[]eo = {0,R2,1,R2,0,-R2,-1,-R2};



    public static int[] dir(String s){
        StringBuilder aux = new StringBuilder(s);
        if(aux.charAt(aux.length()-1)=='.'){
            int t = aux.length()-3;
            if(aux.charAt(t) =='N' || aux.charAt(t) == 'S'){
                return new int[]{Integer.parseInt(aux.substring(0, aux.length() - 3)), trad.get(aux.substring(aux.length() - 3,aux.length() - 1))};
            }
            else{
                return new int[]{Integer.parseInt(aux.substring(0, aux.length() - 2)), trad.get(aux.substring(aux.length() - 2,aux.length() - 1))};
            }
        }
        else{
            int t = aux.length()-2;
            if(aux.charAt(t) =='N' || aux.charAt(t) == 'S'){
                return new int[]{Integer.parseInt(aux.substring(0, aux.length() - 2)), trad.get(aux.substring(aux.length() - 2))};
            }
            else{
                return new int[]{Integer.parseInt(aux.substring(0, aux.length() - 1)), trad.get(aux.substring(aux.length() - 1))};
            }
        }
    }


    public static double dist(double x, double y){
        return Math.sqrt(x*x+y*y);
    }

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.ENGLISH);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        trad=new HashMap<>();
        trad.put("N",0);
        trad.put("NE",1);
        trad.put("E",2);
        trad.put("SE",3);
        trad.put("S",4);
        trad.put("SW",5);
        trad.put("W",6);
        trad.put("NW",7);


        String next = in.readLine();
        int indice = 1;
        while(!next.trim().equals("END")){
            StringTokenizer st = new StringTokenizer(next,",");
            double x=0;
            double y=0;
            while(st.hasMoreElements()){
                int[] ord = dir(st.nextToken());
                x = x + eo[ord[1]]*ord[0];
                y = y + ns[ord[1]]*ord[0];
            }
            NumberFormat formatter = new DecimalFormat("#0.000");

            System.out.println("Map #"+indice);
            System.out.println("The treasure is located at ("+formatter.format(x)+","+formatter.format(y)+").");
            System.out.println("The distance to the treasure is "+formatter.format(dist(x,y))+".");
            System.out.println();

            indice++;
            next=in.readLine();



        }


    }
}
