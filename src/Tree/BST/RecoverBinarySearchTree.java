/*  Recover Binary Search Tree
    
    Two elements of a binary search tree (BST) are swapped by mistake. Tell us the 2 values swapping which the tree will be restored.
    
        Note: A solution using O(n) space is pretty straight forward. Could you devise a constant space solution? 
    
    Example :
    
    Input : 
             1
            / \
           2   3
    
    Output : 
           [1, 2]
    
    Explanation : Swapping 1 and 2 will change the BST to be 
             2
            / \
           1   3
    which is a valid BST          
    
    See Expected Output


 */
package Tree.BST;

import java.util.Arrays;

public class RecoverBinarySearchTree {
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
        TreeNode tree1 = new TreeNode(32);
        tree1.left = new TreeNode(25);
        tree1.right = new TreeNode(46);
        tree1.left.left = new TreeNode(17);
        tree1.left.right = new TreeNode(27);
        tree1.right.left = new TreeNode(40);
        tree1.right.right = new TreeNode(49);
        tree1.left.left.right = new TreeNode(9);
        System.out.println(Arrays.toString(recoverTree(tree1)));


        TreeNode tree2 = new TreeNode(5);
        tree2.left = new TreeNode(2);
        tree2.right = new TreeNode(8);
        tree2.left.right = new TreeNode(4);
        tree2.left.left = new TreeNode(1);
        tree2.right.left = new TreeNode(6);
        tree2.right.right = new TreeNode(11);
        System.out.println(Arrays.toString(recoverTree(tree2)));

    }

    static TreeNode first, middle, last, prev;
    static void correctBSTUtil( TreeNode root) {
        if( root != null ) {
            correctBSTUtil( root.left);
            if (prev != null && root.val < prev.val) {
                if (first == null) {
                    first = prev;
                    middle = root;
                }
                else last = root;
            }
            prev = root;
            correctBSTUtil( root.right);
        }
    }

    static int[] recoverTree(TreeNode root ) {
        first = middle = last = prev = null;
        correctBSTUtil( root );
        if( first != null && last != null ) {
            return new int[]{Math.min(first.val, last.val), Math.max(first.val, last.val)};
        } else if( first != null && middle != null ) {
            return new int[]{Math.min(first.val, middle.val), Math.max(first.val, middle.val)};
        }
        return new int[]{};
    }

}
