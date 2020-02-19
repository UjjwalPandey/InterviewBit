/* Implement atoi to convert a string to an integer.

    Example :

    Input : "9 2704"
    Output : 9
    Note: There might be multiple corner cases here. Clarify all your doubts using “See Expected Output”.

    Questions:
    Q1. Does string contain whitespace characters before the number?
    A. Yes
    Q2. Can the string have garbage characters after the number?
    A. Yes. Ignore it.
    Q3. If no numeric character is found before encountering garbage characters, what should I do?
    A. Return 0.
    Q4. What if the integer overflows?
    A. Return INT_MAX if the number is positive, INT_MIN otherwise.

 */
package Strings;

public class Atoi {
    public static void main(String[] args) {
        String[] A = {"9 2704", "927 04","007","56h78","089796557979","-09", "614273316"};
        for(String s: A) System.out.println(atoi(s));
    }

    public static int atoi(final String A) {
        String s = A.trim().split(" ")[0];
        double result = 0;
        int isNegative = 1;
        if(s.charAt(0) == '-'){
            isNegative= -1;
            s = s.substring(1);
        }else if(s.charAt(0) == '+'){
            s = s.substring(1);
        }
        for(int i=0; i< s.length(); i++){
            int x = s.charAt(i) - '0';
            if(x > 9 || x < 0) {
                result *= isNegative;
                if(result < Integer.MIN_VALUE) return Integer.MIN_VALUE;
                if(result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
                return (int)result;
            }
//            System.out.println(A+"  Result: "+result+"  X = "+x);
            result = (result*10) + x;
        }
        result *= isNegative;
        if(result < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        if(result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        return (int)result;
    }
}
