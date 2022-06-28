import java.util.Arrays;
import java.util.Scanner;

public class aer606 {
    static int n;
    static int[] lista;

    // Binary search (note boundaries in the caller)
    // A[] is ceilIndex in the caller
    static int CeilIndex(int A[], int l, int r, int key)
    {
        while (r - l > 1) {
            int m = l + (r - l) / 2;
            if (A[m] >= key)
                r = m;
            else
                l = m;
        }

        return r;
    }

    static int LongestIncreasingSubsequenceLength(int A[], int size)
    {
        // Add boundary case, when array size is one

        int[] tailTable = new int[size];
        int len; // always points empty slot

        tailTable[0] = A[0];
        len = 1;
        for (int i = 1; i < size; i++) {
            if (A[i] < tailTable[0])
                // new smallest value
                tailTable[0] = A[i];

            else if (A[i] > tailTable[len - 1])
                // A[i] wants to extend largest subsequence
                tailTable[len++] = A[i];

            else
                // A[i] wants to be current end candidate of an existing
                // subsequence. It will replace ceil value in tailTable
                tailTable[CeilIndex(tailTable, -1, len - 1, A[i])] = A[i];
        }

        return len;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n=in.nextInt();
        while(n!=0){
            lista = new int[n];
            for(int i = 0;i<n;i++){
                lista[i]=in.nextInt();
            }
            System.out.println(LongestIncreasingSubsequenceLength(lista,n));
            n=in.nextInt();
        }

    }
}
