import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static final int[] dr = {0,1,0,-1};
    static final int[] dc = {-1,0,1,0};

    static final int INF = 1000000;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t =Integer.parseInt(in.readLine().trim());
        for(int casos = 0;casos<t;casos++){
            StringTokenizer st = new StringTokenizer(in.readLine()," ");
            int alto = Integer.parseInt(st.nextToken());
            int ancho = Integer.parseInt(st.nextToken());
            int[][] grid = new int[alto][ancho];
            Queue<IntTres> cola = new LinkedList<>();
            for(int i=0;i<alto;i++){
                String s = in.readLine();
                for(int j=0;j<ancho;j++){
                    int a=s.charAt(j)-48;
                    if(a==1){
                        grid[i][j]=0;
                        cola.add(new IntTres(i,j,0));
                    }else{
                        grid[i][j]=INF;
                    }
                }
            }
            if (cola.isEmpty()){
                for(int nx=0;nx<alto;nx++){
                    StringBuilder s = new StringBuilder();
                    for(int ny=0;ny<ancho;ny++){
                        s.append(grid[nx][ny]);
                        if(ny==ancho-1) s.append("\n");
                        else s.append(" ");
                    }
                    System.out.print(s);
                }
            }

            while(cola.size()>0){
                IntTres pop = cola.remove();
                for(int r=0;r<4;r++){
                    IntTres aux = new IntTres(pop.i+dr[r],pop.j+dc[r],pop.f+1);
                    if(aux.i<0 || aux.i>alto-1 || aux.j<0 || aux.j>ancho-1) continue;
                    else{
                        if (grid[aux.i][aux.j]>aux.f){
                            grid[aux.i][aux.j]=aux.f;
                            cola.add(aux);
                        }
                    }
                }
            }

            for(int nx=0;nx<alto;nx++){
                StringBuilder s = new StringBuilder();
                for(int ny=0;ny<ancho;ny++){
                    s.append(grid[nx][ny]);
                    if(ny==ancho-1) s.append("\n");
                    else s.append(" ");
                }
                System.out.print(s);
            }
            if(casos!=t-1){
                in.readLine();
            }

        }
    }



    public static class IntTres{
        int i;
        int j;
        int f;

        public IntTres(int x, int y, int z) {
            i=x;
            j=y;
            f=z;
        }
    }
}
