/*  Judge Reviews

    You are given the task of ranking hotel reviews in this question.

    Lets say, you are given a bunch of user reviews where each review is a string. Assume that our Expedia bots have figured out a set of "Good words" which indicate that the user likes the hotel. The more the number of "Good words", the more the user likes the hotel.

    Given multiple such reviews and the list of good words, you need to rank the reviews with the most positive review first and the most negative review the last. In other words, the review with the most number of good words comes first and the one with least number of good words comes last in the ranking.

    Note: Sorting should be stable. If review i and review j have the same number of "Good words", then their original order would be preserved.

    Constraints:

    1.   1 <= No.of reviews <= 200
    2.   1 <= No. of words in a review <= 1000
    3.   1 <= Length of an individual review <= 10,000
    4.   1 <= Number of Good Words <= 10,000
    5.   1 <= Length of an individual Good Word <= 4
    6.   All the alphabets are lower case (a - z)

    Input:

    S : A string S containing "Good Words" separated by  "_" character. (See example below)
    R : A vector of strings containing Hotel Reviews. Review strings are also separated by "_" character.

    Output:

    A vector V of integer which contain the original indexes of the reviews in the sorted order of reviews.

    V[i] = k  means the review R[k] comes at i-th position in the sorted order. (See example below)
    In simple words, V[i]=Original index of the review which comes at i-th position in the sorted order. (Indexing is 0 based)

    Example:

    Input:
    S = "pool_fridge_wifi"
    R = ["water_in_pool", "pond_fridge_drink", "pool_wifi_speed"]

    Output:
    ans = [2, 0, 1]
    Here, sorted reviews are ["pool_wifi_speed", "water_in_pool", "pond_fridge_drink"]
 */
package Strings;

import java.util.*;

public class JudgeReviews {
    public static void main(String[] args) {
        String S = "pool_fridge_wifi";
        String[] R = {"water_in_pool", "pond_fridge_drink", "pool_wifi_speed"};
        System.out.println(Arrays.toString(solve(S, R)));
    }

    public static int[] solve(String A, String[] B) {
        HashSet<String> goodWords = new HashSet<>();
        Collections.addAll(goodWords, A.split("_"));
        int[] res = new int[B.length];
        TreeMap<Double, Integer> gwInReview = new TreeMap<>(Collections.reverseOrder());
        int reviewNumber =0;
        for(String review: B){
            double cnt = 0;
            for(String r: review.split("_")){
                if(goodWords.contains(r)) cnt++;
            }
            double nxt = 0.0;
            while (gwInReview.containsKey(cnt+nxt)) nxt -= 0.01;
            gwInReview.put(cnt+nxt, reviewNumber++);
//            gwInReview.put(cnt, reviewNumber++);
        }
//        System.out.println(gwInReview);

        reviewNumber =0;
        for(Map.Entry m: gwInReview.entrySet()){
            res[reviewNumber++] = (Integer) m.getValue();
        }
        return res;
    }
}
