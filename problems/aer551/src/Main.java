import java.util.*;

public class Main {
    public static void main(String[] Args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String k=in.nextLine();
            String sol="";
            for(int a=0;a<k.length();a+=2){
                char m = k.charAt(a);
                int p= m-48;
                if(p==1){
                    char n = k.charAt(a+1);
                    int q=n-48;
                    char r= k.charAt(a+2);
                    int z=r-48;
                    a++;
                    int s =p*100+q*10+z;
                    char loco=(char)s;
                    sol=sol+loco;
                }else{
                    char n = k.charAt(a+1);
                    int q=n-48;
                    int s =p*10+q;
                    char loco=(char)s;
                    sol=sol+loco;
                }

            }
            System.out.println(sol);
        }

    }
}