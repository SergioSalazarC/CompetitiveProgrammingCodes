import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static int[] ns = {0,1,0,-1,1,1,-1,-1};
    public static int[] se = {1,0,-1,0,1,-1,1,-1};



    public static void main(String[] args) throws IOException {
        //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(in.readLine()," ");
        //int f = Integer.parseInt(st.nextToken());
        //int c = Integer.parseInt(st.nextToken());
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {


            int f = in.nextInt();
            int c = in.nextInt();

            char[][] graf = new char[f][c];

            for (int i = 0; i < f; i++) {
                //String aux = in.readLine();
                String aux = in.next().trim();
                for (int j = 0; j < c; j++) {
                    char auxx = aux.charAt(j);
                    if (auxx == '-') auxx = 'X';
                    graf[i][j] = auxx;
                }
            }
            //int casos = Integer.parseInt(in.readLine());
            int casos = in.nextInt();

            boolean finish = true;

            for (int i = 0; i < casos; i++) {
                //st = new StringTokenizer(in.readLine()," ");
                //int f1 = Integer.parseInt(st.nextToken())-1;
                //int c1 = Integer.parseInt(st.nextToken())-1;
                int f1 = in.nextInt() - 1;
                int c1 = in.nextInt() - 1;

                Queue<IntPair> cola = new LinkedList();
                cola.add(new IntPair(f1, c1));
                while (cola.size() > 0 && finish) {

                    IntPair pop = cola.remove();
                    if (!(pop.f < f && pop.f >= 0 && pop.c < c && pop.c >= 0)) continue;
                    if (graf[pop.f][pop.c] == '*') {
                        finish = false;
                    }
                    if (graf[pop.f][pop.c] != 'X') continue;
                    else {
                        int cont = 0;
                        ArrayList<IntPair> al = new ArrayList<>();
                        for (int s = 0; s < 8; s++) {
                            int faux = pop.f + ns[s];
                            int caux = pop.c + se[s];
                            if (faux < f && faux >= 0 && caux < c && caux >= 0) {
                                char ady = graf[faux][caux];
                                if (ady == '*') cont++;
                                if (ady == 'X') {
                                    al.add(new IntPair(faux, caux));
                                }
                            }

                        }
                        if (cont == 0) {
                            graf[pop.f][pop.c] = '-';
                            while (!al.isEmpty()) {
                                cola.add(al.remove(0));
                            }
                        } else {
                            graf[pop.f][pop.c] = (char) (cont + 48);
                        }
                    }
                }
            }
            if (finish) {
                for (int i = 0; i < f; i++) {
                    for (int j = 0; j < c; j++) {
                        if (graf[i][j] == '*') System.out.print('X');
                        else System.out.print(graf[i][j]);
                    }
                    System.out.println();
                }
            } else {
                System.out.println("GAME OVER");
            }
        }
    }


    public static class IntPair{
        public int f;
        public int c;

        public IntPair(int a, int b){
            f=a;
            c=b;
        }


    }


}