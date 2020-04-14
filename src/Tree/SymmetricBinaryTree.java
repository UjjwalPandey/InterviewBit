/*  Symmetric Binary Tree
    Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center). Example :
        1
       / \
      2   2
     / \ / \
    3  4 4  3
    The above binary tree is symmetric. But the following is not:
        1
       / \
      2   2
       \   \
       3    3
    Return 0 / 1 ( 0 for false, 1 for true ) for this problem

 */
package Tree;

public class SymmetricBinaryTree {
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
        tree1.right = new TreeNode(2);
        tree1.left.left = new TreeNode(3);
        tree1.left.right = new TreeNode(4);
        tree1.right.left = new TreeNode(4);
        tree1.right.right = new TreeNode(3);

        System.out.println(isSymmetric(tree1));

        TreeNode tree2 = new TreeNode(1);
        tree2.left = new TreeNode(2);
        tree2.right = new TreeNode(2);
        tree2.left.right = new TreeNode(3);
        tree2.right.right = new TreeNode(3);
        System.out.println(isSymmetric(tree2));
    }

    static int result;
    public static int isSymmetric(TreeNode A) {
        if(A == null || (A.left == null && A.right == null)) return 1;
        if(A.left == null || A.right == null) return 0;
        result = 1;
        return isMirrorTree(A.left, A.right);
    }
    public static int isMirrorTree(TreeNode A, TreeNode B) {
        check(A, B);
        return result;
    }

    private static void check(TreeNode A, TreeNode B) {
        if(A == null && B == null){
            return;
        }
        if(A == null && B != null){
            result =0;
            return;
        }
        if(A != null && B == null){
            result =0;
            return;
        }
        if(A.val != B.val){
            result =0;
            return;
        }
        check(A.left, B.right);
        check(A.right, B.left);
    }

}
