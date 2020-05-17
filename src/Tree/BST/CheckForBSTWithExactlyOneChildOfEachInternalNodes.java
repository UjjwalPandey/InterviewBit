/*
    Check for BST with exactly one child of each internal nodes

    Given preorder traversal of a binary tree, check if it is possible that it is also a preorder traversal of a BST,

    where each internal node (non -leaf nodes) have exactly one child.

    CONSTRAINTS

    1 <= N <= 100

    INPUT

        A : [ 4, 10, 5 ,8 ]

    OUTPUT

        YES

    EXPLANATION

        The possible BST is:

                4
                 \
                 10
                 /
                 5
                  \
                  8

 */
package Tree.BST;

public class CheckForBSTWithExactlyOneChildOfEachInternalNodes {
    public static void main(String[] args) {
        System.out.println(solve(new int[]{4, 10, 5, 8}));   // YES
        System.out.println(solve(new int[]{4, 10, 15, 8}));  // NO
        System.out.println(solve(new int[]{25, 42, 49, 44, 2}));  // NO
    }

    // All Children must be either bigger or smaller than the parent. Can't afford both.
    public static String solve(int[] A) {
        for(int i=0; i < A.length - 1; i++){
            boolean isChildBigger = (A[i+1] - A[i] > 0);
            for(int j= i+1; j< A.length; j++){
                if(isChildBigger){
                    if(A[j] < A[i]) return "NO";
                }else {
                    if(A[j] > A[i]) return "NO";
                }
            }
        }
        return "YES";
    }
}
