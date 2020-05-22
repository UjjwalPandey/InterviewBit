/*  Sorted Array To Balanced BST

    Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

        Balanced tree : a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

    Example :

    Given A : [1, 2, 3]
    A height balanced BST  :

          2
        /   \
       1     3



 */
package Tree.BST;

public class SortedArrayToBalancedBST {
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
        TreeNode A = solve(new int[]{1,2,3});
        printPreOrder(A);
        TreeNode B = solve(new int[]{1});
        printPreOrder(B);
    }

    public static TreeNode solve(final int[] A) {
        return sortedArrayToBST(A, 0, A.length-1);
    }

    public static TreeNode sortedArrayToBST(int[] arr, int start, int end) {
        /* Base Case */
        if (start > end) {
            return null;
        }
        /* Get the middle element and make it root */
        int mid = start + (end - start)/2;
        TreeNode node = new TreeNode(arr[mid]);
        /* Recursively construct the left subtree and make it
         left child of root */
        node.left = sortedArrayToBST(arr, start, mid - 1);
        /* Recursively construct the right subtree and make it
         right child of root */
        node.right = sortedArrayToBST(arr, mid + 1, end);
        return node;
    }

    private static void printPreOrder(TreeNode node) {
        if(node == null) return;
        System.out.print(node.val+"   ");
        printPreOrder(node.left);
        printPreOrder(node.right);
    }

}
