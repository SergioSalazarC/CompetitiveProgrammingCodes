import java.util.*;

public class aer583 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int casos = in.nextInt();
        for(int i=0;i<casos;i++){
            long comp = in.nextLong();
            long otra =in.nextLong();
            double p = ((comp-(comp+otra)/2) * 100)/((comp+otra)/2);
            long aux= (long) p;
            System.out.println(aux);
        }

    }

}