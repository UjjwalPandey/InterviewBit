/*  Find the lowest common ancestor in an unordered binary tree given two values in the tree.

 Lowest common ancestor : the lowest common ancestor (LCA) of two nodes v and w in a tree or directed acyclic graph (DAG) is the lowest (i.e. deepest) node that has both v and w as descendants.
Example :


        _______3______
       /              \
    ___5__          ___1__
   /      \        /      \
   6      _2_     0        8
         /   \
         7    4
For the above tree, the LCA of nodes 5 and 1 is 3.

 LCA = Lowest common ancestor
Please note that LCA for nodes 5 and 4 is 5.

You are given 2 values. Find the lowest common ancestor of the two nodes represented by val1 and val2
No guarantee that val1 and val2 exist in the tree. If one value doesn’t exist in the tree then return -1.
There are no duplicate values.
You can use extra memory, helper functions, and can modify the node struct but, you can’t add a parent pointer.
 NOTE: You only need to implement the given function. Do not read input, instead use the arguments to the function. Do not print the output, instead return values as specified. Still have a doubt? Checkout Sample Codes for more details

 */
package Tree;

import java.util.ArrayList;

public class LeastCommonAncestor {
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
        tree1.left.right = new TreeNode(4);
        tree1.left.right.right = new TreeNode(5);
        System.out.println(findLCA(tree1,5,4));
        System.out.println(lowestCommonAncestor(tree1,new TreeNode(5),new TreeNode(4)).val);

        TreeNode tree2 = new TreeNode(1);
        tree2.left = new TreeNode(2);
        tree2.right = new TreeNode(3);
        tree2.left.left = new TreeNode(4);
        tree2.left.right = new TreeNode(5);
        tree2.right.left = new TreeNode(6);
        tree2.right.right = new TreeNode(7);
        tree2.left.left.left = new TreeNode(8);
        System.out.println(findLCA(tree2,4,5));
        System.out.println(lowestCommonAncestor(tree2,new TreeNode(4),new TreeNode(5)).val);
    }

    /**
        Integer value based
     */
    static ArrayList<Integer> list1, list2;
    static boolean isFound;
    private static int findLCA(TreeNode root, int n1, int n2) {
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
        int result = -1;
        int size = Math.min(list1.size(), list2.size());
        int i=0;
        while (i < size){
            if(!list1.get(i).equals(list2.get(i))) return result;
            result = list1.get(i++);
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


    /**
     TreeNode based
     */
    static ArrayList<TreeNode> list1TreeNode, list2TreeNode;
    static boolean isFoundTreeNode;
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode n1, TreeNode n2){
        if(root == null) return null;
        isFoundTreeNode = false;
        list1TreeNode = new ArrayList<>();
        list2TreeNode = new ArrayList<>();
        fillQueue(root, n1, list1TreeNode);
        if(!isFoundTreeNode) return null;
        isFoundTreeNode = false;
        fillQueue(root, n2, list2TreeNode);
        if(!isFoundTreeNode) return null;
        if(list1.isEmpty() || list2.isEmpty()) return null;
        TreeNode result = null;
        int size = Math.min(list1.size(), list2.size());
        int i=0;
        while (i < size){
            if(list1TreeNode.get(i).val != list2TreeNode.get(i).val) return result;
            result = list1TreeNode.get(i++);
        }
        return result;
    }

    private static void fillQueue(TreeNode root, TreeNode N, ArrayList<TreeNode> list) {
        if(root == null) return;
        if (root.val == N.val) {
            list.add(N);
            isFoundTreeNode = true;
            return;
        }
        list.add(root);
        fillQueue(root.left, N, list);
        if (isFoundTreeNode) return;
        fillQueue(root.right, N, list);
        if (isFoundTreeNode) return;
        list.remove(root);
    }
}
