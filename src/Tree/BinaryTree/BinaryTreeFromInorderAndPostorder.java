package Tree.BinaryTree;

import java.util.ArrayList;

public class BinaryTreeFromInorderAndPostorder {
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
        ArrayList<Integer> inOrder = new ArrayList<>();
        ArrayList<Integer> postOrder = new ArrayList<>();
        inOrder.add(2);
        inOrder.add(1);
        inOrder.add(3);

        postOrder.add(2);
        postOrder.add(3);
        postOrder.add(1);

        preOrder(buildTree(inOrder, postOrder));
    }

    /* This funtcion is here just to test  */
    static void preOrder(TreeNode node){
        if (node == null)
            return;
        System.out.print(node.val + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    static class Index {
        int index;
    }

    public static TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B) {
        int n = A.size();
        Index pIndex = new Index();
        pIndex.index = n - 1;
        return buildUtil(A, B, 0, n - 1, pIndex);
    }

    static TreeNode buildUtil(ArrayList<Integer> in, ArrayList<Integer> post, int inStart, int inEnd, Index pIndex){
        // Base case
        if (inStart > inEnd)
            return null;

        /* Pick current node from PostOrder traversal using
           postIndex and decrement postIndex */
        TreeNode node = new TreeNode(post.get(pIndex.index));
        (pIndex.index)--;

        /* If this node has no children then return */
        if (inStart == inEnd)
            return node;

        /* Else find the index of this node in Inorder
           traversal */
        int iIndex = search(in, inStart, inEnd, node.val);

        /* Using index in Inorder traversal, construct left and
           right subtress */
        node.right = buildUtil(in, post, iIndex + 1, inEnd, pIndex);
        node.left = buildUtil(in, post, inStart, iIndex - 1, pIndex);

        return node;
    }

    static int search(ArrayList<Integer> arr, int strt, int end, int value){
        int i;
        for (i = strt; i <= end; i++) {
            if (arr.get(i) == value)
                break;
        }
        return i;
    }

}
