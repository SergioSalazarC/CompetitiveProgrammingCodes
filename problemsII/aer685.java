import java.util.Scanner;

public class aer685 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        int y = in.nextInt();
        int xx = in.nextInt();
        int yy = in.nextInt();

        while(!(x==0 && y==0 && xx==0 && yy==0)){


            xx = xx-x;
            yy= yy-y;

            boolean check = (xx==0 || yy==0 || xx==yy || xx==-yy);
            if(check) System.out.println("SI");
            else System.out.println("NO");
            x = in.nextInt();
            y = in.nextInt();
            xx = in.nextInt();
            yy = in.nextInt();
        }
    }
}
