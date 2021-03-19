import java.util.Scanner;
public class main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNextInt()){
            int i=in.nextInt();
            long solucion=0;
            long[]dias=new long[i];
            long[]max=new long[i];
            for(int j=0;j<i;j++){
                dias[j]=in.nextInt();
            }
            for(int s=dias.length-1;s>=0;s--){
                if(s==dias.length-1){
                    max[s]=dias[s];
                }else{
                    if (max[s+1]<dias[s]){
                        max[s]=dias[s];
                    }else{
                        max[s]=max[s+1];
                        solucion=Math.max((int)solucion,(int)(max[s]-dias[s]));
                    }
                }
            }
            System.out.println(solucion);
        }
    }
}