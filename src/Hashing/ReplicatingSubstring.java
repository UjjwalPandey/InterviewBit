/*  Replicating Substring

    Given a string S, find if it is possible to re-order the characters of the string S so that it can be represented as a concatenation of K similar strings.
    Eg if S=aabb and K=2, then it is possible to re-arrange the string as "abab" which is a concatenation of 2 similar strings "ab".
    If it is possible, return 1, else return -1. Constraints:

    1.   1 <= Length of S <= 1000
    2.   All the alphabets of S are lower case (a - z)
    3.   1 <= K <= 1000

    Input: Integer K and string S

    Output: Your function should return 1 if it is possible to re-arrange the characters of the string S so that it can be represented as a concatenation of K similar strings.
    If it is not, return -1.

    Example: Input:
    K:2
    S:bbaabb
    Output:
    1

 */
package Hashing;

import java.util.HashMap;

public class ReplicatingSubstring {
    public static void main(String[] args) {
        System.out.println(isReplicating(2,"bbaabb"));
    }
    public static int isReplicating(int A, String B) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for(int i=0; i< B.length(); i++){
            int val = hm.getOrDefault(B.charAt(i),0);
            hm.put(B.charAt(i), (val+1)%A);
        }
        System.out.println(hm);
        for(int i=1; i<= A; i++){
            if(hm.containsValue(i)) return -1;
        }
        return 1;
    }
}
