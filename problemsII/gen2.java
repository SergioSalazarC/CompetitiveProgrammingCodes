public class gen2 {
    public static void main(String[] args) {
        long aux=0;
        for (int i = 0; i < 8500; i++) {
            aux+=i*i;
            System.out.println("mem["+i+"] = "+aux);
        }
    }
}
