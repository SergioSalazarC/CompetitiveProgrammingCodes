

import java.util.Scanner;

public class aer458 {

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in=  new Scanner(System.in);
        int h=in.nextInt();
        while(h!=0){
            if(h==2){
                long a=in.nextInt();
                long b=in.nextInt();
                b=a*b;
                System.out.println(b);
            }else{
                long maxmax=0;
                long max=0;
                long min=0;
                long minmin=0;
                for(int i=0;i<h;i++){
                    int k =in.nextInt();
                    if(k>maxmax){
                        max=maxmax;
                        maxmax=k;
                    }else if(k>max){
                        max=k;
                    }else if(k<minmin){
                        min=minmin;
                        minmin=k;
                    }else if(k<min){
                        min=k;
                    }
                }
                long solucion=Math.max(maxmax*max, minmin*min);
                System.out.println(solucion);
            }
            h=in.nextInt();
        }

    }

}