/*  Difference between odd and even levels

    Given a binary tree of integers. Find the difference between the sum of nodes at odd level and sum of nodes at even
     level. Note: Consider the level of root node as 1. Constraints
    1 <= Number of nodes in binary tree <= 100000
    0 <= node values <= 10^9
    For Example
    Input 1:
                1
              /   \
             2    3
            / \  / \
           4   5 6  7
          /
         8
    Output 1:
        10
        Sum of nodes at odd level = 23
        Sum of ndoes at even level = 13

    Input 2:
                1
               /  \
              2    10
               \
                4
    Output 2:
        -7
        Sum of nodes at odd level = 5
        Sum of ndoes at even level = 12

 */
package Tree;

public class DifferenceBetweenOddAndEvenLevels {
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
        tree1.right = new TreeNode(10);
        tree1.left.right = new TreeNode(4);
        System.out.println(solve(tree1));

        TreeNode tree2 = new TreeNode(1);
        tree2.left = new TreeNode(2);
        tree2.right = new TreeNode(3);
        tree2.left.left = new TreeNode(4);
        tree2.left.right = new TreeNode(5);
        tree2.right.left = new TreeNode(6);
        tree2.right.right = new TreeNode(7);
        tree2.left.left.left = new TreeNode(8);
        System.out.println(solve(tree2));
    }

    static int odd, even;
    public static int solve(TreeNode A) {
        odd = 0;
        even = 0;
        findOddEvenDiff(A,1);
        return odd-even;
    }

    public static void findOddEvenDiff(TreeNode A, int level) {
        if(A == null){
            return;
        }
        if(level%2 == 0){
            even += A.val;
        }else{
            odd += A.val;
        }
        findOddEvenDiff(A.left, level+1);
        findOddEvenDiff(A.right, level+1);
    }
}
