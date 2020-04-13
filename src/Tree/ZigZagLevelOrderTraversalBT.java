/*  ZigZag Level Order Traversal BT

    Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
    Example : Given binary tree
        3
       / \
      9  20
        /  \
       15   7
    return
    [
             [3],
             [20, 9],
             [15, 7]
    ]

 */
package Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;

public class ZigZagLevelOrderTraversalBT {
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
        System.out.println(zigzagLevelOrder(tree1));


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
        System.out.println(zigzagLevelOrder(tree2));

        TreeNode tree3 = new TreeNode(1);
        tree3.right = new TreeNode(3);
        System.out.println(zigzagLevelOrder(tree3));
    }

    static TreeMap<Integer, ArrayList<Integer>> map;
    static int height;
    public static ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) {
        map = new TreeMap<>();
        height = Integer.MIN_VALUE;
        getLevel(A, 0);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>(map.values());
        for(int i=0; i < result.size(); i++){
            if(i%2 == 1){
                ArrayList<Integer> temp = result.get(i);
                Collections.reverse(temp);
                result.set(i, temp);
            }
        }
        return result;
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
