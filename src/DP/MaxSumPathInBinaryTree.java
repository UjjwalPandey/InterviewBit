/*  Max Sum Path in Binary Tree

Problem Description

Given a binary tree T, find the maximum path sum.

The path may start and end at any node in the tree.



Problem Constraints

1 <= Number of Nodes <= 7e4

-1000 <= Value of Node in T <= 1000



Input Format

The first and the only argument contains a pointer to the root of T, A.


Output Format

Return an integer representing the maximum sum path.


Example Input

Input 1:

  
    1
   / \
  2   3

Input 2:

       20
      /  \
   -10   20
        /  \
      -10  -50



Example Output

Output 1:

 6

Output 2:

 40



Example Explanation

Explanation 1:

     The path with maximum sum is: 2 -> 1 -> 3

Explanation 2:

     The path with maximum sum is: 20 -> 20


 */
package DP;

import Tree.BinaryTree.DuplicatesInBinaryTree;

public class MaxSumPathInBinaryTree {
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
        TreeNode tree1 = new TreeNode(1);
        tree1.left = new TreeNode(2);
        tree1.right = new TreeNode(3);
        System.out.println(maxPathSum(tree1));

        TreeNode tree2 = new TreeNode(20);
        tree2.left = new TreeNode(-10);
        tree2.right = new TreeNode(20);
        tree2.right.left = new TreeNode(-10);
        tree2.right.right = new TreeNode(-50);
        System.out.println(maxPathSum(tree2));
    }


    static int global_max;
    static int maxPath(TreeNode root ) {
        if (root == null) return 0;
        int l = Math.max(0, maxPath(root.left));
        int r = Math.max(0, maxPath(root.right));
        global_max = Math.max(global_max, l + r + root.val);
        return root.val + Math.max(l, r);
    }


    public static int maxPathSum(TreeNode A) {
        global_max = Integer.MIN_VALUE;
        maxPath(A);
        return global_max;
    }
}
