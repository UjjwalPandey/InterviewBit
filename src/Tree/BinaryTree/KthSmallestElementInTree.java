/*  Kth Smallest Element In Tree

    Given a binary search tree, write a function to find the kth smallest element in the tree.
    Example :
    Input :
      2
     / \
    1   3

    and k = 2

    Return : 2

    As 2 is the second smallest element in the tree.
     NOTE : You may assume 1 <= k <= Total number of nodes in BST

 */
package Tree.BinaryTree;

public class KthSmallestElementInTree {
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
        TreeNode tree1 = new TreeNode(2);
        tree1.left = new TreeNode(1);
        tree1.right = new TreeNode(3);
        System.out.println(kthsmallest(tree1, 2));

        TreeNode tree2 = new TreeNode(1);
        tree2.left = new TreeNode(2);
        tree2.right = new TreeNode(3);
        tree2.left.left = new TreeNode(4);
        tree2.left.right = new TreeNode(5);
        tree2.right.left = new TreeNode(6);
        tree2.right.right = new TreeNode(7);
        tree2.left.left.left = new TreeNode(8);
        System.out.println(kthsmallest(tree2, 4));
    }

    public static int counter, result;
    public static int kthsmallest(TreeNode A, int B) {
        counter = B;
        preOrder(A);
        return result;
    }

    private static void preOrder(TreeNode A) {
        if(A == null) return;
        preOrder(A.left);
        if(--counter == 0){
            result = A.val;
            return;
        }
        preOrder(A.right);
    }
}
