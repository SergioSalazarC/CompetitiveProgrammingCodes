import java.util.Scanner;

public class aer634 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        StringBuilder sb = new StringBuilder();
        while(n-->0){
            String lec = in.next();
            long sol=0;
            long actual=0;
            for(int i=0;i<lec.length();i++){

                if(lec.charAt(i)=='O'){
                    actual+=10;
                    sol+=actual;
                }
                else{
                    actual=0;
                }

            }
            sb.append(sol).append("\n");

        }
        System.out.print(sb);
    }
}
