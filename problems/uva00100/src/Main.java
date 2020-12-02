import java.util.Scanner;

public class Main {

    public static int rec(int h){
        if(h==1) return 1;
        if(h%2==0) return rec(h/2)+1;
        else return rec(3*h+1)+1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int a = in.nextInt();
            int b = in.nextInt();
            int min;
            int max;

            if(a<b){
                min=a;
                max=b;
            }
            else{
                min=b;
                max=a;
            }

            int sol=0;

            for(int i =min;i<=max;i++){
                sol=Math.max(sol,rec(i));
            }

            System.out.println(a+" "+b+" "+sol);
        }
    }
}
