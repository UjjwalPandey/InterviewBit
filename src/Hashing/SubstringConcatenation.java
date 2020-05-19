/*  Substring Concatenation

    You are given a string, S, and a list of words, L, that are all of the same length.

    Find all starting indices of substring(s) in S that is a concatenation of each word in L exactly once and without any intervening characters.

    Example :

    S: "barfoothefoobarman"
    L: ["foo", "bar"]

    You should return the indices: [0,9].
    (order does not matter).

https://www.interviewbit.com/problems/substring-concatenation/
*/
package Hashing;

import java.util.*;

public class SubstringConcatenation {
    public static void main(String[] args) {

        ArrayList<String> A = new ArrayList<>();
        A.add("foo");
        A.add("bar");
        System.out.println(findSubstring("barfoothefoobarman", A));
        ArrayList<String> B = new ArrayList<>();
        B.add("aaa");
        B.add("aaa");
        B.add("aaa");
        B.add("aaa");
        B.add("aaa");
        System.out.println(findSubstring("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",B));
    }

    public static ArrayList<Integer> findSubstring(String A, final List<String> B) {
        int wc = B.size();
        int sw = B.get(0).length();
        int size_l = sw * wc;
        ArrayList<Integer> res = new ArrayList<>();
        int n = A.length();
        if (size_l > n) {
            return res;
        }

        HashMap<String, Integer> hm = new HashMap<>();
        for (String word : B) {
            hm.put(word, hm.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i <= n - size_l; i++) {
            HashMap<String, Integer> tempMap = (HashMap<String, Integer>) hm.clone();
            int j = i, count = wc;
            while (j < i + size_l) {
                String word = A.substring(j, j + sw);
                if (!hm.containsKey(word) || tempMap.get(word) == 0) {
                    break;
                }
                else {
                    tempMap.put(word, tempMap.get(word) - 1);
                    count--;
                }
                j += sw;
            }
            if (count == 0) {
                res.add(i);
            }

        }
        return res;
    }
}
