/* Invert the Binary Tree
 *
 * Asked in:  Google
 *
 * Given a binary tree, invert the binary tree and return it.
 * Look at the example for more details.
 *
 * Example :
 * Given binary tree
 *
 *      1
 *    /   \
 *   2     3
 *  / \   / \
 * 4   5 6   7
 * invert and return
 *
 *      1
 *    /   \
 *   3     2
 *  / \   / \
 * 7   6 5   4
 *
 */
package Tree.BinaryTree;

public class InvertTheBinaryTree {
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
        printPreOrder(tree1);
        System.out.println("\n");
        invert(tree1);
        printPreOrder(tree1);
        System.out.println("\n");


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
        printPreOrder(tree2);
        System.out.println("\n");
        invert(tree2);
        printPreOrder(tree2);
        System.out.println("\n");

        TreeNode tree3 = new TreeNode(1);
        tree3.left = new TreeNode(2);
        tree3.left.left = new TreeNode(3);
        tree3.left.right = new TreeNode(4);
        tree3.right = new TreeNode(5);
        tree3.right.right = new TreeNode(6);
        printPreOrder(tree3);
        System.out.println("\n");
        invert(tree3);
        printPreOrder(tree3);
        System.out.println("\n");
    }
    private static void printPreOrder(TreeNode node) {
        if(node == null){ System.out.print(" * "); return;}
        System.out.print(node.val+"   ");
        printPreOrder(node.left);
        printPreOrder(node.right);
    }

    public static void invert(TreeNode root){
        if(root == null) return;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invert(root.left);
        invert(root.right);
    }

}
