/*  N max pair combinations

    Problem Description

    Given two integers arrays A and B of size N each.

    Find the maximum N elements from the sum combinations (Ai + Bj) formed from elements in array A and B.



    Problem Constraints

    1 <= N <= 2 * 105

    -1000 <= A[i], B[i] <= 1000



    Input Format

    First argument is an integer array A.
    Second argument is an integer array B.


    Output Format

    Return an intger array denoting the N maximum element in descending order.


    Example Input

    Input 1:

     A = [1, 4, 2, 3]
     B = [2, 5, 1, 6]

    Input 2:

     A = [2, 4, 1, 1]
     B = [-2, -3, 2, 4]



    Example Output

    Output 1:

     [10, 9, 9, 8]

    Output 2:

     [8, 6, 6, 5]



    Example Explanation

    Explanation 1:

     4 maximum elements are 10(6+4), 9(6+3), 9(5+4), 8(6+2).

    Explanation 2:

     4 maximum elements are 8(4+4), 6(4+2), 6(4+2), 5(4+1).

     After 4 attempts Referred: https://siddarthkanted.wordpress.com/2019/05/12/find-n-maximum-sum-pair-combinations-from-2-arrays-in-java-interviewbit-solution/

 */
package Heaps;

import java.util.*;

public class NMaxPairCombinations {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(2);
        A.add(4);
        A.add(1);
        A.add(1);
        ArrayList<Integer> B = new ArrayList<>();
        B.add(-2);
        B.add(-3);
        B.add(2);
        B.add(4);
        System.out.println(maxPair(A, B));
    }

    private static ArrayList<Integer> maxPair(ArrayList<Integer> one, ArrayList<Integer> two) {

        one.sort(Collections.reverseOrder());
        two.sort(Collections.reverseOrder());

        //minimum heap
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for(int i=0; i<one.size(); i++) {
            for(int j=0; j<two.size(); j++) {

                int sum = one.get(i) + two.get(j);
                priorityQueue.add(sum);

                if (priorityQueue.size() > one.size()) {
                    int lastElement = priorityQueue.poll();
                    if(lastElement==sum) break;
                }
            }
        }
        ArrayList<Integer> result = new ArrayList<>(priorityQueue);
        result.sort(Collections.reverseOrder());
        return result;
    }
}
