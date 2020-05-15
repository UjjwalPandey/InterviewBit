/*  Distance between Nodes of BST
    
    Given a binary search tree of integers A.
    
    Return the distance between two nodes with given two keys B and C. It may be assumed that both keys exist in BST.
    
    Note: Distance between two nodes is number of edges between them.
    
    Constraints
    
    1 <= Number of nodes in binary tree <= 1000000
    0 <= node values <= 10^9 
    
    For Example
    
    Input 1:
        A  =    5
              /   \
             2    8
            / \  / \
           1   4 6  11
        B = 2
        C = 11
    Output 1:
        3
    
 */
package Tree.BST;

import java.util.ArrayList;

public class DistanceBetweenNodesOfBST {
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
        tree1.left.left.left = new TreeNode(9);
        System.out.println(solve(tree1,32, 9));
        System.out.println(solve(tree1,27, 9));


        TreeNode tree2 = new TreeNode(5);
        tree2.left = new TreeNode(2);
        tree2.right = new TreeNode(8);
        tree2.left.right = new TreeNode(4);
        tree2.left.left = new TreeNode(1);
        tree2.right.left = new TreeNode(6);
        tree2.right.right = new TreeNode(11);
        System.out.println(solve(tree2,2, 11));

    }

    static ArrayList<Integer> list1, list2;
    static boolean isFound;

    // Finding LCA type solution.
    private static int solve(TreeNode root, int n1, int n2) {
        if(root == null) return -1;
        isFound = false;
        list1 = new ArrayList<>();
        list2 = new ArrayList<>();
        fillQueue(root, n1, list1);
        if(!isFound) return -1;
        isFound = false;
        fillQueue(root, n2, list2);
        if(!isFound) return -1;
        if(list1.isEmpty() || list2.isEmpty()) return -1;
        int result = list1.size()+list2.size();
        int size = Math.min(list1.size(), list2.size());
        int i=0;
        while (i < size){
            if(!list1.get(i).equals(list2.get(i))){
                return result;
            }
            result -= 2;
            i++;
        }
        return result;
    }

    private static void fillQueue(TreeNode root, int N, ArrayList<Integer> list) {
        if(root == null) return;
        if (root.val == N) {
            list.add(N);
            isFound = true;
            return;
        }
        list.add(root.val);
        fillQueue(root.left, N, list);
        if (isFound) return;
        fillQueue(root.right, N, list);
        if (isFound) return;
        list.remove(list.size()-1);
    }
}
