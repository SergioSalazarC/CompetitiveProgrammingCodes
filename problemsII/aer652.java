import java.util.Scanner;

public class aer652 {
    public static long normalToNotFive(long x){
        long base9 = 0;
        long aux=0;
        long hasta =x;
        while(hasta>0){
            base9+=(hasta%9)*Math.pow(10,aux);
            hasta/=9;
            aux++;
        }
        String ex = Long.toString(base9);
        StringBuilder sol = new StringBuilder();
        for(int i=0;i<ex.length();i++){
            if(ex.charAt(i)>='5'){
                sol.append((char) (ex.charAt(i)+1));
            }
            else{
                sol.append(ex.charAt(i));
            }
        }
        return Long.parseLong(sol.toString());
    }




    public static long NotFiveToNormal(long x){
        String ex = String.valueOf(x);
        StringBuilder sol = new StringBuilder();
        for(int i=0;i<ex.length();i++){
            if(ex.charAt(i)>='6'){
                sol.append((char) (ex.charAt(i)-1));
            }
            else{
                sol.append(ex.charAt(i));
            }
        }
        sol = sol.reverse();

        long dev = 0;

        for (int i = 0; i < sol.length(); i++) {
            dev+= (sol.charAt(i)-48)*Math.pow(9,i);
        }
        return dev;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            long a=in.nextLong();
            long b=in.nextLong();
            a=NotFiveToNormal(a);
            b=NotFiveToNormal(b);
            long sol = a*b;
            sol = normalToNotFive(sol);
            System.out.println(sol);

        }

    }
}
