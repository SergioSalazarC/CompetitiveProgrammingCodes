import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static char[][] grid;
    public static int eo;
    public static int ns;

    public static boolean pintar(int x, int y){
        int s = grid[x][y]-48;
        boolean salida=true;

        for(int i=1;i<=s && salida;i++){
            if(y+i<ns){
                char aux =grid[x][y+i];
                if(aux=='E' || aux=='P'){
                    salida=false;
                    break;
                }
                else if(aux=='#'){
                    break;
                }
                else if(aux=='.'){
                    grid[x][y+i]='?';
                }
            }
            else{
                break;
            }
        }

        for(int i=1;i<=s && salida;i++){
            if(x+i<eo){
                char aux =grid[x+i][y];
                if(aux=='E' || aux=='P'){
                    salida=false;
                    break;
                }
                else if(aux=='#'){
                    break;
                }
                else if(aux=='.'){
                    grid[x+i][y]='?';
                }
            }
            else{
                break;
            }
        }

        for(int i=1;i<=s && salida;i++){
            if(y-i>=0){
                char aux =grid[x][y-i];
                if(aux=='E' || aux=='P'){
                    salida=false;
                    break;
                }
                else if(aux=='#'){
                    break;
                }
                else if(aux=='.'){
                    grid[x][y-i]='?';
                }
            }
            else{
                break;
            }
        }

        for(int i=1;i<=s && salida;i++){
            if(x-i>=0){
                char aux =grid[x-i][y];
                if(aux=='E' || aux=='P'){
                    salida=false;
                    break;
                }
                else if(aux=='#'){
                    break;
                }
                else if(aux=='.'){
                    grid[x-i][y]='?';
                }
            }
            else{
                break;
            }
        }


        return salida;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        int[] a = {1,0,-1,0};
        int[] b= {0,1,0,-1};
        for(int i=0;i<t;i++){
            StringTokenizer st = new StringTokenizer(in.readLine()," ");
            eo = Integer.parseInt(st.nextToken());
            ns = Integer.parseInt(st.nextToken());
            HashSet<int[]> alarmas = new HashSet();
            boolean salida=true;
            grid = new char[eo][ns];
            IntPair entrada = null ;
            for(int j=0;j<ns;j++){
                String k = in.readLine();
                for(int m=0;m<eo;m++){
                    grid[m][j]=k.charAt(m);
                    if(k.charAt(m)>=48 && k.charAt(m)<=57){
                        int[] s=new int[2];
                        s[0]=m;
                        s[1]=j;
                        alarmas.add(s);
                    }
                    if(k.charAt(m)=='E'){
                        entrada = new IntPair(m,j);
                    }
                }
            }
            for(int[] p: alarmas){
                salida = salida && pintar(p[0],p[1]);
            }

            Queue<IntPair> cola = new LinkedList();
            cola.add(null);
            cola.add(entrada);
            int pisos=0;
            int sol=-1;

            if(!salida){
                System.out.println("NO");
            }
            else{
                while(cola.size()>1 && sol==-1){
                    IntPair pop = cola.remove();
                    if(pop==null){
                        cola.add(null);
                        pisos++;
                    }
                    else{
                        for(int j=0;j<4;j++){
                            IntPair nuevo = new IntPair(pop.a+a[j],pop.b+b[j]);
                            if(nuevo.a>=0 &&  nuevo.a <eo && nuevo.b>=0 && nuevo.b < ns){
                                if(grid[nuevo.a][nuevo.b]=='.'){
                                    cola.add(nuevo);
                                    grid[nuevo.a][nuevo.b]='E';
                                }
                                else if(grid[nuevo.a][nuevo.b]=='P'){
                                    sol=pisos;
                                    break;
                                }
                            }
                        }
                    }
                }

                if(sol==-1){
                    System.out.println("NO");
                }else{
                    System.out.println(sol);
                }

            }

        }

    }


    public static class IntPair{
        public int a;
        public int b;

        public IntPair(int x, int y){
            a=x;
            b=y;
        }
    }

}