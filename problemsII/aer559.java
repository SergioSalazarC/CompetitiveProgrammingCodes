import java.util.*;

public class aer559 {
    public static List<IntPair> getSkyline(long[][] buildings) {
        int n = buildings.length;
        List<IntPair> salida = new ArrayList<IntPair>();

        if (n == 0) return salida;
        if (n == 1) {
            long xStart = buildings[0][0];
            long xEnd = buildings[0][1];
            long y = buildings[0][2];

            salida.add(new IntPair(xStart,y));
            salida.add(new IntPair(xEnd,0));
            return salida;
        }

        List<IntPair> leftSkyline, rightSkyline;
        leftSkyline = getSkyline(Arrays.copyOfRange(buildings, 0, n / 2));
        rightSkyline = getSkyline(Arrays.copyOfRange(buildings, n / 2, n));

        return mergeSkylines(leftSkyline, rightSkyline);
    }

    public static List<IntPair> mergeSkylines(List<IntPair> left, List<IntPair> right) {
        long nL = left.size(), nR = right.size();
        int pL = 0, pR = 0;
        long currY = 0, leftY = 0, rightY = 0;
        long x, maxY;
        ArrayList<IntPair> salida = new ArrayList<IntPair>();
        while ((pL < nL) && (pR < nR)) {
            IntPair pointL = left.get(pL);
            IntPair pointR = right.get(pR);
            if (pointL.ini < pointR.ini) {
                x = pointL.ini;
                leftY = pointL.alt;
                pL++;
            }
            else {
                x = pointR.ini;
                rightY = pointR.alt;
                pR++;
            }
            maxY = Math.max(leftY, rightY);
            if (currY != maxY) {
                updateOutput(salida, x, maxY);
                currY = maxY;
            }
        }

        appendSkyline(salida, left, pL, nL, currY);

        appendSkyline(salida, right, pR, nR, currY);

        return salida;
    }

    public static void updateOutput(List<IntPair> output, long x, long y) {
        if (output.isEmpty() || output.get(output.size() - 1).ini != x)
            output.add(new IntPair(x,y));
        else {
            output.get(output.size() - 1).setAlt(y);
        }
    }

    public static void appendSkyline(List<IntPair> output, List<IntPair> skyline, int p, long n, long currY) {
        while (p < n) {
            IntPair point = skyline.get(p);
            long x = point.ini;
            long y = point.alt;
            p++;

            if (currY != y) {
                updateOutput(output, x, y);
                currY = y;
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        while (size != 0) {
            int q = in.nextInt();
            long [][] pintadas = new long[q][3];
            for (int i = 0; i < q; i++) {
                pintadas[i][0]=in.nextLong();
                pintadas[i][2]=in.nextLong();
                pintadas[i][1]=pintadas[i][0]+size;
            }

            List<IntPair> sl = getSkyline(pintadas);
            long area=0;
            for(int j=0;j<sl.size()-1;j++){
                long a = sl.get(j).ini;
                long alt = sl.get(j).alt;
                long b = sl.get(j + 1).ini;

                area+=((b-a)*alt);
            }
            System.out.println(area);

            size=in.nextInt();

        }
    }

    public static class IntPair implements Comparable{
        long ini;
        long alt;

        public IntPair(long i, long a){
            ini=i;
            alt=a;
        }

        public void setAlt(long alt) {
            this.alt = alt;
        }

        public void set(long i, long a){
            this.ini=i;
            this.alt=a;
        }

        @Override
        public int compareTo(Object o) {
            IntPair i = (IntPair) o;
            return (int) (this.ini-i.ini);
        }
    }




}