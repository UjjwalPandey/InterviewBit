/**  Reverse integer
 Problem Description
 You are given an integer N and the task is to reverse the digits of the given integer.
 Return 0 if the result overflows and does not fit in a 32 bit signed integer

 Output Format
 Return a single integer denoting the reverse of the given integer.

 Example Input
 Input 1:
 x = 123

 Input 2:
 x = -123

 Example Output
 Output 1:
 321

 Ouput 2:
 -321
 */

package Maths;
public class Reverse_Integer {
    public static void main(String[] args) {
        int N = -123;
        int M = -1146467285;
        int O = 9;
        int P = 999999991;
        System.out.println(reverse(N));
        System.out.println(reverse(M));
        System.out.println(reverse(O));
        System.out.println(reverse(P));
    }

    public static int reverse(int A) {
        int sum =0;
        boolean negFlag = false;
        if(A<0){
            A = -A;
            negFlag = true;
        }
        int prev_rev_num = 0, rev_num = 0;
        while(A != 0){
            int curr_digit = A % 10;
            rev_num = (rev_num * 10) + curr_digit;
            // To check the Integer OVERFLOW!
            if (((rev_num - curr_digit)/10) != prev_rev_num)
                return 0;

            prev_rev_num = rev_num;
            A /= 10;
        }
        return (negFlag == true) ? -rev_num : rev_num;
    }
}
