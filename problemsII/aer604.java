import java.util.HashMap;
import java.util.Scanner;

public class aer604 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        HashMap<Character,Integer> hm = new HashMap();
        hm.put('A',4);
        hm.put('K',3);
        hm.put('Q',2);
        hm.put('J',1);

        
        while(n-->0){
            int C=0;
            int D=0;
            int P=0;
            int T=0;

            int puntos=0;

            for (int i = 0; i < 13; i++) {
                char num = in.next().charAt(0);
                char pal = in.next().charAt(0);

                if(hm.containsKey(num)) puntos+=hm.get(num);
                if(pal=='C')C++;
                if(pal=='D')D++;
                if(pal=='P')P++;
                if(pal=='T')T++;

            }

            if(C==2)puntos+=1;
            if(C==1)puntos+=2;
            if(C==0)puntos+=3;
            if(D==2)puntos+=1;
            if(D==1)puntos+=2;
            if(D==0)puntos+=3;
            if(P==2)puntos+=1;
            if(P==1)puntos+=2;
            if(P==0)puntos+=3;
            if(T==2)puntos+=1;
            if(T==1)puntos+=2;
            if(T==0)puntos+=3;


            System.out.println(puntos);
            

        }
    }
}
