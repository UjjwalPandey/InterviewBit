/*  BST nodes in a range

    Given a binary search tree of integers. You are given a range [B, C].

    Return the count of the number of nodes that lies in this range.

    Constraints

    1 <= Number of nodes in binary tree <= 100000
    0 <= B < = C <= 10^9

    For Example

    Input 1:
                15
              /    \
            12      20
            / \    /  \
           10  14  16  27
          /
         8

         B = 12
         C = 20
    Output 1:
        5

    Input 2:
                 8
                / \
               6  21
              / \
             1   4

            B = 2
            C = 20
    Output 2:
        3



 */
package Tree.BST;

import Tree.BinaryTree.KDistance;

import java.util.ArrayList;

public class BSTNodesInARange {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
            left=null;
            right=null;
        }
    }

    public static void main(String[] args) {
        TreeNode tree1 = new TreeNode(15);
        tree1.left = new TreeNode(12);
        tree1.right = new TreeNode(20);
        tree1.left.left = new TreeNode(10);
        tree1.left.right = new TreeNode(14);
        tree1.left.left.left = new TreeNode(8);
        tree1.right.left = new TreeNode(16);
        tree1.right.right = new TreeNode(27);
        System.out.println(solve(tree1,12, 20));


        TreeNode tree2 = new TreeNode(8);
        tree2.left = new TreeNode(6);
        tree2.right = new TreeNode(21);
        tree2.left.right = new TreeNode(4);
        tree2.left.left = new TreeNode(1);
        System.out.println(solve(tree2,2, 20));

    }

    public static int solve(TreeNode A, int B, int C) {
        if(A == null) return 0;
        int val = A.val;
        return (val >= B && val <= C)?1+solve(A.left, B, C)+solve(A.right, B, C): solve(A.left, B, C)+solve(A.right, B, C);
    }
}
