package Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class AdobeCodeDiva2 {
static class Node {
    int key;
    Node left, right;

    public Node(int key){
        this.key = key;
        left = right = null;
    }
}

static  class BinaryTree{
    Node root;

    // Creates a node with key as 'i'.  If i is root, then it changes
    // root.  If parent of i is not created, then it creates parent first
    void createNode(int[] parent, int i, Node[] created){
        // If this node is already created
        if (created[i] != null)
            return;

        // Create a new node and set created[i]
        created[i] = new Node(i);

        // If 'i' is root, change root pointer and return
        if (parent[i] == -1){
            root = created[i];
            return;
        }

        // If parent is not created, then create parent first
        if (created[parent[i]] == null)
            createNode(parent, parent[i], created);

        // Find parent pointer
        Node p = created[parent[i]];

        // If this is first child of parent
        if (p.left == null)
            p.left = created[i];
        else // If second child
            p.right = created[i];
    }


    Node createTree(int[] parent, int n){
        Node[] created = new Node[n+1];
        int[] parentWithRootZero = new int[n+1];
        created[0] = null;
        parentWithRootZero[0] = -1;
        for (int i = 0; i < n; i++) {
            created[i+1] = null;
            parentWithRootZero[i+1] = parent[i];
        }

        for (int i = 0; i < n+1; i++)
            createNode(parentWithRootZero, i, created);

        return root;
    }

    //For adding new line in a program
    void newLine()
    {
        System.out.println("");
    }

    // Utility function to do inorder traversal
    void inorder(Node node) {
        if (node != null){
            inorder(node.left);
            inOrderList.add(node.key);
            inorder(node.right);
        }
    }

    void postOrder(Node node) {
        if (node != null){
            postOrder(node.left);
            postOrder(node.right);
            postOrderList.add(node.key);
        }
    }

    void preOrder(Node node) {
        if (node != null) {
            preOrderList.add(node.key);
            preOrder(node.left);
            preOrder(node.right);
        }
    }
}

    static ArrayList<Integer> preOrderList , postOrderList ,inOrderList;

    public static void main(String[] args) throws IOException {
        BinaryTree tree = new BinaryTree();
        String line;
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        line = inp.readLine();
        int n  = Integer.parseInt(line.trim().split("\\s+")[0]);
        int[] parent = new int[n];

        for(int j =0; j< n; j++){
            line = inp.readLine();
            String[] strs = line.trim().split("\\s+");
            parent[j] = Integer.parseInt(strs[0]);
        }

        preOrderList = new ArrayList<>();
        postOrderList = new ArrayList<>();
        inOrderList = new ArrayList<>();
        Node node = tree.createTree(parent, n);
        tree.preOrder(node);
        tree.inorder(node);
        tree.postOrder(node);

        int res =0;
        for(int i=0; i< n+1; i++){
            res += getMedian(preOrderList.get(i),inOrderList.get(i),postOrderList.get(i));
        }
        System.out.println(res);
    }

    private static int getMedian(Integer integer1, Integer integer2, Integer integer3) {
       int[] arr = {integer1, integer2, integer3};
        Arrays.sort(arr);
        return arr[1];
    }


}