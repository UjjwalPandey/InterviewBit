/* Given an integer A. Compute and return the square root of A. If A is not a perfect square, return floor(sqrt(A)).
    DO NOT USE SQRT FUNCTION FROM STANDARD LIBRARY.
    Problem Constraints
    1 <= A <= 10^9


    Input Format
    The first and only argument given is the integer A.

    Output Format
    Return floor(sqrt(A))

    Example Input
    Input 1:
    11
    Input 2:
    9

    Example Output
    Output 1:
    3
    Output 2:
    3

    Example Explanation
    Explanation:
    When A = 11 , square root of A = 3.316. It is not a perfect square so we return the floor which is 3.
    When A = 9 which is a perfect square of 3, so we return 3.

 */
package Binary_Search;

public class SquareRootOfInteger {
    public static void main(String[] args) {
        int A = 1025;
        int B = 2147483647; // 46340
        int C = 268411586; // 16383
        System.out.println(sqrt_binarySearch(A));
        System.out.println(sqrt_binarySearch(B));
        System.out.println(sqrt_binarySearch(C));
    }
    public static int sqrt_binarySearch(int x) {
        // Base Cases
        if (x == 0 || x == 1)
            return x;
        // Do Binary Search for floor(sqrt(x))
        long start = 1, end = x, ans = 0;
        while (start <= end) {
            long mid = (start + end) / 2;
            // If x is a perfect square
            if (mid * mid == x)
                return (int)mid;
            // Since we need floor, we update answer when mid*mid is
            // smaller than x, and move closer to sqrt(x)
            if (mid * mid < x) {
                start = mid + 1;
                ans = mid;
            } else   // If mid*mid is greater than x
                end = mid - 1;
        }
        return (int)ans;
    }

    public static int sqrt(int A) {
        if(A<2) return A;
        int num = (int)(Math.log(A) /Math.log(2));
        double i= (int)Math.pow(2,num/2);
        while(i< Math.pow(2,(num/2)+1)){
            if(i*i > A) break;
            i++;
        }
//        System.out.println(num+" "+A+" "+i);

        return (int)i - 1;
    }
}
