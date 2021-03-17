import java.util.*;

public class Main2 {
    public static void main(String[] args) {

        Scanner in= new Scanner(System.in);
        int calles=in.nextInt();
        while(calles!=0){
            int casas=in.nextInt();
            ArrayList<Integer>[] grafo =new ArrayList[casas];
            for(int i=0;i<calles;i++){
                int a=in.nextInt()-1;
                int b=in.nextInt()-1;
                if(grafo[a]==null){
                    grafo[a]= new ArrayList<>();
                }
                if(grafo[b]==null){
                    grafo[b] = new ArrayList<>();
                }
                grafo[a].add(b);
                grafo[b].add(a);
            }

            int impar =0;
            for(int j=0;j<casas && impar<3;j++){
                if(grafo[j].size()%2==1) impar++;
            }
            if(impar==2 || impar==0) System.out.println("SI");
            else System.out.println("NO");
            calles=in.nextInt();
        }
    }
}