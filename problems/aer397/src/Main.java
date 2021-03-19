import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k =in.nextInt();
        for(int t=0;t<k;t++){
            int i = in.nextInt();
            if(i%3==0 || (i+1)%3==0){
                System.out.println("SI");
            }else{
                System.out.println("NO");
            }
        }

    }
}