/*  Left view of binary tree

    Given a binary tree of integers. Return an array of integers representing the left view of the Binary tree.
    Left view of a Binary Tree is a set of nodes visible when the tree is visited from Left side Constraints
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
        [1, 2, 4, 8]

    Input 2:
                1
               /  \
              2    3
               \
                4
                 \
                  5
    Output 2:
        [1, 2, 4, 5]

 */

package Tree.BinaryTree;

import java.util.ArrayList;

public class LeftViewOfBinaryTree {
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
        System.out.println(solve(tree1));

        TreeNode tree2 = new TreeNode(1);
        tree2.left = new TreeNode(2);
        tree2.right = new TreeNode(3);
        tree2.left.left = new TreeNode(4);
        tree2.left.right = new TreeNode(5);
        tree2.right.left = new TreeNode(6);
        tree2.right.right = new TreeNode(7);
        tree2.left.left.left = new TreeNode(8);
        System.out.println(solve(tree2));
    }

    static ArrayList<Integer> result;
    public static ArrayList<Integer> solve(TreeNode A) {
        result = new ArrayList<>();
        getLevel(A,0);
        return result;
    }

    public static void getLevel(TreeNode A, int level) {
        if(A == null){
            return;
        }
        if(result.size() == level){
            result.add(A.val);
        }
        getLevel(A.left, level+1);
        getLevel(A.right, level+1);
    }
}
