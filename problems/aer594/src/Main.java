import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static char[][] grafo;
    public static int ancho=0;
    public static int alto=0;
    public static int iniciox=0;
    public static int inicioy=0;
    public static int[] x = {1,0,-1,0};
    public static int[] y = {0,1,0,-1};

    public static void impstado(int x, int y){
        int aux=alto-y-1;
        for(int i=alto-1;i>=0;i--){
            for(int j=0;j<ancho;j++){
                if(i==y && j==x) System.out.print("P");
                else System.out.print(grafo[j][i]);
            }
            System.out.println();
        }

    }

    public static int manoderecha(){
        Queue<IntT> cola = new LinkedList<>();
        cola.add(new IntT(iniciox,inicioy,1));
        int cont=0;
        while(!cola.isEmpty()){
            IntT pop=cola.remove();
            //impstado(pop.x,pop.y);

            if(pop.x==iniciox && pop.y==inicioy && cont>0){
                return -1;
            }
            if(grafo[pop.x][pop.y]=='T'){
                return cont;
            }
            if(grafo[pop.x+x[(pop.d-1+4)%4]][pop.y+y[(pop.d-1+4)%4]]=='#'){
                if(!(pop.x+x[pop.d] >= 0 && pop.x+x[pop.d]<ancho && pop.y+y[pop.d]>=0 && pop.y+y[pop.d]<alto))continue;
                if(grafo[pop.x+x[pop.d]][pop.y+y[pop.d]]=='#'){
                    cola.add(new IntT(pop.x,pop.y,(pop.d+1)%4));
                }
                /*
                else if(grafo[pop.x][pop.y]=='T'){
                    return cont;
                }
                */
                else{
                    cola.add(new IntT(pop.x+x[pop.d],pop.y+y[pop.d],pop.d));
                    cont++;
                }
            }
            else{
                if(!(pop.x+x[(pop.d-1+4)%4] >= 0 && pop.x+x[(pop.d-1+4)%4]<ancho && pop.y+y[(pop.d-1+4)%4]>=0 && pop.y+y[(pop.d-1+4)%4]<alto))continue;
                cola.add(new IntT(pop.x+x[(pop.d-1+4)%4],pop.y+y[(pop.d-1+4)%4],(pop.d-1+4)%4));
                cont++;
            }
        }
        return -1;
    }

    public static int inteligente(){
        boolean[][] visitados = new boolean[ancho][alto];
        Queue<IntT> cola = new LinkedList<>();
        cola.add(new IntT(iniciox,inicioy,-1));
        visitados[iniciox][inicioy]=true;
        cola.add(null);
        int cont=0;
        while(cola.size() > 1){
            IntT pop=cola.remove();
            if(pop == null){
                cola.add(null);
                cont++;
                continue;
            }
            for(int i=0;i<4;i++){
                if(pop.x+x[i] >= 0 && pop.x+x[i]<ancho && pop.y+y[i]>=0 && pop.y+y[i]<alto){
                    if(visitados[pop.x+x[i]][pop.y+y[i]]){
                       continue;
                    }
                    if(grafo[pop.x+x[i]][pop.y+y[i]] == '.'){
                        cola.add(new IntT(pop.x+x[i],pop.y+y[i],-1));
                        visitados[pop.x+x[i]][pop.y+y[i]]=true;
                    }
                    if(grafo[pop.x+x[i]][pop.y+y[i]] == 'T'){
                        visitados[pop.x+x[i]][pop.y+y[i]]=true;
                        return cont+1;
                    }
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String sig = in.readLine();
        while(sig!=null){
            StringTokenizer st = new StringTokenizer(sig," ");
            ancho = Integer.parseInt(st.nextToken());
            alto = Integer.parseInt(st.nextToken());
            grafo=new char[ancho][alto];
            iniciox=-1;
            inicioy=0;
            for(int i=alto-1;i>=0;i--){
                String p = in.readLine();
                for(int j=ancho-1;j>=0;j--){
                    grafo[j][i]=p.charAt(j);
                    if(i==0 && p.charAt(j)=='.'){
                        iniciox=j;
                    }
                }
            }
            int t =inteligente();
            int md=manoderecha();

            if(t==-1){
                System.out.println("IMPOSIBLE");
            }else{
                if(t==md) System.out.println("IGUAL");
                else if(md==-1) System.out.println("INF");
                else System.out.println(md-t);
            }

            sig = in.readLine();


        }
    }

    public static class IntT{
        int x;
        int y;
        int d;

        public IntT(int x,int y, int d){
            this.x=x;
            this.y=y;
            this.d=d;

        }
    }


}
