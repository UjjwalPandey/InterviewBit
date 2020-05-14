/*  Balanced Binary Tree
    Given a binary tree, determine if it is height-balanced.
     Height-balanced binary tree : is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
    Return 0 / 1 ( 0 for false, 1 for true ) for this problem Example :
    Input :
              1
             / \
            2   3

    Return : True or 1

    Input 2 :
             3
            /
           2
          /
         1

    Return : False or 0
             Because for the root node, left subtree has depth 2 and right subtree has depth 0.
             Difference = 2 > 1.

 */
package Tree.BinaryTree;

public class BalancedBinaryTree {
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
        System.out.println(isBalanced(tree1));


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
        System.out.println(isBalanced(tree2));

        TreeNode tree3 = new TreeNode(1);
        tree3.right = new TreeNode(3);
        System.out.println(isBalanced(tree3));
    }

    static boolean flag;
    public static int isBalanced(TreeNode A) {
        flag = false;
        int left = getHeight(A.left);
        int right = getHeight(A.right);
        if(flag) return 0;
        return (Math.abs(left-right) > 1)?0:1;
    }

    private static int getHeight(TreeNode tree) {
        if(tree == null || flag) return 0;
        int left = getHeight(tree.left);
        int right =getHeight(tree.right);
        flag = Math.abs(left - right) > 1;
        return Math.max(left, right)+1;
    }
}
