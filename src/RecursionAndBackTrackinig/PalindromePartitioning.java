/*  Given a string s, partition s such that every string of the partition is a palindrome.
    Return all possible palindrome partitioning of s. Ordering the results in the answer :
    Entry i will come before Entry j if :
        len(Entryi[0]) < len(Entryj[0]) OR
        (len(Entryi[0]) == len(Entryj[0]) AND len(Entryi[1]) < len(Entryj[1])) OR * * *
        (len(Entryi[0]) == len(Entryj[0]) AND ... len(Entryi[k] < len(Entryj[k]))

    Problem Constraints
        1 <= len(s) <= 15

    Input Format
        First argument is a string of lowercase characters.

    Output Format
        Return a list of all possible palindrome partitioning of s.

    Example Input
        Input 1:
            s = "aab"

    Example Output
        Output 1:
         [
            ["a","a","b"]
            ["aa","b"],
          ]

    Example Explanation
        Explanation 1:
            In the given example, ["a", "a", "b"] comes before ["aa", "b"] because len("a") < len("aa").
 */
package RecursionAndBackTrackinig;

import java.util.ArrayList;

public class PalindromePartitioning {
    public static void main(String[] args) {
        System.out.println(partition("aab"));
    }

    static ArrayList<ArrayList<String>> ans;
    public static ArrayList<ArrayList<String>> partition(String a) {
        ans = new ArrayList<>();
        getPartition(new ArrayList<String>(), a, 0);
        return ans;
    }

    private static void getPartition(ArrayList<String> temp, String a, int idx) {
        if (idx == a.length()) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i=idx; i<a.length(); i++) {
            String sb = a.substring(idx, i+1);

            if (isPalindrome(sb)) {
                temp.add(sb);
                getPartition(temp, a, i+1);
                temp.remove(temp.size()-1);
            }
        }
    }

    private static boolean isPalindrome(String s) {
        return new StringBuilder(s).reverse().toString().equals(s);
    }
}
