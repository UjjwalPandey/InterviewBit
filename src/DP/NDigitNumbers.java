/*

N digit numbers with digit sum S

Find out the number of N digit numbers, whose digits on being added equals to a given number S.
Note that a valid number starts from digits 1-9 except the number 0 itself. i.e. leading zeroes are not allowed.

Since the answer can be large, output answer modulo 1000000007

**
N = 2, S = 4
Valid numbers are {22, 31, 13, 40}
Hence output 4.
 */
package DP;

public class NDigitNumbers {
    static long[][] lookup;
    static int MOD = 1000000007;
    static long countRec(int n, int sum) {
        if (n == 0)
            return sum == 0 ? 1 : 0;
        if (lookup[n][sum] != -1)
            return lookup[n][sum];
        long ans = 0;
        for (int i=0; i<10; i++)
            if (sum-i >= 0)
                ans = (ans%MOD + countRec(n-1, sum-i)%MOD)%MOD;

        return lookup[n][sum] = ans;
    }

    static int solve(int n, int sum) {
        lookup = new long[n+1][sum+1];
        for(int i = 0; i <= n; ++i){
            for(int j = 0; j <= sum; ++j){
                lookup[i][j] = -1;
            }
        }
        long ans = 0;
        // Handles 0 at MSB
        for (int i = 1; i <= 9; i++)
            if (sum-i >= 0)
                ans = (ans%MOD + countRec(n-1, sum-i)%MOD)%MOD;
        return (int)(ans%MOD);
    }
    public static void main(String[] args) {
        System.out.println(solve(2,4));
        System.out.println(solve(1,3));
    }
}
