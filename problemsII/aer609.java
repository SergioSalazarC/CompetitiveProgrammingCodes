import java.util.Arrays;
import java.util.Scanner;

public class aer609 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();
            int torres = in.nextInt();
            int[] horizontal = new int[torres];
            int[] vertical = new int[torres];
            for(int i=0;i<torres;i++){
                horizontal[i]=in.nextInt();
                vertical[i]=in.nextInt();
            }
            Arrays.sort(horizontal);
            Arrays.sort(vertical);
            if(torres%2==1){
                int aux = torres/2;
                System.out.println(horizontal[aux]+" "+vertical[aux]);
            }
            else if(torres%2==0){
                int aux=torres/2-1;
                System.out.println(horizontal[aux]+" "+vertical[aux]);
            }
        }
    }
}
