/*
    XOR Prime
    Problem Description
    Given an array A of integers of size N. For each integer in A, there is a set S of the prime factors of that integer.
    There is a good value associated with each number, which is the sum of XOR of all subsets of set S modulo 109+7.  Good Value of the array A is the sum of good values associated with each number modulo 109+7. Return Good Value of A.  Note: Set S has no duplicates.


    Problem Constraints
    1 <= N <= 1000
    1 <= A[i] <= 109


    Input Format
    Single argument is an integer.


    Output Format
    Return the Good Value of A.


    Example Input
    Input 1:
    A = [ 10, 45]



    Example Output
    Output 1:
    28



    Example Explanation
    Explanation 1:
    Prime factors of 10 are 2, 5. Subsets of {2,5} are {},{2},{5},{2,5}. Their corresponding xors are 0,2,5,7.
    Their sum is 0+2+5+7 = 14.  So, good value of 10 is 14.
    Prime factors of 45 are 3, 5. Subsets of {3,5} are {},{3},{5},{3,5}. Their corresponding xors are 0,3,5,6.
    Their sum is 0+3+5+6 = 14.  So, good value of 45 is 14.

    Good Value of array = 14 + 14 = 28.
 */
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
