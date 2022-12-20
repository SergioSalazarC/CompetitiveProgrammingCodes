import java.util.Scanner;

public class aer547 {


    public static long f(int capacidad, long bits,  long max, long value){
        if(capacidad<0 || bits<0 || max<0 || value <0 ) System.out.println("ASDFA");
        if(value>max) return 0;
        if(capacidad==0) return 1;
        if(bits==0) return 1;
        long vacio = f(capacidad,bits-1,max,value);
        long novacio = f(capacidad-1,bits-1,max, (long) (value+Math.pow(2,bits-1)));
        return vacio+novacio;
    }



    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int bombillas = in.nextInt();
        long s1 = in.nextLong();
        long s2 = in.nextLong();
        while (bombillas!=0 || s1!=0 || s2!=0){
            long v1=0;
            long v2=0;
            if(s1==0){
                v1=0;
            }
            else if(s1==1){
                v1=1;
            }
            else{
                double log =   (Math.log(s1-1) / Math.log(2))+1;
                long cota1 = (long) Math.floor(log);
                v1 = f(bombillas,cota1,s1-1,0);
            }
            if(s2==0) v2=1;
            else if(s2==1){
                if(bombillas==0) v2=1;
                if(bombillas>0) v2=2;

            }
            else{
                double log2 = (Math.log(s2) / Math.log(2))+1;
                long cota2 = (long) Math.floor(log2);
                v2 = f(bombillas,cota2,s2,0);
            }
            System.out.println(v2-v1);

            bombillas = in.nextInt();
            s1 = in.nextLong();
            s2 = in.nextLong();
        }




    }
}