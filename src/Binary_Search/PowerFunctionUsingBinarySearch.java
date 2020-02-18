/* Implement pow(x, n) % d.

    In other words, given x, n and d,
        find (xn % d)

    Note that remainders on division cannot be negative.
    In other words, make sure the answer you return is non negative.

    Input : x = 2, n = 3, d = 3
    Output : 2

    2^3 % 3 = 8 % 3 = 2

 */
package Binary_Search;

public class PowerFunctionUsingBinarySearch {
    public static void main(String[] args) {
        System.out.println(pow(-1,1,20));  // 19
        System.out.println(pow(79161127, 99046373, 57263970));  //  47168647
        System.out.println(pow(71045970, 41535484, 64735492));  //  20805472
    }

    /* optimized pow Function to O(logn) by calculating power(x, y/2) only once and storing it.

    int power(int x, unsigned int y)
    {
        int temp;
        if( y == 0)
            return 1;
        temp = power(x, y/2);
        if (y%2 == 0)
            return temp*temp;
        else
            return x*temp*temp;
    }
     */

    public static int pow(int x, int n, int d) {
        if (n == 0)
            return 1 % d;

        long ans = 1, base = x;
        while (n > 0){
            if (n % 2 == 1){
                ans = (ans * base) % d;
                n--;
            } else {
                base = (base * base) % d;
                n /= 2;
            }
        }
        if (ans < 0)
            ans = (ans + d) % d;
        return (int)ans;
    }
}
