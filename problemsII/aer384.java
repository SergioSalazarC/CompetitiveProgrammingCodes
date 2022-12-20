import java.util.Scanner;

public class aer384 {



    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while(in.hasNext()){
            int n=in.nextInt();
            int[] arr = new int[n+5];
            int temp;
            int flag=0;
            int inter=1;
            temp = in.nextInt();
            arr[0]  = temp;
            arr[1] = temp;
            n--;
            while(n!=0) {
                n--;
                temp = in.nextInt();
                for (int i = inter; i > 0 && arr[i - 1] < temp && flag==0; i -= 2)
                    if (arr[i - 1] < temp && arr[i] > temp) flag = 1;
                if (flag==1) break;
                if (arr[inter - 1] < temp)  arr[inter] = temp;
                else if (arr[inter - 1] == arr[inter]){
                    arr[inter - 1] =  temp;
                    arr[inter] = temp;
                }
                else {
                    inter += 2;
                    arr[inter - 1] =  temp;
                    arr[inter] = temp;
                }
            }
            while(n!=0) { n--; in.nextInt(); }
            if (flag==1) System.out.println("ELEGIR OTRA");
            else System.out.println("SIEMPRE PREMIO");
        }
    }
}