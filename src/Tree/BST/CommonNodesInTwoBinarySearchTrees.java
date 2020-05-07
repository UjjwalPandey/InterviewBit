/*  Common Nodes in Two Binary Search Trees
    
    Problem Description
    
    Given two BST's A and B, return the (sum of all common nodes in both A and B) % (109 +7) .
    
    In case there is no common node, return 0.
    
    NOTE:
    
    Try to do it one pass through the trees.
    
    
    
    Problem Constraints
    
    1 <= Number of nodes in the tree A and B <= 105
    
    1 <= Node values <= 106
    
    
    
    Input Format
    
    First argument represents the root of BST A.
    
    Second argument represents the root of BST B.
    
    
    
    Output Format
    
    Return an integer denoting the (sum of all common nodes in both BST's A and B) % (109 +7) .
    
    
    Example Input
    
    Input 1:
    
     Tree A:
        5
       / \
      2   8
       \   \
        3   15
            /
            9
    
     Tree B:
        7
       / \
      1  10
       \   \
        2  15
           /
          11
    
    Input 2:
    
      Tree A:
        7
       / \
      1   10
       \   \
        2   15
            /
           11
    
     Tree B:
        7
       / \
      1  10
       \   \
        2  15
           /
          11
    
    
    
    Example Output
    
    Output 1:
    
     17
    
    Output 2:
    
     46
    
    
    
    Example Explanation
    
    Explanation 1:
    
     Common Nodes are : 2, 15
     So answer is 2 + 15 = 17
    
    Explanation 2:
    
     Common Nodes are : 7, 2, 1, 10, 15, 11
     So answer is 7 + 2 + 1 + 10 + 15 + 11 = 46


 */
package Tree.BST;

import java.util.HashSet;
import java.util.Set;

public class CommonNodesInTwoBinarySearchTrees {
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
        TreeNode tree1 = new TreeNode(5);
        tree1.left = new TreeNode(2);
        tree1.left.right = new TreeNode(3);
        tree1.right = new TreeNode(8);
        tree1.right.right = new TreeNode(15);
        tree1.right.right.left = new TreeNode(9);


        TreeNode tree2 = new TreeNode(7);
        tree2.left = new TreeNode(1);
        tree2.left.right = new TreeNode(2);
        tree2.right = new TreeNode(10);
        tree2.right.right = new TreeNode(15);
        tree2.right.right.left = new TreeNode(11);

        System.out.println(solve(tree1,tree2));

    }

    static int result;
    static Set<Integer> setA;
    static int MOD = 1000000007;
    public static int solve(TreeNode A,TreeNode B) {
        result =0;
        setA = new HashSet<>();
        fillSet(A);
        commonNode(B);
        return result;
    }

    private static void commonNode(TreeNode B) {
        if(B == null) return;
        if(setA.contains(B.val)) result = (result+B.val)%MOD;
        commonNode(B.left);
        commonNode(B.right);
    }

    private static void fillSet(TreeNode A) {
        if(A == null) return;
        setA.add(A.val);
        fillSet(A.left);
        fillSet(A.right);
    }
}
