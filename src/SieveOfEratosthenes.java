import java.util.ArrayList;
import java.util.Arrays;

public class SieveOfEratosthenes {
    public static void main(String[] args) {
        int n = 17;
        int[] a = sieveOfEratosthenes(n);
        for(int i=0; i< a.length; i++)
            System.out.print(a[i]+" ");
    }

    static int[] sieveOfEratosthenes(int n) {
        boolean prime[] = new boolean[n+1];
        for(int i=0;i<=n;i++)
            prime[i] = true;

        for(int p = 2; p*p <=n; p++){
            // If prime[p] is not changed, then it is a prime
            if(prime[p] == true){
                // Update all multiples of p
                for(int i = p*p; i <= n; i += p){
                    prime[i] = false;

                }
            }
        }
        int counter = 0;
        for(int i = 2; i <= n; i++){
            if(prime[i] == true) {
                counter++;
            }
        }
        int[] res = new int[counter];
        counter =0;
        for(int i = 2; i <= n; i++){
            if(prime[i] == true) {
                res[counter++] = i;
            }
        }
        return res;
    }

}