import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class aer673 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();
            int c = in.nextInt();
            int[] mem = new int[n+1];
            int solucion=0;
            int peso=0;
            int sum = 0;
            int indexmidsum=1;
            int midsum = 0;
            for (int i = 1; i <= n; i++) {
                if(i<c){
                    int a = in.nextInt();
                    mem[i]=a;
                    sum+=a;
                }
                else if(i==c){
                    int a = in.nextInt();
                    mem[i]=a;
                    sum+=a;
                    int mitad = sum/2;
                    while(midsum<mitad){
                        midsum+=mem[indexmidsum];
                        indexmidsum++;
                    }
                    if(midsum==mitad && sum%2==0){
                        if(sum>peso){
                            solucion=i-c+1;
                            peso=sum;
                        }
                    }


                }
                else{
                    int b = mem[i-c];
                    sum-=b;
                    midsum-=b;
                    int a = in.nextInt();
                    mem[i]=a;
                    sum+=a;
                    int mitad = sum/2;
                    while(midsum<mitad){
                        midsum+=mem[indexmidsum];
                        indexmidsum++;
                    }
                    if(midsum==mitad && sum%2==0){
                        if(sum>peso){
                            solucion=i-c+1;
                            peso=sum;
                        }
                    }
                }
            }

            if(solucion==0) System.out.println("SIN ADORNOS");
            else System.out.println(solucion);
        }
    }
}
