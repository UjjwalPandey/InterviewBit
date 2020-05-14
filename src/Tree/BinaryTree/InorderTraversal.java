/*  Given a binary tree, return the inorder traversal of its nodes’ values.

    Example :
    Given binary tree

       1
        \
         2
        /
       3
    return [1,3,2].

    Using recursion is not allowed.

 */
package Tree.BinaryTree;

import java.util.ArrayList;

public class InorderTraversal {
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
        tree1.left.left = new TreeNode(4);
        tree1.left.right = new TreeNode(5);
        tree1.left.left.left = new TreeNode(8);
        tree1.right.left = new TreeNode(6);
        tree1.right.right = new TreeNode(7);
        System.out.println(inorderTraversal(tree1));


        TreeNode tree2 = new TreeNode(1);
        tree2.left = new TreeNode(2);
        tree2.right = new TreeNode(3);
        tree2.left.right = new TreeNode(4);
        System.out.println(inorderTraversal(tree2));

        TreeNode tree3 = new TreeNode(1);
        tree3.right = new TreeNode(3);
        System.out.println(inorderTraversal(tree3));
    }
    
    static ArrayList<Integer> result;
    public static ArrayList<Integer> inorderTraversal(TreeNode A) {
        result = new ArrayList<>();
        inorder(A);
        return result;
    }
    static void inorder(TreeNode root){
        TreeNode current, pre;

        if (root == null)
            return;

        current = root;
        while (current != null) {
            if (current.left == null) {
                result.add(current.val);
                current = current.right;
            }
            else {
                /* Find the inorder predecessor of current */
                pre = current.left;
                while (pre.right != null && pre.right != current)
                    pre = pre.right;

                /* Make current as right child of its inorder predecessor */
                if (pre.right == null) {
                    pre.right = current;
                    current = current.left;
                } else {
                    pre.right = null;
                    result.add(current.val);
                    current = current.right;
                }

            }

        } /* End of while */
    }
}

