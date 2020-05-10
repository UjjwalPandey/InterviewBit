/*  Ways to Decode

    Problem Description

    A message containing letters from A-Z is being encoded to numbers using the following mapping:

    'A' -> 1
    'B' -> 2
    ...
    'Z' -> 26

    Given an encoded message denoted by string A containing digits, determine the total number of ways to decode it.



    Problem Constraints

    1 <= length(A) <= 105


    Input Format

    The first and the only argument is a string A.


    Output Format

    Return an integer, representing the number of ways to decode the string.


    Example Input

    Input 1:

     A = "12"

    Input 2:

     A = "8"



    Example Output

    Output 1:

     2

    Output 2:

     1



    Example Explanation

    Explanation 1:

     Given encoded message "8", it could be decoded as only "H" (8).
     The number of ways decoding "8" is 1.

    Explanation 2:

     Given encoded message "12", it could be decoded as "AB" (1, 2) or "L" (12).
     The number of ways decoding "12" is 2.
HW = ZCO14002
 */
package DP;

public class WaysToDecode {
    public static void main(String[] args) {
        System.out.println(numDecodings("12"));
        System.out.println(numDecodings("226"));
        System.out.println(numDecodings("26"));
        System.out.println(numDecodings("27"));
        System.out.println(numDecodings("526"));
        System.out.println(numDecodings("10"));
        System.out.println(numDecodings("3101"));
        System.out.println(numDecodings("5163490394499093221199401898020270545859326357520618953580237168826696965537789565062429676962877038781708385575876312877941367557410101383684194057405018861234394660905712238428675120866930196204792703765204322329401298924190"));
        System.out.println(numDecodings("4688513270184762818354596188597760575778256306748062705245353888299337432703173158426577344894131446039441879902899809240258031188695119515355366653337041384816753584173259089089948682277350046779984803359412957879989685402671756145925834918625001066493106121561989315550615558913174651811901679012552270796481776911515094911104680063223915051121153835513671541389358102880033935490881557157081175167842728349135230806741616120903605040026637781316242675898763376280592630899445052187079153807442356418784853473281250456479255344242257559923455404635206999273663239923320896030925036355412836330938223602204213736281187766100933920967088072292192389237360410197104849331191516106241419369883237628479616182824891426284033625389950586584115918765627908109222591805130582125242063041923868306048128830780499410"));
    }

    public static int numDecodings(String A){
        int[] dp = new int[A.length()];
        dp[0] = (A.charAt(0) != '0')?1:0;
        for(int i=1; i < A.length(); i++){
            int val = 10 * (A.charAt(i - 1) - '0') + (A.charAt(i) - '0');
            boolean isZero = (A.charAt(i) == '0');
            if (i == 1) {
                dp[i] = (isZero)?0:dp[i - 1];
                dp[i] += (val > 9 && val < 27) ? 1 : 0;
            } else {
                int num = (val > 9 && val < 27) ? dp[i - 2]  : 0;
                if(isZero){
                    dp[i] = num;
                }else {
                    dp[i] = dp[i - 1];
                    dp[i] += num;
                }
            }
        }
        return dp[A.length()-1];
    }
//        dp[i] = dp[i - 1] + (val >9 && val < 27)? dp[i-2]:0;


}
