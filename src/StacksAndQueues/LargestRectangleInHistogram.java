/*  Largest Rectangle in Histogram

    Given an array of integers A of size N.
    A represents a histogram i.e A[i] denotes height of the ith histogram's bar.
    Width of each bar is 1.
     Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3]. Largest Rectangle in Histogram: Example 2
     The largest rectangle is shown in the shaded area, which has area = 10 unit. Find the area of largest rectangle in the histogram.

    Input Format
    The only argument given is the integer array A.

    Output Format
    Return the area of largest rectangle in the histogram.

    For Example
    Input 1:
        A = [2, 1, 5, 6, 2, 3]
    Output 1:
        10
        Explanation 1:
            The largest rectangle is shown in the shaded area, which has area = 10 unit.

 */

package StacksAndQueues;

import java.util.Stack;

public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        int[] A = {2, 1, 5, 6, 2, 3};
        System.out.println(largestRectangleArea(A));
    }

    public static int largestRectangleArea(int[] A) {
        int[] height = new int[A.length];
        System.arraycopy(A, 0, height, 0, height.length);

        int len = height.length;
        Stack<Integer> s = new Stack<Integer>();
        int maxArea = 0;
        for(int i = 0; i <= len; i++){
            int h = (i == len ? 0 : height[i]);
            if(s.isEmpty() || h >= height[s.peek()]){
                s.push(i);
            }else{
                int tp = s.pop();
                maxArea = Math.max(maxArea, height[tp] * (s.isEmpty() ? i : i - 1 - s.peek()));
                i--;
            }
        }
        return maxArea;
    }
}
