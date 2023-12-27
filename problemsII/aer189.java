import java.util.*;

public class aer189 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n, k, val;
        while ((n = in.nextInt()) != 0) {
            Map<Integer, Integer> mapa = new HashMap<>();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                val = in.nextInt();
                arr[i] = val;
                mapa.put(val, (mapa.containsKey(val) ? mapa.get(val) + 1 : 1));
            }
            String query;
            k = in.nextInt();
            for (int i = 0; i < k; i++) {
                query = in.next();
                val = in.nextInt();
                if (query.equals("EMBARQUE")) {
                    System.out.println(n - (mapa.containsKey(val) ? mapa.get(val) : 0));
                    int j = 0;
                    for (int m : arr) {
                        if (m == val) continue;
                        arr[j] = m;
                        j++;
                    }
                    n -= (mapa.containsKey(val) ? mapa.get(val) : 0);
                    mapa.put(val,0);
                } else {
                    System.out.println(arr[val - 1]);
                }
            }
            System.out.println("*");
        }
    }
}
