/** Compute nCr % p
 Problem Description
 Given three integers A, B and C, where Arepresents n, B represents r and C represents p and p is a PRIME NUMBER greater than n,
 find and return the value of nCr % p where nCr % p = (n! / ((n-r)! * r!)) % p. x! means factorial of x i.e.
 x! = 1 * 2 * 3... * x.


 Problem Constraints
 1 <= A <= 10^6
 1 <= B <= A
 A <= C <= 10^9+7



 Input Format
 The first argument given is the integer A ( = n). The second argument given is the integer B ( = r).
 The third argument given is the integer C ( = p).


 Output Format
 Return the value of nCr % m.
 *
 */

package Maths;

import java.math.BigInteger;

public class Binomial_Coefficient {
    public static void main(String[] args) {
//        int A = 47;
//        int B = 36;
//        int C = 283;
        int A = 149;
        int B = 12;
        int C = 48157;
        System.out.println(nCrModPFermat(A,B,C));
    }

    // Using Fermat Little Theorem and Controlling Overflow
    static int nCrModPFermat(int n, int r, int p) {
        if (r == 0)
            return 1;
        // Fill factorial array so that we
        // can find all factorial of r, n
        // and n-r
        long[] fac =  new long [n+1];
        fac[0] = 1;

        for (int i = 1 ;i <= n; i++)
            fac[i] = (fac[i-1] * i) % p;

        return (int)((fac[n]* modInverse(fac[r], p) % p * modInverse(fac[n-r], p) % p) % p);
    }

    // Returns n^(-1) mod p
    static int modInverse(long n, int p){
        return power(n, p-2, p);
    }

    static int power(long x, int y, int p) {
        long res = 1;
        // Update x if it is more than or equal to p
        x = x % p;
        while (y > 0){
            // If y is odd, multiply x  with result
            if (y % 2 == 1)
                res = (res * x) % p;
            // y must be even now
            y = y >> 1; // y = y/2
            x = (x * x) % p;
        }
        return (int)res;
    }

    // Using LUCAS THEOREM https://www.geeksforgeeks.org/compute-ncr-p-set-2-lucas-theorem/
    static int nCrModpLucas(int n, int r, int p) {
        if (r==0)
            return 1;
        if(n==r) return 0;

        int ni = n%p;
        int ri = r%p;
        return (nCrModpLucas(n/p, r/p, p) * // Last digits of n and r
                binomial_using_DP(ni, ri, p)) % p; // Remaining digits
    }

    private static int binomial_using_DP(int A, int B, int C) {
        int res[] = new int[B + 1];

        res[0] = 1;
        for (int i = 1; i <= A; i++){
            for (int j = Math.min(i, B); j > 0; j--)
                res[j] = (res[j] + res[j-1])%C;
        }
        return res[B];
    }


    private static int binomial_Of_Small_Number(int A, int B, int C) {
        int res = 1;
        if ( B > A - B )
            B = A - B;
        for (int i = 0; i < B; ++i) {
            res *= (A - i);
            res = (res/(i + 1));
        }
        return res%C;
    }
    private static int binomial_BigInteger(int a, int b, int C) {
        BigInteger res = BigInteger.ONE;
        // Since C(n, k) = C(n, n-k)
        BigInteger A = new BigInteger(String.valueOf(a));
        BigInteger B = new BigInteger(String.valueOf(b));
        if ( B.compareTo(A.subtract(B)) == 1 )
            B = A.subtract(B);
        for (int i = 0; B.compareTo(new BigInteger(String.valueOf(i)))==1; ++i) {
            res = res.multiply(A.subtract(new BigInteger(String.valueOf(i))));
            res = res.divide(new BigInteger(String.valueOf(i + 1)));
            System.out.println("i = "+i+" Res = "+res);
        }
        return res.mod(new BigInteger(String.valueOf(C))).intValue();
    }

}
