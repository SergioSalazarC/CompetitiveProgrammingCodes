public class gen {
    public static void main(String[] args) {
        System.out.println(50176);
        int s=0;
        for (int i = -2; i < 2; i++) {
            for (int j = -2; j < 2; j++) {
                for (int k = -2; k < 2; k++) {
                    for (int l = -2; l < 2; l++) {
                        for (int m = -2; m < 2; m++) {
                            for (int n = -2; n < 2; n++) {
                                for (int o = m; o < 3; o++) {
                                    for (int p = n; p < 3; p++) {
                                        s++;
                                        System.out.println(i+" "+j+" "+k+" "+l+" "+m+" "+n+" "+o+" "+p);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        //System.out.println(s);
    }
}
