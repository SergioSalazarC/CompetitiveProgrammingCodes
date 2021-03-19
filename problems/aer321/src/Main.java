import java.util.*;

public class Main {
    public static int rec(int piso1, int piso2){
        if (piso1==0 && piso2==0) {
            return (1);
        }else if(piso2==0){
            return(rec(piso1-1,piso2)+piso1+piso2+1);
        }else{
            return(rec(piso1,piso2-1)+piso1+piso2);
        }
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        for(int i=0;i<n;i++){
            int a=in.nextInt();
            int b=in.nextInt();
            System.out.println(rec(a,b));
            }
        }
    }