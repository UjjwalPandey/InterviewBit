/*
    Given two binary strings, return their sum (also a binary string).
    Example:
        a = "100"
        b = "11"
    Return a + b = “111”.
 */

package Strings;

public class AddBinaryStrings {
    public static void main(String[] args) {
        System.out.println(addBinary("10","11"));
        System.out.println(addBinary("1011","10011"));
        System.out.println(addBinary("10111011","100101011"));
    }

    public static String addBinary(String A, String B) {
        StringBuilder result = new StringBuilder();
        int sum = 0;
        int i = A.length() - 1, j = B.length() - 1;
        while (i >= 0 || j >= 0 || sum == 1){

            sum += ((i >= 0)? A.charAt(i) - '0': 0);
            sum += ((j >= 0)? B.charAt(j) - '0': 0);
            result.insert(0, (char) (sum % 2 + '0'));
            sum /= 2;
            i--; j--;
        }

        return result.toString();
    }
}
