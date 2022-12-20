import java.util.Scanner;

public class aer574 {
    public static long[] memo=new long[80];


    public static long rec(int i){
        if(memo[i]!=0) return memo[i];
        if(i==1) return 3;
        long max=2*rec(i-1)+i+2;
        memo[i]=max;
        return max;
    }

    public static char sol(int piso, long letra){
        long size =rec(piso);
        long mi = (memo[piso]-(piso+2))/2;
        long mf= size-mi-1;
        if(letra<mi){
            return sol(piso-1,letra);
        }else if(letra>mf){
            return sol(piso-1,letra-memo[piso-1]-(piso+2));
        }else{
            if(letra==mi) return 'B';
            if(letra==mf) return 'H';
            else return 'U';
        }
    }


    public static void main(String[] args) {
        memo[1]=3;
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            long fant=in.nextLong();
            long letra=in.nextLong()-1;
            char x = sol((int)fant,letra);
            System.out.println(x);
        }

    }
}