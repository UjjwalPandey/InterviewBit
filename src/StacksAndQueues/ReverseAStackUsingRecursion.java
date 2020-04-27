/*  Reverse a stack using recursion

    Given a stack of integers A. You are required to reverse the stack using recursion.
    You are not allowed to use loop constructs like while, for..etc, Return A after reversing it using recursion.

    NOTE: It is mandatory to reverse A using recursion.

    Input Format
    The only argument given is the integer array A.

    Output Format
    Return the reversal of A using stack.

    Constraints
        1 <= length of the array <= 2000
        1 <= A[i] <= 10^8
    For Example
    Input 1:
        A = [1, 5, 3, 2, 4]
    Output 1:
        [4, 2, 3, 5, 1]

    Input 2:
        A = [5, 17, 100, 11]
    Output 2:
        [11, 100, 17, 5]

 */
package StacksAndQueues;

import java.util.ArrayList;

public class ReverseAStackUsingRecursion {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(5);
        A.add(3);
        A.add(2);
        A.add(4);
        System.out.println(A);
        ArrayList<Integer> res = reverse(A);
        System.out.println(res);
    }

    private static ArrayList<Integer> reverse(ArrayList<Integer> A) {
        if(A.size() == 1){
            return A;
        }
        int head = A.get(0);
        ArrayList<Integer> body = reverse(new ArrayList<>(A.subList(1,A.size())));
        body.add(head);
        return body;
    }
}
