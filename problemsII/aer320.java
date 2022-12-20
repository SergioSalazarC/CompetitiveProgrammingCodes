import java.io.*;
import java.util.*;

public class aer320 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int casos= in.nextInt();
        for(int c=0;c<casos;c++){
            int nieve=in.nextInt();
            int n=in.nextInt();
            int indexmin=0;
            int maxlong=-1;
            int palmeras=0;
            ArrayList<Integer>palm=new ArrayList<>();
            for(int i=1;i<=n;i++){
                int k = in.nextInt();
                palm.add(k);
                if(k<nieve && palmeras<=5){
                    maxlong=Math.max(maxlong,(i-indexmin));
                }
                else{
                    palmeras++;
                    while (palmeras>5){
                        if(palm.get(indexmin)>=nieve) palmeras--;
                        indexmin++;
                    }
                    maxlong=Math.max(maxlong,(i-indexmin));
                }
            }
            System.out.println(maxlong);
        }
    }
}