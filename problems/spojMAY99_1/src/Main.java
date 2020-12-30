import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int[] dx={1,0,-1,0};
    public static int[] dy={0,-1,0,1};

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(in.readLine(), " ");
        int largo=Integer.parseInt(st.nextToken());
        int ancho=Integer.parseInt(st.nextToken());
        char[][] maze =new char[ancho][largo];
        int[][] toml=new int[ancho][largo];
        int[][] jerryl=new int[ancho][largo];

        Queue<IntPair> tom = new LinkedList<>();
        Queue<IntPair> jerry = new LinkedList<>();
        tom.add(null);
        jerry.add(null);
        int jx=-1;
        int jy=-1;
        int tx=-1;
        int ty=-1;
        for(int i=0;i<largo;i++){
            String next =in.readLine();
            for(int j=0;j<ancho;j++){
                maze[j][i]=next.charAt(j);
                if(maze[j][i]=='J'){
                    jerryl[j][i]=-1;
                    jerry.add(new IntPair(j,i));
                    jx=j;
                    jy=i;
                }
                if(maze[j][i]=='T'){
                    toml[j][i]=-1;
                    tom.add(new IntPair(j,i));
                    tx=j;
                    ty=i;
                }
            }
        }
        int tomsize=0;
        int jerrysize=0;

        while(tom.size()>1){
            IntPair pop =tom.remove();
            if(pop==null){
                tomsize++;
                tom.add(null);
            }else{
                for(int i=0;i<4;i++){
                    IntPair newpop = new IntPair(pop.x+dx[i],pop.y+dy[i]);
                    if(newpop.x<0||newpop.x>=ancho||newpop.y<0||newpop.y>=largo) continue;
                    else{
                        if(toml[newpop.x][newpop.y]==0 && (maze[newpop.x][newpop.y]=='.' || maze[newpop.x][newpop.y]=='J')){
                            toml[newpop.x][newpop.y]=tomsize;
                            tom.add(newpop);
                        }
                    }
                }
            }

        }

        while(jerry.size()>1){
            IntPair pop =jerry.remove();
            if(pop==null){
                jerrysize++;
                jerry.add(null);
            }else{
                for(int i=0;i<4;i++){
                    IntPair newpop = new IntPair(pop.x+dx[i],pop.y+dy[i]);
                    if(newpop.x<0||newpop.x>=ancho||newpop.y<0||newpop.y>=largo) continue;
                    else{
                        if(jerryl[newpop.x][newpop.y]==0 && (maze[newpop.x][newpop.y]=='.' || maze[newpop.x][newpop.y]=='T')){
                            jerryl[newpop.x][newpop.y]=jerrysize;
                            jerry.add(newpop);
                        }
                    }
                }
            }

        }


        int max=10000;

        for(int i=0;i<ancho;i++){
            if(toml[i][0]-jerryl[i][0]>0 && jerryl[i][0]!=-1) max=Math.min(max,jerryl[i][0]);
            if(toml[i][largo-1]-jerryl[i][largo-1]<0 && jerryl[i][largo-1]!=-1) max=Math.min(max,jerryl[i][largo-1]);
        }
        for(int i=0;i<largo;i++){
            if(toml[0][i]-jerryl[0][i]>0 && jerryl[0][i]!=-1)max=Math.min(max,jerryl[i][0]);
            if(toml[ancho-1][i]-jerryl[ancho-1][0]<0 && jerryl[0][ancho-1]!=-1) max=Math.min(max,jerryl[ancho-1][0]);
        }

        if(max>0) System.out.println("J "+max);
        else{
            System.out.println("T "+toml[jx][jy]);
        }

    }

    public static class IntPair{
        int x;
        int y;

        public IntPair(int a, int b){
            x=a;
            y=b;
        }
    }
}
