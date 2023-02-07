

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class aer210 {

    static ArrayList<Integer> primos;

    public static int sttoint(String aux){
        int sum = 0;
        for (int i = 0; i < aux.length(); i++) {
            sum += aux.charAt(i);
        }
        return sum;
    }

    static ArrayList<Integer> sieveOfErastosthenes(int n){
        boolean prime[] = new boolean[n+1];
        ArrayList<Integer>out = new ArrayList<>();
        for(int p=2; p*p<=n; p++)
            if(!prime[p]) {
                for (int i = p * p; i <= n; i += p)
                    prime[i] = true;
            }
        //Metemos los primos a una lista. prime[p] es falso si p es primo.
        for(int i=2; i<=n; i++)
            if(!prime[i])
                out.add(i);
        return out;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        primos = sieveOfErastosthenes(13001);
        while(n-->0){
            int val = sttoint(in.readLine().trim());
            int pos = Collections.binarySearch(primos,val);
            if(pos<0) pos = (-pos)-1;
            pos--;

            System.out.println(primos.get(pos));


        }
    }
}
