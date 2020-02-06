/**
 * Given an integer array A of size N. You have to delete one element such that the GCD(Greatest common divisor) of the remaining array is maximum.
 *
 * Find the maximum value of GCD.
 */

public class MaxGCDByDeletingOneValue {
    public static void main(String[] args) {
        int[] A = {12, 15, 18};
        System.out.println("Maximum value of gcd is "+solve(A));
    }
        public static int solve(int[] A) {
            int n = A.length;
            int Prefix[] = new int[n + 2];
            int Suffix[] = new int[n + 2] ;

            Prefix[1] = A[0];
            for (int i = 2; i <= n; i += 1){
                Prefix[i] = gcd(Prefix[i - 1], A[i - 1]);
            }
            Suffix[n] = A[n - 1];

            for (int i = n - 1; i >= 1; i -= 1) {
                Suffix[i] = gcd(Suffix[i + 1], A[i - 1]);
            }

            int ans = Math.max(Suffix[2], Prefix[n - 1]);

            for (int i = 2; i < n; i += 1)  {
                ans = Math.max(ans, gcd(Prefix[i - 1], Suffix[i + 1]));
            }

            return ans;
        }

        public static int gcd(int a, int b) {
            if (b == 0)
                return a;
            return gcd(b, a % b);
        }
    }
