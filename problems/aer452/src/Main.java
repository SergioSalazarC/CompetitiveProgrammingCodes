import java.util.*;

public class bingo {
    public static void main (String[]Args){
        Scanner in = new Scanner (System.in);
        int n = in.nextInt();
        while(n!=0){
            int[]b=new int[n];
            for(int i=0; i<n; i++){
                b[i]=in.nextInt();
            }
            Set<Integer>res=new HashSet<>();
            for(int i=0; i<n; i++){
                for(int j=i+1; j<n; j++){
                    res.add(Math.abs(b[i]-b[j]));
                }
            }
            ArrayList<Integer>r=new ArrayList<>(res);
            Collections.sort(r);
            for(int i=0; i<r.size()-1; i++){
                System.out.print(r.get(i)+" ");
            }
            System.out.println(r.get(r.size()-1));
            n=in.nextInt();
        }
    }
}