/*  Interleaving Strings

Problem Description

Given A, B, C find whether C is formed by the interleaving of A and B.


Problem Constraints

1 <= length(A), length(B) <= 100

1 <= length(C) <= 200



Input Format

The first argument of input contains a string, A.
The second argument of input contains a string, B.
The third argument of input contains a string, C.


Output Format

Return 1 if string C is formed by interleaving of A and B else 0.


Example Input

Input 1:

 A = "aabcc"
 B = "dbbca"
 C = "aadbbcbcac"

Input 2:

 A = "aabcc"
 B = "dbbca"
 C = "aadbbbaccc"



Example Output

Output 1:

 1

Output 2:

 0



Example Explanation

Explanation 1:

 "aa" (from A) + "dbbc" (from B) + "bc" (from A) + "a" (from B) + "c" (from A)

Explanation 2:

 It is not possible to get C by interleaving A and B.

 */
package DP;

public class InterleavingStrings {
    public static void main(String[] args) {
        System.out.println(solve("aabcc","dbbca","aadbbcbcac"));
        System.out.println(solve("aabcc","dbbca","aadbbbaccc"));
    }

    public static int solve(String A, String B, String C) {
        
        int M = A.length(), N = B.length(); 
        boolean[][] IL = new boolean[M + 1][N + 1];
        if ((M + N) != C.length())
            return 0;

        for (int i = 0; i <= M; ++i) {
            for (int j = 0; j <= N; ++j) {
                // Empty String
                if (i == 0 && j == 0)
                    IL[i][j] = true;
                
                    // A is empty 
                else if (i == 0) {
                    if (B.charAt(j - 1) == C.charAt(j - 1))
                        IL[i][j] = IL[i][j - 1];
                }

                // B is empty 
                else if (j == 0) {
                    if (A.charAt(i - 1) == C.charAt(i - 1))
                        IL[i][j] = IL[i - 1][j];
                }

                else {
                    boolean sameInA = A.charAt(i - 1) == C.charAt(i + j - 1);
                    boolean sameInB = B.charAt(j - 1) == C.charAt(i + j - 1);
                    if (sameInA && B.charAt(j - 1) != C.charAt(i + j - 1)) {
                        IL[i][j] = IL[i - 1][j];
                    }
                    else {
                        if (A.charAt(i - 1) != C.charAt(i + j - 1) && sameInB)
                            IL[i][j] = IL[i][j - 1];
                        else if (sameInA && sameInB)
                            IL[i][j] = (IL[i - 1][j] || IL[i][j - 1]);
                    }
                }
            }
        }

        return IL[M][N]?1:0;
    }
}
