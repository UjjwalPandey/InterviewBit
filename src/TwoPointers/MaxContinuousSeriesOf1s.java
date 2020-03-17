/*  Max Continuous Series of 1s

    You are given with an array of 1s and 0s.
    And you are given with an integer M, which signifies number of flips allowed.
    Find the position of zeros which when flipped will produce maximum continuous series of 1s.
    For this problem, return the indices of maximum continuous series of 1s in order. Example:

    Input :
    Array = {1 1 0 1 1 0 0 1 1 1 }
    M = 1

    Output :
    [0, 1, 2, 3, 4]
    If there are multiple possible solutions, return the sequence which has the minimum start index.

 */
package TwoPointers;

import java.util.ArrayList;

public class MaxContinuousSeriesOf1s {
    public static void main(String[] args) {
        int[] A = {1, 1, 0, 1, 1, 0, 0, 1, 1, 1 };
        int M = 1;
        ArrayList<Integer> arr = new ArrayList<>();
        for(int x: A) arr.add(x);
        System.out.println(maxOne(arr, M));
    }

    public static ArrayList<Integer> maxOne(ArrayList<Integer> A, int B) {
        int start = 0, len = A.size(), p1 = 0, p2 = 0, zeros = B, lastZero = -1;
        int[] ans = new int[2];

        int maxLen = Integer.MIN_VALUE;

        while (start < len) {
            if (A.get(start).equals(0)) {
                if (lastZero == -1) {
                    lastZero = start;
                }
                if (zeros == 0) {
                    if (maxLen < (p2-p1)) {
                        ans[0] = p1;
                        ans[1] = p2-1;
                        maxLen = p2-p1;
                    }
                    p1 = lastZero + 1;
                    start = p1;
                    lastZero = -1;
                    p2 = p1;
                    zeros = B;
                }
                else {
                    zeros--;
                    start++;
                    p2++;
                }
            }
            else {
                start++;
                p2++;
            }
        }

        if (maxLen < p2-p1) {
            ans[0] = p1;
            ans[1] = p2-1;
        }
        ArrayList<Integer> res = new ArrayList<>();
        start = ans[0];
        while (start <= ans[1]) {
            res.add(start++);
        }

        return res;
    }
}
