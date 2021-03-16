import java.util.Scanner;
public class main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int ax=in.nextInt();
        int ay=in.nextInt();
        int bx=in.nextInt();
        int by=in.nextInt();
        while(ax<=bx && ay<=by){
            System.out.println((bx-ax)*(by-ay));
            ax=in.nextInt();
            ay=in.nextInt();
            bx=in.nextInt();
            by=in.nextInt();
        }
    }
}