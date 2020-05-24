/*
Max Rectangle in Binary A

Problem Description

Given a 2-D binary A A of size N x M filled with 0's and 1's, find the largest rectangle containing all ones and return its area.



Problem Constraints

1 <= N, M <= 100


Input Format

First argument is an 2-D binary array A.


Output Format

Return an integer denoting the area of largest rectangle containing all ones.


Example Input

Input 1:

 A = [
       [1, 1, 1]
       [0, 1, 1]
       [1, 0, 0]
     ]

Input 2:

 A = [
       [0, 1, 0]
       [1, 1, 1]
     ]



Example Output

Output 1:

 4

Output 2:

 3



Example Explanation

Explanation 1:

 As the max area rectangle is created by the 2x2 rectangle created by (0,1), (0,2), (1,1) and (1,2).

Explanation 2:

 As the max area rectangle is created by the 1x3 rectangle created by (1,0), (1,1) and (1,2).

Note: Referred https://medium.com/algorithm-and-datastructure/maximal-rectangle-51fc1ac0ed04
 */
package DP;

class MaxRectangleInBinaryMatrix {
    public static void main(String[] args) {
        int[][] A = {
                {1,1,1},
                {0,1,1},
                {1,0,0}
        };

        System.out.println(maximalRectangle(A));

    }

    public static int maximalRectangle(int[][] A) {
        if (A.length == 0 || A[0].length == 0) return 0;
        int max = Integer.MIN_VALUE;
        int[] heights = new int[A[0].length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                heights[j] = findHeight(A, i, j);
            }
            max = Math.max(max, largestRectangleArea(heights));
        }

        return max;
    }

    public static int findHeight(int[][] A, int r, int c) {
        int h = 0;
        while (r >= 0) {
            if (A[r][c] == 1)
                h += 1;
            else
                break;
            r--;
        }
        return h;
    }

    public static int largestRectangleArea(int[] heights) {
        if (heights.length == 1) return heights[0];
        int maxArea = 0;
        for (int i = 0; i < heights.length - 1; i++) {
            int min = heights[i];
            for (int j = i + 1; j < heights.length; j++) {
                min = Math.min(min, heights[j]);
                maxArea = Math.max(heights[j], Math.max(maxArea, min * (j - i + 1)));
                maxArea = Math.max(maxArea, heights[i]);
            }
        }
        return maxArea;
    }
}
