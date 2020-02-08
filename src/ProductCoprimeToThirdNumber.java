import java.math.BigInteger;

/** You are given 2 arrays A and B of size N and M respectively and a number K.
 * You have to tell that how many pairs (A[i], B[j]) (1 <= i <= N and 1 <= j <= m) exists such that
 * product of them is not CoPrime with K
*/
public class ProductCoprimeToThirdNumber {
    public static void main(String[] args) {
//        int[] A = {1, 2, 3};
//        int[] B = {2, 3, 4, 5};
//        int K = 3;

        int[] A = {81, 90, 70, 30, 94, 32, 89, 33, 84, 18, 48, 87, 23, 59, 67, 76, 43, 75, 5, 3, 47, 36, 39, 8, 89, 11, 21, 70, 11, 78, 27, 93, 98, 93, 47, 59, 50, 40, 74, 15, 87, 42, 68, 93, 27, 71, 23, 89, 43, 6, 40, 25, 77, 90, 3, 39, 44, 86, 59, 44, 74, 54, 51, 57, 26, 46, 7, 12, 89, 50, 24, 42, 31, 94, 51, 15, 72, 31, 90, 45, 79, 38, 30, 27, 22, 26, 50, 7, 99, 80, 56, 69, 43, 78, 17, 11, 4, 19, 49, 30, 15, 90, 48, 4, 67, 32, 28, 95, 32, 52, 21, 80, 14, 26, 57, 38, 69, 49, 74, 41, 50, 14, 75, 92, 27, 40, 65, 16, 11, 60, 16, 12, 19, 28, 75 };
        int[] B = {10, 18, 1, 77, 25, 53, 29, 12, 34, 90, 75, 43, 32, 100, 42, 91, 87};
        int K = 79;
        System.out.println(solve(A,B,K));
    }
    public static int solve(int[] A, int[] B, int C) {
        int countA = 0;
        int countB = 0;
        int N = A.length;
        int M = B.length;
        System.out.println("N = "+N+" M = "+M+" Product = "+N*M);
        for(int i=0; i<N; i++){
            if(gcd(A[i], C) == 1) {
                countA++;
            }
        }
        for(int i=0; i<M; i++){
            if(gcd(B[i], C) == 1) {
                countB++;
            }
        }
        return N*M - countA*countB;
    }

    public static int gcd(int A, int B) {
        BigInteger big1= new BigInteger(String.valueOf(A));
        BigInteger big2= new BigInteger(String.valueOf(B));
        BigInteger  bigVal= big1.gcd(big2);
        return bigVal.intValue();
    }
}
