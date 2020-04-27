/*  Reversing the first B elements of queue

    Given an array of integers A and an integer B.
    We need to reverse the order of the first B elements of the array, leaving the other elements in the same relative order.

    Note: You are required to first insert elements into an auxiliary queue then perform Reversal of first B elements.

    Input Format
    The argument given is the integer array A and an integer B.

    Output Format
    Return an array of integer after reversing the first k elements of A using queue.

    Constraints
    1 <= B <= length of the array <= 200000
    1 <= A[i] <= 100000
    For Example
    Input 1:
        A = [1, 2, 3, 4, 5]
        B = 3
    Output 1:
        [3, 2, 1, 4, 5]

    Input 2:
        A = [5, 17, 100, 11]
        B = 2
    Output 2:
        [17, 5, 100, 11]

 */
package StacksAndQueues;

import java.util.Arrays;
import java.util.Stack;

public class ReversingTheFirstBElementsOfQueue {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(reverseB(new int[] {1, 2, 3, 4,5}, 4)));
        System.out.println(Arrays.toString(reverseArr(new int[] {1, 2, 3, 4, 5}, 4)));
        System.out.println(Arrays.toString(reverseArr(new int[]{43, 35, 25, 5, 34, 5, 8, 7}, 6)));
        System.out.println(Arrays.toString(reverseB(new int[]{43, 35, 25, 5, 34, 5, 8, 7}, 6)));
    }

    private static int[] reverseB(int[] A, int B) {
        if(B >= A.length) B = A.length;
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i < B; i++){
            stack.push(A[i]);
        }
        int i =0;
        while (!stack.empty()){
            A[i++] = stack.pop();
        }
        return A;
    }

    private static int[] reverseArr(int[] A, int B) {
        if(B >= A.length) B = A.length;
        for(int i=0; i < B/2; i++){
            int t = A[i];
            A[i] = A[B-i-1];
            A[B-i-1] = t;
        }
        return A;
    }
}
