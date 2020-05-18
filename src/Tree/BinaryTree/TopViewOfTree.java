/*

TOP VIEW

Given a binary tree of integers. Return an array of integers representing the Top view of the Binary tree.

Top view of a Binary Tree is a set of nodes visible when the tree is visited from Top side.

Note: Return the nodes in any order.

Constraints

1 <= Number of nodes in binary tree <= 100000
0 <= node values <= 10^9

For Example

Input 1:
            1
          /   \
         2    3
        / \  / \
       4   5 6  7
      /
     8
Output 1:
    [1, 2, 4, 8, 3, 7]

Input 2:
            1
           /  \
          2    3
           \
            4
             \
              5
Output 2:
    [1, 2, 3]


 */
package Tree.BinaryTree;

import java.util.ArrayList;

public class TopViewOfTree {
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
        tree1.left.right = new TreeNode(4);
        tree1.left.right.right = new TreeNode(5);
        tree1.left.right.right.right = new TreeNode(6);
        System.out.println(solve(tree1));


        TreeNode tree2 = new TreeNode(1);
        tree2.left = new TreeNode(2);
        tree2.right = new TreeNode(3);
        tree2.left.left = new TreeNode(4);
        tree2.left.right = new TreeNode(5);
        tree2.right.left = new TreeNode(6);
        tree2.right.right = new TreeNode(7);
        tree2.left.left.left = new TreeNode(8);
        tree2.left.left.right = new TreeNode(9);
        tree2.left.left.right.left = new TreeNode(10);
        System.out.println(solve(tree2));

        TreeNode tree3 = new TreeNode(1);
        tree3.right = new TreeNode(3);
        System.out.println(solve(tree3));
    }

    public static ArrayList<Integer> solve(TreeNode A) {
        ArrayList<Integer> result = new ArrayList<>();
        TreeNode temp = A;
        while (temp != null){
            result.add(temp.val);
            temp = temp.left;
        }
        temp = A.right;
        while (temp != null){
            result.add(temp.val);
            temp = temp.right;
        }
        return result;
    }
}
