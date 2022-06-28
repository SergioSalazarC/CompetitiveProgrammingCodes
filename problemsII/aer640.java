import java.util.Scanner;

public class aer640 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long hasta = in.nextLong();
        int digiti = in.nextInt()+48;
        while (hasta!=0 && digiti!=48){
            long base9 = 0;
            int aux=0;
            while(hasta>0){
                base9+=(hasta%9)*Math.pow(10,aux);
                hasta/=9;
                aux++;
            }
            String ex = Long.toString(base9);
            StringBuilder sol = new StringBuilder();
            for(int i=0;i<ex.length();i++){
                if(ex.charAt(i)>=digiti){
                    sol.append((char) (ex.charAt(i)+1));
                }
                else{
                    sol.append(ex.charAt(i));
                }
            }
            System.out.println(sol);
            hasta=in.nextLong();
            digiti=in.nextInt()+48;
        }

    }
}
