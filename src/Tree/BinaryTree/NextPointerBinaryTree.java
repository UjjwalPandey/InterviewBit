/*  Next Pointer Binary Tree

    Given a binary tree
        struct TreeLinkNode {
          TreeLinkNode *left;
          TreeLinkNode *right;
          TreeLinkNode *next;
        }
    Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL. Initially, all next pointers are set to NULL.
     Note:
    You may only use constant extra space.
    You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
    Example : Given the following perfect binary tree,
             1
           /  \
          2    5
         / \  / \
        3  4  6  7
    After calling your function, the tree should look like:
             1 -> NULL
           /  \
          2 -> 5 -> NULL
         / \  / \
        3->4->6->7 -> NULL

 */
package Tree.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class NextPointerBinaryTree {
    static class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;
        TreeLinkNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        TreeLinkNode tree1 = new TreeLinkNode(1);
        tree1.left = new TreeLinkNode(2);
        tree1.right = new TreeLinkNode(5);
        tree1.left.left = new TreeLinkNode(3);
        tree1.left.right = new TreeLinkNode(4);
        tree1.right.left = new TreeLinkNode(6);
        tree1.right.right = new TreeLinkNode(7);
        connect(tree1);
//        printTree(tree1);

        TreeLinkNode tree2 = new TreeLinkNode(1);
        tree2.left = new TreeLinkNode(2);
        tree2.left.left = new TreeLinkNode(3);
        tree2.left.right = new TreeLinkNode(4);
        tree2.left.left.left = new TreeLinkNode(5);
        tree2.left.left.right = new TreeLinkNode(6);
        tree2.left.left.right.right = new TreeLinkNode(9);
        tree2.left.left.right.right.right = new TreeLinkNode(10);
        tree2.left.left.left.left = new TreeLinkNode(7);
        tree2.left.left.left.left.left = new TreeLinkNode(8);
        tree2.left.left.left.left.left.left = new TreeLinkNode(11);
        connect(tree2);
        printTree(tree2);
    }

    private static void printTree(TreeLinkNode root) {
        if(root.left==null && root.right==null) return;
        TreeLinkNode parent = root;
        TreeLinkNode child = getChildLevelStart(parent);
        while (parent != null){
            TreeLinkNode temp = parent;
            while (temp != null){
                System.out.print(temp.val+"  ");
                temp = temp.next;
            }
            System.out.println();
            parent = child;
            child = getChildLevelStart(child);
        }
    }

    public static void connect(TreeLinkNode root) {
        root.next = null;
        if(root.left==null && root.right==null) return;
        TreeLinkNode parent = root;
        TreeLinkNode child = getChildLevelStart(parent);
        while (parent != null){
            TreeLinkNode temp = parent;
            while (temp != null){
                if(temp.left != null){
                    if(temp.right != null){
                        temp.left.next = temp.right;
                    }else{
                        if(temp.next == null){
                            temp.left.next = null;
                        }else{
                            if(temp.next.left != null)
                                temp.left.next = temp.next.left;
                            else
                                temp.left.next = temp.next.right;
                        }
                    }
                }
                if(temp.right != null){
                    if(temp.next == null){
                        temp.right.next = null;
                    }else{
                        if(temp.next.left != null)
                            temp.right.next = temp.next.left;
                        else
                            temp.right.next = temp.next.right;
                    }
                }

                temp = temp.next;
            }
            parent = child;
            child = getChildLevelStart(child);
        }
    }

    private static TreeLinkNode getChildLevelStart(TreeLinkNode root) {
        TreeLinkNode temp = root;
        while(temp != null){
            if(temp.left != null) return temp.left;
            if(temp.right != null) return temp.right;
            temp = temp.next;
        }
        return null;
    }

    // More Optimized solution. Even handles Non-perfect binary trees
    public static void connectNotPerfectBinaryTree(TreeLinkNode root){
        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        while (queue.peek() != null) {
            int size = queue.size()-1;

            while (size-- > 0) {
                TreeLinkNode node = queue.remove();
                node.next = queue.peek();

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            queue.remove();
            queue.add(null);
        }
    }
}
