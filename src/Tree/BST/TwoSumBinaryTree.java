/*  2-Sum Binary Tree

    Given a binary search tree T, where each node contains a positive integer, and an integer K, you have to find whether or not there exist two different nodes A and B such that A.value + B.value = K.
    
    Return 1 to denote that two such nodes exist. Return 0, otherwise.
    
    Notes
    
        Your solution should run in linear time and not take memory more than O(height of T).
        Assume all values in BST are distinct.
    
    Example :
    
    Input 1: 
    
    T :       10
             / \
            9   20
    
    K = 19
    
    Return: 1
    
    Input 2: 
    
    T:        10
             / \
            9   20
    
    K = 40
    
    Return: 0
    
 */
package Tree.BST;

import java.util.HashSet;

public class TwoSumBinaryTree {
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
        TreeNode tree1 = new TreeNode(10);
        tree1.left = new TreeNode(9);
        tree1.right = new TreeNode(20);
        System.out.println(t2Sum(tree1, 19));


        TreeNode tree2 = new TreeNode(10);
        tree2.left = new TreeNode(9);
        tree2.right = new TreeNode(20);
        System.out.println(t2Sum(tree2,40));

    }

    static HashSet<Integer> hs;
    public static int t2Sum(TreeNode A, int B) {
        hs = new HashSet<>();
        return _isPresent(A,B)?1:0;
    }

    private static boolean _isPresent(TreeNode A, int B) {
        if(A == null) return false;
//        if(A.val > B) return false;
        if(hs.contains(A.val)) return true;
        hs.add(B-A.val);
        return _isPresent(A.left, B) || _isPresent(A.right, B);
    }
}
