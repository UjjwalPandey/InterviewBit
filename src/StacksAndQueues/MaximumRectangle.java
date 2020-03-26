/*  Maximum Rectangle

    Given a 2D binary matrix of integers A containing 0's and 1's of size N x M.
    Find the largest rectangle containing only 1's and return its area.
    Note: Rows are numbered from top to bottom and columns are numbered from left to right.

    Input Format
    The only argument given is the integer matrix A.

    Output Format
    Return the area of the largest rectangle containing only 1's.

    Constraints
        1 <= N, M <= 1000
        0 <= A[i] <= 1
    For Example
    Input 1:
        A = [   [0, 0, 1]
                [0, 1, 1]
                [1, 1, 1]   ]
    Output 1:
        4

    Input 2:
        A = [   [0, 1, 0, 1]
                [1, 0, 1, 0]    ]
    Output 2:
        1

 */
package StacksAndQueues;

import java.util.Stack;

public class MaximumRectangle {
    public static void main(String[] args) {
        int[][] A = {   {0, 0, 1},
                        {0, 1, 1},
                        {1, 1, 1}   };
        System.out.println(maxRectangle(A));
    }

    private static int maxRectangle(int[][] A) {
        int area = 0;
        int m = A.length;
        int n = A[0].length;
        int i, j;
        int[][] s = new int[m][n];

        for(i = 0; i < m; i++){
            for(j = 0; j < n; j++){
                if(A[i][j] == 1)
                    s[i][j] = (i == 0) ? 1 : s[i-1][j] + 1;
                else
                    s[i][j] = 0;
            }
        }
        for(i = 0; i < m; i++){
            for(j = 0; j < n; j++){
                System.out.print(s[i][j] + " ");
            }
            System.out.println();
        }

        for(i =0; i < m; i++)
            area = Math.max(area, largestRectangleArea(s[i]));
        return area;
    }

    public static int largestRectangleArea(int[] heights){
        if(heights == null || heights.length == 0)
            return 0;

        Stack<Integer> stack = new Stack<>();
        int max = 0;

        int i = 0;
        while(i < heights.length){
            if(stack.isEmpty() || heights[stack.peek()] <= heights[i]){
                stack.push(i);
                i++;
            }
            else{
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(max, height * width);
            }
        }

        while(!stack.isEmpty()){
            int height = heights[stack.pop()];
            int width = stack.isEmpty() ? i : i - stack.peek() -1;
            max = Math.max(max, height * width);
        }
        return max;
    }

}
