/*  Level Order
    Given a binary tree, return the level order traversal of its nodes' values.
    (ie, from left to right, level by level). Example : Given binary tree
        3
       / \
      9  20
        /  \
       15   7
    return its level order traversal as:
    [
      [3],
      [9,20],
      [15,7]
    ]
    Also think about a version of the question where you are asked to do a
    level order traversal of the tree when depth of the tree is much greater than number of nodes on a level.

 */
package Tree.BinaryTree;

import java.util.ArrayList;
import java.util.TreeMap;

public class LevelOrder {
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
        System.out.println(levelOrder(tree1));


        TreeNode tree2 = new TreeNode(1);
        tree2.left = new TreeNode(2);
        tree2.right = new TreeNode(3);
        tree2.left.left = new TreeNode(4);
        tree2.left.right = new TreeNode(5);
        tree2.right.left = new TreeNode(6);
        tree2.right.right = new TreeNode(7);
        tree2.left.left.left = new TreeNode(8);
        tree2.left.left.right = new TreeNode(9);
        tree2.left.left.right.left = new TreeNode(10);
        System.out.println(levelOrder(tree2));

        TreeNode tree3 = new TreeNode(1);
        tree3.right = new TreeNode(3);
        System.out.println(levelOrder(tree3));
    }

    static TreeMap<Integer, ArrayList<Integer>> map;
    static int height;
    public static ArrayList<ArrayList<Integer>> levelOrder(TreeNode A) {
        map = new TreeMap<>();
        height = Integer.MIN_VALUE;
        getLevel(A, 0);
        return new ArrayList<>(map.values());
    }

    private static void getLevel(TreeNode A, int level) {
        if(A ==  null) return;
        height = Math.max(height, level);
        ArrayList<Integer> val = map.getOrDefault(level, new ArrayList<>());
        val.add(A.val);
        map.put(level, val);
        getLevel(A.left, level+1);
        getLevel(A.right, level+1);
    }
}
