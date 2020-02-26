/* Given an array of size N of candidate numbers A and a target number B. Return all unique combinations in A where the candidate numbers sums to B.  Each number in A may only be used once in the combination. Note:
    All numbers (including target) will be positive integers.
    Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
    The solution set must not contain duplicate combinations.
     Warning: DO NOT USE LIBRARY FUNCTION FOR GENERATING COMBINATIONS. Example : itertools.combinations in python.
     If you do, we will disqualify your submission and give you penalty points.

    Problem Constraints
    1 <= N <= 15

    Input Format
        First argument is an integer array A denoting the collection of candidate numbers.
        Second argument is an integer which represents the target number.


    Output Format
        Return all unique combinations in A where the candidate numbers sums to B.


    Example Input
    Input 1:
    A = [10, 1, 2, 7, 6, 1, 5]
    B = 8

    Example Output
    Output 1:
        [ [1 1 6 ]
        [1 2 5 ]
        [1 7 ]
        [2 6 ] ]

    Example Explanation
        Explanation 1:
         1 + 1 + 6 = 8
         1 + 2 + 5 = 8
         1 + 7 = 8
         2 + 6 = 8
         All the above combinations sum to 8 and are arranged in ascending order.


 */

package RecursionAndBackTrackinig;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CombinationSum2 {
    public static void main(String[] args) {
        ArrayList<Integer> ip = new ArrayList<>();
        ip.add(10);
        ip.add(1);
        ip.add(2);
        ip.add(7);
        ip.add(6);
        ip.add(1);
        ip.add(5);
        int sum = 8;
        ArrayList<ArrayList<Integer>> res = combinationSum(ip,sum);
        System.out.print(res);
    }

    public static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        Collections.sort(A);
        recursiveSum(result, curr, 0, sum, A);
        return result;
    }

    private static void recursiveSum(ArrayList<ArrayList<Integer>> result, List<Integer> curr, int start, int sum, ArrayList<Integer> A) {
        if(sum==0){
            result.add(new ArrayList<>(curr));
            return;
        }
        if(sum<0){
            return;
        }

        int prev=-1;
        for(int i=start; i<A.size(); i++){
            if(prev!=A.get(i)){ // each time start from different element
                curr.add(A.get(i));
                recursiveSum(result, curr, i+1, sum-A.get(i), A); // and use next element only
                curr.remove(curr.size()-1);
                prev= A.get(i);
            }
        }
    }
}
