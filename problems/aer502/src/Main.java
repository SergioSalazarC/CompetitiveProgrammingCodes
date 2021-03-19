import java.util.Scanner;
public class main {
    public static int binaria(int[] montones,int aux,int mejillon){
        int ini=0;
        int fin=aux;
        int medio;
        while(ini<fin){
            medio=(ini+fin)/2;
            if(montones[medio]>mejillon){
                fin=medio;
            }else{
                ini=medio+1;
            }
        }
        return(fin);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n=in.nextInt();
            int[] montones= new int[n];
            int aux=1;
            montones[0]=in.nextInt();
            for(int k=1;k<n;k++){
                int mejillon=in.nextInt();
                if(mejillon>=montones[aux-1]){
                    montones[aux]=mejillon;
                    aux++;
                }else{
                    montones[binaria(montones,aux,mejillon)]= mejillon;
                }
            }
            System.out.println(aux);
        }
    }
}