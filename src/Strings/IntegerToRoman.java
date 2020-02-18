/*
    Given an integer A, convert it to a roman numeral, and return a string corresponding to its roman numeral version
     Note : This question has a lot of scope of clarification from the interviewer.
     Please take a moment to think of all the needed clarifications and see the expected response using “See Expected Output” For the purpose of this question,
     https://projecteuler.net/about=roman_numerals has very detailed explanations.

    Input Format
        The only argument given is integer A.
    Output Format
        Return a string denoting roman numeral version of A.
    Constraints
        1 <= A <= 3999
    For Example
        Input 1:
            A = 5
        Output 1:
            "V"

        Input 2:
            A = 14
        Output 2:
            "XIV"


 */
package Strings;

public class IntegerToRoman {
    public static void main(String[] args) {
//        String[] N = {"MCMXII", "IV", "XXIX", "LXV","XXX","LD","MMDCCCXLV","XLV"};   // 1912
        int[] N = {1912,4,29,65,30,450,2845,45};
        for (int s : N) System.out.println(integerToRoman(s));
    }

    private static String integerToRoman(int number) {
        int[] num = {1,4,5,9,10,40,50,90,100,400,500,900,1000};
        String[] sym = {"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
        int i=12;
        StringBuilder res = new StringBuilder();
        while(number>0)
        {
            int div = number/num[i];
            number = number%num[i];
            while(div-- != 0){
                res.append(sym[i]);
            }
            i--;
        }
        return res.toString();
    }
}
