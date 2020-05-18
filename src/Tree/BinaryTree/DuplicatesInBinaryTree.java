/*  Duplicates in binary tree

    Given a binary tree of integers. Return whether it contains a duplicate sub-tree of size 2 or more.
    
    All node values lie between 0 and 9 inclusive.
    
    Return 1 if it contains a duplicate sub-tree of size 2 or more else return 0.
    
    Note: Two same leaf nodes are not considered as a subtree, As the size of a leaf node is one.
    
    Constraints
    
    1 <= Number of nodes in binary tree <= 10000
    0 <= node values <= 9
    
    For Example
    
    Input 1:
                1
              /   \
             2     6
            / \     \
           4   5     2
                    / \
                   4   5
    
    Output 1:
        1
    
        Duplicate Subtree     2
                             / \
                            4   5
    
    Input 2:
                1
               /  \
              2    3
               \
                4
                 \
                  5
    Output 2:
        0
    


 */
package Tree.BinaryTree;

import java.util.HashSet;

public class DuplicatesInBinaryTree {
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
        tree1.right = new TreeNode(6);
        tree1.left.left = new TreeNode(4);
        tree1.left.right = new TreeNode(5);
        tree1.right.right = new TreeNode(2);
        tree1.right.right.left = new TreeNode(4);
        tree1.right.right.right = new TreeNode(5);
        System.out.println(solve(tree1));

        TreeNode tree2 = new TreeNode(1);
        tree2.left = new TreeNode(2);
        tree2.right = new TreeNode(3);
        tree2.left.right = new TreeNode(4);
        tree2.right.left = new TreeNode(6);
        System.out.println(solve(tree2));

        TreeNode tree3 = new TreeNode(4);
        tree3.left = new TreeNode(0);
        tree3.right = new TreeNode(9);
        tree3.left.left = new TreeNode(9);
        tree3.left.right = new TreeNode(1);
        tree3.right.left = new TreeNode(7);
        tree3.right.right = new TreeNode(6);
        tree3.left.left.left = new TreeNode(7);
        tree3.left.left.right = new TreeNode(6);
        System.out.println(solve(tree3));
    }


    public static int solve(TreeNode A) {
        return (dupSub(A).equals("")?1:0);
    }

    public static String dupSub(TreeNode root){
        HashSet<String> subtrees=new HashSet<>();
        return dupSubUtil(root,subtrees);
    }

    static char MARKER = '$';

    public static String dupSubUtil(TreeNode root, HashSet<String> subtrees){
        String s = "";
        if (root == null)
            return s + MARKER;

        String lStr = dupSubUtil(root.left,subtrees);
        if (lStr.equals(s))
            return s;

        String rStr = dupSubUtil(root.right,subtrees);
        if (rStr.equals(s))
            return s;

        s = s + root.val + lStr + rStr;

        if (s.length() > 3 && subtrees.contains(s))
            return "";

        subtrees.add(s);
        return s;
    }
}
