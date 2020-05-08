/*  Equal Strings

    Problem Description

    Given two strings A and B each of size N consisting of lowercase alphabets.

    You can perform the following operations any number of time:

    Select any two characters in string A and swap the characters.
    Select any two characters in string B and swap the characters.
    Select a character in string A and select a character in string B. Swap the characters from both strings.

    Return 1 if it possible to make strings equal else return 0.



    Problem Constraints

    1 <= N <= 105


    Input Format

    First argument is a string A of size N.

    First argument is a string B of size N.



    Output Format

    Return 1 if it possible to make strings equal else return 0.


    Example Input

    Input 1:

     A = "adbc"
     B = "abcd"

    Input 2:

     A = "abbc"
     B = "aabc"



    Example Output

    Output 1:

     1

    Output 2:

     0



    Example Explanation

    Expanation 1:

     We can make the string A equal to B by first swapping 'd' and 'c' of string A. So the string becomes "acbd".
     Then swap 'b' and 'c' of string A. So the final string becomes "abcd".

    Explanation 2:

     There is no possible way in which we can make the strings equal.

 */
package Strings;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class EqualStrings {
    public static void main(String[] args) {
        System.out.println(isEqual("adbc", "abcd"));
        System.out.println(isEqual("abbc", "aabc"));
        System.out.println(isEqual("tjjgtdrntrjtwwixd", "dgwwnigjoipdxiopg"));
    }

    private static int isEqual(String A, String B) {
        HashMap<Character, Integer> hm1 = new HashMap<>();
        HashMap<Character, Integer> hm2 = new HashMap<>();
        int N = A.length();
        for(int i=0; i < N; i++){
            char a = A.charAt(i);
            char b = B.charAt(i);
            int val1 = hm1.getOrDefault(a, 0);
            int val2 = hm2.getOrDefault(b, 0);
            hm1.put(a, val1+1);
            hm2.put(b, val2+1);
        }
        Set<Character> keysA = hm1.keySet();
        Iterator<Character> itr = keysA.iterator();
        while (itr.hasNext()){
            char ch = itr.next();
            if((hm1.getOrDefault(ch,0) + hm2.getOrDefault(ch,0))%2 == 1) return 0;
        }
        return 1;
    }
}

