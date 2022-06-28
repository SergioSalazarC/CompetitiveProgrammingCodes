import java.util.Scanner;

public class aer237 {

    public static boolean pol(Long k){
        int s = k.toString().length();
        if(s==1){
            return true;
        }
        if(k%s==0) return pol(k/10);
        return false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            long k = in.nextLong();
            if(pol(k)) System.out.println("POLIDIVISIBLE");
            else System.out.println("NO POLIDIVISIBLE");
        }




    }
}
