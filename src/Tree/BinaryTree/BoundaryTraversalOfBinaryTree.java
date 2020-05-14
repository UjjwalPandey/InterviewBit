/*  Boundary Traversal Of Binary Tree

    Given a binary tree. Given a binary tree, return the values of its boundary in anti-clockwise direction starting from the root. Boundary includes left boundary, leaves, and right boundary in order without duplicate nodes. Left boundary is defined as the path from the root to the left-most node. Right boundary is defined as the path from the root to the right-most node. If the root doesn't have left subtree or right subtree, then the root itself is left boundary or right boundary. Note this definition only applies to the input binary tree, and not applies to any subtrees. The left-most node is defined as a leaf node you could reach when you always firstly travel to the left subtree if exists. If not, travel to the right subtree. Repeat until you reach a leaf node. The right-most node is also defined by the same way with left and right exchanged. 
    Return an array of integers denoting the boundary values of tree in anti-clockwise order. 
    For Example
    Input 1:
                   _____1_____
                  /           \
                 2             3
                / \            / 
               4   5          6   
                  / \        / \
                 7   8      9  10  
    Output 1:
        [1, 2, 4, 7, 8, 9, 10, 6, 3]
        Explanation 1:
            The left boundary are node 1,2,4. (4 is the left-most node according to definition)
            The leaves are node 4,7,8,9,10.
            The right boundary are node 1,3,6,10. (10 is the right-most node).
            So order them in anti-clockwise without duplicate nodes we have [1,2,4,7,8,9,10,6,3].
    
    Input 2:
                    1
                   / \
                  2   3
                 / \  / \
                4   5 6  7
    Output 2:
         [1, 2, 4, 5, 6, 7, 3] 

 */
package Tree.BinaryTree;

import java.util.ArrayList;
import java.util.TreeMap;

public class BoundaryTraversalOfBinaryTree {
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
        System.out.println(solve(tree1));


        TreeNode tree2 = new TreeNode(1);
        tree2.left = new TreeNode(2);
        tree2.right = new TreeNode(3);
        tree2.left.left = new TreeNode(4);
        tree2.left.right = new TreeNode(5);
        tree2.left.right.left = new TreeNode(7);
        tree2.left.right.right = new TreeNode(8);
        tree2.right.left = new TreeNode(6);
        tree2.right.left.left = new TreeNode(9);
        tree2.right.left.right = new TreeNode(10);
        System.out.println(solve(tree2));

        TreeNode tree3 = new TreeNode(1);
        tree3.right = new TreeNode(3);
        System.out.println(solve(tree3));
    }

    static ArrayList<Integer> result;
    static TreeMap<Integer, ArrayList<Integer>> tm;
    public static ArrayList<Integer> solve(TreeNode A) {
        result = new ArrayList<>();
        tm = new TreeMap<>();
        getBoundary(A,0);
        ArrayList<ArrayList<Integer>> allLevels = new ArrayList<>(tm.values());
//        System.out.println(allLevels);
        int size = allLevels.size();
        for(int i= size-2; i>=0; i--){
            if(allLevels.get(i).size() > 1){
                ArrayList<Integer> levelNodes = allLevels.get(i);
                int rightNode = levelNodes.get(levelNodes.size()-1);
                if(!result.contains(rightNode))
                    result.add(rightNode);
            }
        }
        return result;
    }

    private static void getBoundary(TreeNode A, int verticalLevel) {
        if(A==null) return;
        ArrayList<Integer> sameLevelNodes = tm.getOrDefault(verticalLevel, new ArrayList<>());
        if(sameLevelNodes.size() == 0){
            result.add(A.val);
        }
        sameLevelNodes.add(A.val);
        tm.put(verticalLevel, sameLevelNodes);
        if(A.left==null && A.right == null){
            if(sameLevelNodes.size() > 1) result.add(A.val);
            return;
        }

        getBoundary(A.left, verticalLevel+1);
        getBoundary(A.right, verticalLevel+1);
    }
}
