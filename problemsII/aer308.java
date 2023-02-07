import java.util.HashMap;
import java.util.Scanner;

public class aer308 {

    static HashMap<String,Boolean> hm = new HashMap<>();




    public static boolean puede (StringBuilder string, String obj){
        if(string.length()==0) return false;
        if(string.length()==1) return string.toString().equals(obj);
        boolean sol=false;

        StringBuilder checker = new StringBuilder(string);
        checker = checker.append(obj);

        if(hm.containsKey(checker.toString())) return hm.get(checker.toString());

        for (int i = 0; i < string.length(); i++) {
            StringBuilder m1 = new StringBuilder(string.substring(0,i));
            StringBuilder m2 = new StringBuilder(string.substring(i));



            if(obj.toString().equals("a")) sol = sol ||  (puede(m1,"c") && puede(m2,"a")) || (puede(m1,"a") && puede(m2,"c")) || (puede(m1,"b") && puede(m2,"c"));
            if(obj.toString().equals("b")) sol = sol ||  (puede(m1,"a") && puede(m2,"a")) || (puede(m1,"a") && puede(m2,"b")) || (puede(m1,"b") && puede(m2,"b"));
            if(obj.toString().equals("c")) sol = sol ||  (puede(m1,"b") && puede(m2,"a")) || (puede(m1,"c") && puede(m2,"b")) || (puede(m1,"c") && puede(m2,"c"));

            if(sol)break;
        }

        hm.put(checker.toString(),sol);
        return sol;

    }




    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        hm = new HashMap<>();

        while(in.hasNext()){
            StringBuilder sb = new StringBuilder(in.next());
            if(puede(sb,"a")) System.out.println("SI");
            else System.out.println("NO");

        }
    }
}
