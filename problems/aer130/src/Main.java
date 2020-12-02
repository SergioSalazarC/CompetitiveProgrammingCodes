import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        while(size!=0){
            int x1=in.nextInt();
            int y1=in.nextInt();
            int x2=in.nextInt();
            int y2=in.nextInt();

            if((x1+y1)%2!=(x2+y2)%2) System.out.println("IMPOSIBLE");
            else{
                int count=0;
                if(x1+y1==x2+y2) count++;
                if(x1-y1==x2-y2) count++;
                if (count==2) System.out.println(0);
                else if (count==1) System.out.println(1);
                else if (count==0) System.out.println(2);
            }


            size=in.nextInt();

        }
    }
}
