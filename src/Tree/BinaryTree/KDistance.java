/*  K DISTANCE

    Problem Description
    Given a balanced binary tree of integers and an integer B, count the number of pairs (a, b) where:
    a is ancestor of b.
    Absolute difference between value of node a and value of node b <= B
        
    Problem Constraints
    1 <= Number of nodes in binary tree <= 105
    0 <= node values <= 105
    1 <= B <= 105
    
    Input Format
    First argument is the root of the binary tree.
    Second argument is an integer B.
    
    Output Format
    Return an integer denoting the number of pairs satisfying the condition.
    
    Example Input
    Input 1:
            1
          /   \
         2    3
        / \  / \
       4   5 6  7
      /
     8
     B = 1
    Input 2:
        1
      /   \
     2     3
      \
       4
     B = 2
      
    
    
    Example Output
    Output 1:
     1
    Output 2:
     3
         
    
    
    Example Explanation
    Explanation 1:
     Only possible pair is (1, 2).
    Explanation 2:
     3 possible pair exists: {(1, 2), (2, 4), (1, 3)}.

 */
package Tree.BinaryTree;

import java.util.ArrayList;

public class KDistance {
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
        tree1.left.left = new TreeNode(4);
        tree1.left.right = new TreeNode(5);
        tree1.left.left.left = new TreeNode(8);
        tree1.right.left = new TreeNode(6);
        tree1.right.right = new TreeNode(7);
        System.out.println(solve(tree1,1));


        TreeNode tree2 = new TreeNode(1);
        tree2.left = new TreeNode(2);
        tree2.right = new TreeNode(3);
        tree2.left.right = new TreeNode(4);
        System.out.println(solve(tree2,2));

        TreeNode tree3 = new TreeNode(1);
        tree3.right = new TreeNode(3);
        System.out.println(solve(tree3,3));
    }


    static int result ;
    public static int solve(TreeNode A, int B) {
        ArrayList<Integer> stack = new ArrayList<>();
        result = 0;
        getKDistancePair(A,B,stack);
        return result;
    }

    private static void getKDistancePair(TreeNode A, int B, ArrayList<Integer> stack) {
        if(A == null) return;
        int val = A.val;
        for(int x: stack){
            if(Math.abs(val-x) <= B) result++;
        }
        stack.add(val);
        getKDistancePair(A.left, B, stack);
        getKDistancePair(A.right, B, stack);
        stack.remove(stack.size()-1);
    }
}
