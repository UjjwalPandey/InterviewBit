/*  Divisibility by 8
    Given a number A in the form of string.
    Check if the number is divisible by 8 or not. Return 1 if it is divisible by 8 else return 0.
    Input Format
    The only argument given is string A.
    Output Format Return 1 if it is divisible by 8 else return 0. Constraints
    1 <= length of the String <= 100000
    '0' <= A[i] <= '9'
    For Example
    Input 1:
        A = "16"
    Output 1:
        1

    Input 2:
        A = "123"
    Output 2:
        0

 */
package Strings;

public class DivisibilityBy8 {
    public static void main(String[] args) {
        System.out.println(isDivisible("123"));
        System.out.println(isDivisible("1234"));
        System.out.println(isDivisible("1238067087958656748575786099860987t5658795785875676709887685684"));
    }

    private static int isDivisible(String s) {
        if(s.length() < 5){
             int remainder = Integer.parseInt(s)%8;
             return remainder==0 ? 1: 0;
        }
        int remainder = Integer.parseInt(s.substring(s.length()-3))%8;

        return remainder==0 ? 1: 0;
    }
}
