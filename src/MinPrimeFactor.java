import java.util.ArrayList;
import java.util.Arrays;

/** Prime Factors
 You are given A queries. For each query(1<=i<=A) you are given a prime number B[i],
 you need to give the count of all numbers in range 1 to 10^6 inclusive which have minimum prime factor B[i] for each query.
 *
 * Example Input
 * A=1
 * B=[11]
 *
 * Example Output
 * 20779
 *
 * Example Explanation
 * The numbers with minimum prime factor as 11 are: 11, 121, 143, ...
 */
public class MinPrimeFactor {
    final static int VAL = 1000000;
    public static void main(String[] args) {
        int A = 1;
        int[] B = {11};
        int[] result = solve(A,B);
        for(int i=0; i<result.length; i++){
            System.out.println(result[i]);
        }
    }
    public static int[] solve(int A, int[] B) {
        int[] leastPrime = leastPrimeFactor(VAL);
        Arrays.sort(leastPrime);
        int[] res = new int[A];
        for(int i=0; i<A; i++){
            int left =0, right=0;
            int j = Arrays.binarySearch(leastPrime, B[i]);
            while (leastPrime[j-left]==B[i]) left++;
            while (leastPrime[j+right]==B[i]) right++;
            res[i] = left+right-1;
        }
        return res;
    }

    public static int[] leastPrimeFactor(int n) {
        int[] least_prime = new int[n+1];
        least_prime[1] = 1;

        for (int i = 2; i <= n; i++) {
            if (least_prime[i] == 0) {
                least_prime[i] = i;
                for (int j = 2*i; j <= n; j += i)
                    if (least_prime[j] == 0)
                        least_prime[j] = i;
            }
        }
        return least_prime;
    }
}
