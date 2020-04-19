/*  Largest BST Subtree

    Given a binary tree. Find the size of largest subtree which is a Binary Search Tree (BST),
     where largest means subtree with the largest number of nodes in it.

    Note:
    A subtree must include all of its descendants.

    For Example

    Input 1:
                         10
                        / \
                       5  15
                      / \   \
                     1   8   7
    Output 1:
        3
        Explanation 1:
            Largest BST subtree is
                                5
                               / \
                              1   8

    Input 2:
                    5
                   / \
                  3   8
                 / \ / \
                1  4 7  9
    Output 2:
         7
         Explanation 2:
            Given binary tree itself is BST.

 */
package Tree;

public class LargestBSTSubtree {
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
        System.out.println(solve(tree1));


        TreeNode tree2 = new TreeNode(10);
        tree2.left = new TreeNode(5);
        tree2.right = new TreeNode(15);
        tree2.right.right = new TreeNode(8);
        tree2.left.left = new TreeNode(1);
        tree2.left.right = new TreeNode(8);
        System.out.println(solve(tree2));

        TreeNode tree3 = new TreeNode(5);
        tree3.left = new TreeNode(3);
        tree3.left.left = new TreeNode(1);
        tree3.left.right = new TreeNode(4);
        tree3.right = new TreeNode(8);
        tree3.right.left = new TreeNode(7);
        tree3.right.right = new TreeNode(9);
        System.out.println(solve(tree3));
    }

    public static int solve(TreeNode A) {
        if(A == null) return 0;
        if(isValidBST(A)){
            return getSize(A);
        }
        return Math.max(solve(A.left),solve(A.right));
    }

    private static int getSize(TreeNode node) {
        if (node == null)
            return 0;
        else
            return(getSize(node.left) + 1 + getSize(node.right));
    }

    public static boolean isValidBST(TreeNode A) {
        return isBSTUtil(A, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    static boolean isBSTUtil(TreeNode node, int min, int max){
        if (node == null)
            return true;

        if (node.val < min || node.val > max)
            return false;

        return (isBSTUtil(node.left, min, node.val-1) &&
                isBSTUtil(node.right, node.val+1, max));
    }
}
