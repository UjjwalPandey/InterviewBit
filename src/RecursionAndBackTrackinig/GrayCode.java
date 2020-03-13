/*  Gray Code

    The gray code is a binary numeral system where two successive values differ in only one bit.
    Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code.
    A gray code sequence must begin with 0.

    Problem Constraints
        1 <= n <= 16

    Input Format
        First argument is an integer n.

    Output Format
        Return an array of integers representing the gray code sequence.

    Example Input
        Input 1:
            2

    Example Output
        output 1:
            [0,1,3,2]

    Example Explanation
        Explanation 1:
            For n = 2 the gray code sequence is:
                00 - 0
                01 - 1
                11 - 3
                10 - 2
            So, return [0,1,3,2].
 */
package RecursionAndBackTrackinig;

import java.util.ArrayList;
import java.util.Collections;

public class GrayCode {
    public static void main(String[] args) {
        System.out.println(grayCode(4));
    }

    public static ArrayList<Integer> grayCode(int a) {
        StringBuilder str = new StringBuilder();
        for(int i=0; i< a; i++){
            str.append("0");
        }
        ArrayList<String> grayList_String =  createGrayList(str.toString());
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=0; i < grayList_String.size(); i++){
            int num =0;
            for(int j =0; j< a; j++){
                num += (grayList_String.get(i).charAt(j)-'0')*Math.pow(2,a-j-1);
            }
            res.add(num);
        }
        return res;
    }

    /*  APPROACH:
            n-bit Gray Codes can be generated from list of (n-1)-bit Gray codes using following steps.
            1) Let the list of (n-1)-bit Gray codes be L1. Create another list L2 which is reverse of L1.
            2) Modify the list L1 by prefixing a ‘0’ in all codes of L1.
            3) Modify the list L2 by prefixing a ‘1’ in all codes of L2.
            4) Concatenate L1 and L2. The concatenated list is required list of n-bit Gray codes.

            For example, following are steps for generating the 3-bit Gray code list from the list of 2-bit Gray code list.
            L1 = {00, 01, 11, 10} (List of 2-bit Gray Codes)
            L2 = {10, 11, 01, 00} (Reverse of L1)
            Prefix all entries of L1 with ‘0’, L1 becomes {000, 001, 011, 010}
            Prefix all entries of L2 with ‘1’, L2 becomes {110, 111, 101, 100}
            Concatenate L1 and L2, we get {000, 001, 011, 010, 110, 111, 101, 100}

     */
    private static ArrayList<String> createGrayList(String str) {
        ArrayList<String> singularBit =  new ArrayList<>();
        singularBit.add("0");
        singularBit.add("1");
        if(str.length() == 1) return  singularBit;

        // Getting Gray Code for size N-1
        ArrayList<String> subListZero =  createGrayList(str.substring(1));

        // Reversing the Gray Code for N-1 and adding it with 1 as Prefix
        ArrayList<String> subListOne = new ArrayList<>(subListZero);
        Collections.reverse(subListOne);

        ArrayList<String> resString =  new ArrayList<>();
        for(String addZero : subListZero){
            resString.add("0"+addZero);
        }

        for(String addOne : subListOne){
            resString.add("1"+addOne);
        }

        return resString;
    }
}
