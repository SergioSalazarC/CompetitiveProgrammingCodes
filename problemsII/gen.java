public class gen {
    public static void main(String[] args) {
        for (int sdf = 0; sdf < 1; sdf++) {
            int n=4000;
            int[] aux = new int[n+1];
            for (int i = 0; i < n+1; i++) {
                aux[i] = (int) (Math.random()*100000);
            }


            //int t = (int) (Math.random()*20000)+30000;
            //int s =(int) (Math.random()*20000)+30000;
            int t = 50000;
            int s = 50000;
            System.out.println(n+" "+t+" "+s);
            for (int i = 0; i < t; i++) {
                int k = (int) (Math.random()*2+1);
                if(k==1){
                    int alm = (int) (Math.random()*n);
                    System.out.println(k+" "+alm+" "+aux[alm]);
                }
                else{
                    k=2;
                    int alm = (int) (Math.random()*n);
                    int alm2 = (int) (Math.random()*n);
                    int auxs = aux[alm]+aux[alm2];
                    System.out.println(k+" "+alm+" "+alm2+" "+auxs);
                }
            }

            for (int i = 0; i < s; i++) {
                int k = (int) (Math.random()*2+1);
                if(k==1){
                    int alm = (int) (Math.random()*n);
                    System.out.println(k+" "+alm);
                }
                else{
                    k=2;
                    int alm = (int) (Math.random()*n);
                    int alm2 = (int) (Math.random()*n);
                    System.out.println(k+" "+alm+" "+alm2);
                }
            }
            System.out.println("0 0 0");
            //System.out.println(s);
        }

    }
}
