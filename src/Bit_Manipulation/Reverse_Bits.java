/*
Reverse the bits of an 32 bit unsigned integer A.


Problem Constraints
0 <= A <= 2^32



Input Format
First and only argument of input contains an integer A.


Output Format
Return a single unsigned integer denoting minimum xor value.


Example Input
Input 1:
0
Input 2:
3



Example Output
Output 1:
0
Output 2:
3221225472


 */
package Bit_Manipulation;

public class Reverse_Bits {
    public static void main(String[] args) {
        int N = 3;
        System.out.println(reverse(N));
    }
    public static long reverse(long a) {
        StringBuilder str = new StringBuilder();
        long res =0;
        while (a > 0)
        {
            if(a % 2 == 1) {
                str.append("1");
            }else{
                str.append("0");
            }
            a = a / 2;
        }
        str.append("0".repeat(Math.max(0, 32 - str.length() + 1)));

        String[] ch = str.toString().split("");
        for(int i=31; i>=0; i--){
            res += Long.parseLong(ch[i])*Math.pow(2,31-i);
        }
        return res;
    }
}
