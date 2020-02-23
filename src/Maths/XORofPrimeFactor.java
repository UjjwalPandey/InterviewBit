package Maths;

import java.util.ArrayList;

public class XORofPrimeFactor {
    public static void main(String[] args) {
        int[] A = {10, 45};
        System.out.println(solve(A));
    }

    private static int solve(int[] A) {
        int sum = 0;
        for(int i=0; i< A.length;i++) {
            sum += xorPrimeFactors(A[i]);

        }
        return sum;
    }

    private static int xorPrimeFactors(int N) {
        int[] sieve = sieveOfEratosthenes(N);
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0; i< sieve.length; i++){
            if(N%sieve[i] == 0){
                arr.add(sieve[i]);
            }
        }
        return xorSumOfAllSubArrays(arr, arr.size());
    }

    static int xorSumOfAllSubArrays(ArrayList<Integer> arr, int n){
        int bits = 0;
        for (int i = 0; i < n; ++i)
            bits |= arr.get(i);
        int ans = bits * (int)Math.pow(2, n-1);
        return ans;
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
