/*  Identical Binary Trees

    Given two binary trees, write a function to check if they are equal or not.
    Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
    Return 0 / 1 ( 0 for false, 1 for true ) for this problem Example :
    Input :

       1       1
      / \     / \
     2   3   2   3

    Output :
      1 or True

 */
package Tree;

public class IdenticalBinaryTrees {
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

        TreeNode tree2 = new TreeNode(1);
        tree2.left = new TreeNode(2);
        tree2.right = new TreeNode(3);
        tree2.left.left = new TreeNode(4);
        tree2.left.right = new TreeNode(5);
        tree2.right.left = new TreeNode(6);
        tree2.right.right = new TreeNode(7);
        tree2.left.left.left = new TreeNode(8);
        System.out.println(isSameTree(tree1,tree2));

        TreeNode tree3 = new TreeNode(1);
        tree3.left = new TreeNode(2);
        tree3.right = new TreeNode(3);

        TreeNode tree4 = new TreeNode(1);
        tree4.left = new TreeNode(2);
        tree4.right = new TreeNode(3);
        System.out.println(isSameTree(tree3,tree4));
    }

    static int result;
    public static int isSameTree(TreeNode A, TreeNode B) {
        result = 1;
        if(A == null && B == null ) return 1;
        if(A == null || B == null ) return 0;
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
        check(A.left, B.left);
        check(A.right, B.right);
    }

}
