import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class aer380 {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        while(n!=0){
            long sum=0;
            for(int i=0;i<n;i++){
                sum+=in.nextLong();
            }
            System.out.println(sum);
            n=in.nextInt();
        }



    }
}