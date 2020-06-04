/*  Construct Binary Tree From Inorder And Preorder

    Given preorder and inorder traversal of a tree, construct the binary tree.
     Note: You may assume that duplicates do not exist in the tree.
    Example :
    Input :
            Preorder : [1, 2, 3]
            Inorder  : [2, 1, 3]

    Return :
                1
               / \
              2   3

 */
package Tree.BinaryTree;

public class ConstructBinaryTreeFromInorderAndPreorder {
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
    static int preIndex = 0;
    static TreeNode buildTreeRecurr(int[] in, int[] pre, int inStrt, int inEnd) {
        if (inStrt > inEnd)
            return null;

        TreeNode tNode = new TreeNode(pre[preIndex++]);

        if (inStrt == inEnd)
            return tNode;
        int inIndex = search(in, inStrt, inEnd, tNode.val);
        tNode.left = buildTreeRecurr(in, pre, inStrt, inIndex - 1);
        tNode.right = buildTreeRecurr(in, pre, inIndex + 1, inEnd);

        return tNode;
    }

    static int search(int[] arr, int strt, int end, int value) {
        int i;
        for (i = strt; i <= end; i++) {
            if (arr[i] == value)
                return i;
        }
        return i;
    }

    /* This funtcion is here just to test buildTree() */
    static void printPreorder(TreeNode node) {
        if (node == null)
            return;

        /* then print the data of node */
        System.out.print(node.val + " ");

        /* first recur on left child */
        printPreorder(node.left);

        /* now recur on right child */
        printPreorder(node.right);
    }

    public static TreeNode buildTree(int[] pre, int[] in) {
        preIndex = 0;
        return buildTreeRecurr(in, pre, 0, in.length - 1);
    }

    public static void main(String[] args){
        int[] in = {3, 2, 4, 1, 5};
        int[] pre = {1, 2, 3, 4, 5 };
        TreeNode root = buildTree(pre,in);

        int[] in2 = {5, 6, 1, 2, 3, 4 };
        int[] pre2 = {2, 1, 6, 5, 3, 4 };
        TreeNode root2 = buildTree(pre2,in2);

        // building the tree by printing inorder traversal
        System.out.println("Inorder traversal of constructed tree is : ");
        printPreorder(root);
        System.out.println();
        printPreorder(root2);
    }
}
