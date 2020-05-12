/*  Min Sum Path in Triangle

    Problem Description

    Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

    Adjacent numbers for jth number of row i is jth and (j+1)th numbers of row i+1 is



    Problem Constraints

    |A| <= 1000

    A[i] <= 1000

    Input Format

    First and only argument is the vector of vector A defining the given triangle

    Output Format

    Return the minimum sum

    Example Input

    Input 1:


    A = [
             [2],
            [3, 4],
           [6, 5, 7],
          [4, 1, 8, 3]
        ]

    Input 2:

     A = [ [1] ]



    Example Output

    Output 1:

     11

    Output 2:

     1



    Example Explanation

    Explanation 1:

     The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

    Explanation 2:

     Only 2 can be collected.


 */
package DP;

import java.util.ArrayList;

public class MinSumPathInTriangle {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(2);
        A.add(temp);

        temp = new ArrayList<>();
        temp.add(3);
        temp.add(4);
        A.add(temp);

        temp = new ArrayList<>();
        temp.add(6);
        temp.add(5);
        temp.add(7);
        A.add(temp);

        temp = new ArrayList<>();
        temp.add(4);
        temp.add(1);
        temp.add(8);
        temp.add(3);
        A.add(temp);
        System.out.println(minimumTotal(A));
    }
    public static int minimumTotal(ArrayList<ArrayList<Integer>> A) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>(A);
        int N = A.size();
        for(int i= N-2; i >= 0; i--){
            for(int j =0; j< A.get(i).size() && j+1 < A.get(i+1).size(); j++){
                res.get(i).set(j, res.get(i).get(j)+Math.min(A.get(i+1).get(j), A.get(i+1).get(j+1)));
            }
        }
        return res.get(0).get(0);
    }
}
