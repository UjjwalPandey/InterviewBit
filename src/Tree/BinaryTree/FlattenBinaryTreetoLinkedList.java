/* Flatten Binary Tree to Linked List
 *
 * Given a binary tree, flatten it to a linked list in-place.
 *
 * Example :
 * Given
 *
 *          1
 *         / \
 *        2   5
 *       / \   \
 *      3   4   6
 * The flattened tree should look like:
 *
 *    1
 *     \
 *      2
 *       \
 *        3
 *         \
 *          4
 *           \
 *            5
 *             \
 *              6
 * Note that the left child of all nodes should be NULL.
 */
package Tree.BinaryTree;

public class FlattenBinaryTreetoLinkedList {
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
        flatten(tree1);
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
        flatten(tree2);
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
        flatten(tree3);
        printPreOrder(tree3);
        System.out.println("\n");
    }
    private static void printPreOrder(TreeNode node) {
        if(node == null){ System.out.print(" * "); return;}
        System.out.print(node.val+"   ");
        printPreOrder(node.left);
        printPreOrder(node.right);
    }

    public static void flatten(TreeNode root){
        util(root);
    }

    public static void util(TreeNode node){
        if(node == null) return;
        util(node.left);
        if(node.left != null){
            TreeNode temp = node.right;
            node.right = node.left;
            TreeNode rightmost = rightmostNode(node.left);
            rightmost.right = temp;
            node.left = null;
        }
        util(node.right);
    }

    public static TreeNode rightmostNode(TreeNode node){
        while (node.right != null) node = node.right;
        return  node;
    }

}
