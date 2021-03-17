import java.util.Scanner;

public class Main2 {
    public static int difusion(int x, int y, char c1, char c2,int maxx, int maxy, char[][] grid){
        if(x<0 || x>=maxx || y<0 || y>=maxy) return 0;
        if(grid[y][x] != c1) return 0;
        int aux=1;
        grid[y][x]=c2;
        aux += difusion(x+1,y,c1,c2,maxx,maxy,grid) + difusion(x-1,y,c1,c2,maxx,maxy,grid)+ difusion(x,y+1,c1,c2,maxx,maxy,grid)+ difusion(x,y-1,c1,c2,maxx,maxy,grid);
        return aux;

    }
    public static void main(String[] args) {

        Scanner in= new Scanner(System.in);

        while(in.hasNext()){
            int y=in.nextInt();
            int x=in.nextInt();
            char[][] grid = new char[y][x];
            in.nextLine();
            for(int i=0;i<y;i++){
                String aux=in.nextLine();
                for(int j=0;j<x;j++){
                    grid[i][j]=aux.charAt(j);
                }

            }
            int maximo=0;
            for(int i=0;i<y;i++){
                for(int j=0;j<x;j++){
                    if(grid[i][j]=='#') maximo=Math.max(maximo,difusion(j,i,'#',' ',x,y,grid));
                }
            }
            System.out.println(maximo);
        }
    }
}