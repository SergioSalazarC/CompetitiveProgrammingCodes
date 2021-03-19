import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class JavaApplication2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n=in.nextLong();        
        while(n!=0){
            ArrayList<Long> collar= new ArrayList<>();
            collar.add(n);
            n =in.nextLong();
            while(n!=0){
                collar.add(n);
                n=in.nextLong();
            }
            if(collar.size()%2==0){
                System.out.println("NO");
            }else{
                boolean b=true;
                ArrayList<Long> bien=new ArrayList<>();
                Collections.sort(collar);
                for(int i=0;i<collar.size()-1;i=i+2){
                    if(collar.get(i).equals(collar.get(i+1))){
                        bien.add(collar.get(i));
                    }else{
                        System.out.println("NO");
                        b=false;
                        break;
                    }
                }
                if(b){
                    bien.add(collar.get(collar.size()-1));
                    if(bien.size()==1){
                        System.out.println(bien.get(0));
                    }else{
                        for(int i=0;i<=bien.size()-1;i++){
                        System.out.print(bien.get(i)+" ");
                    }
                    for(int j=bien.size()-2;j>=0;j--){
                        if(j==0)System.out.println(bien.get(j));
                        else System.out.print(bien.get(j)+" ");
                    }
                    }
                    
                }
            }
            n=in.nextLong();
        }
    }    
}