/*  Problem Description

Given an array of integers A, find and return the maximum result of A[i] XOR A[j], where i, j are the indexes of the array.


Problem Constraints

1 <= length of the array <= 100000
0 <= A[i] <= 109


Input Format

The only argument given is the integer array A.


Output Format

Return an integer denoting the maximum result of A[i] XOR A[j].


Example Input

Input 1:

 A = [1, 2, 3, 4, 5]

Input 2:

 A = [5, 17, 100, 11]



Example Output

Output 1:

 7

Output 2:

 117



Example Explanation

Explanation 1:

 Maximum XOR occurs between element of indicies(0-based) 1 and 4 i.e. 2 ^ 5 = 7.

Explanation 2:

 Maximum XOR occurs between element of indicies(0-based) 1 and 2 i.e. 17  ^ 100 = 117

 */
package Tree.Trie;

import java.util.HashMap;

public class MaximumXOR {
    static class TrieNode {
        char val;
        boolean eow;
        int frequency;
        HashMap<Character, TrieNode> children;
        TrieNode(char x) {
            val = x;
            eow = false;
            children = new HashMap<>();
            frequency = 0;
        }
    }
    static TrieNode root;
    private static void insertTrie(TrieNode root, String str) {
        root.frequency++;
        if(str.length()==0){
            root.eow = true;
            return;
        }
        if(root.children.containsKey(str.charAt(0))){
            insertTrie(root.children.get(str.charAt(0)), str.substring(1));
        }else {
            TrieNode newChild = new TrieNode(str.charAt(0));
            root.children.put(str.charAt(0),newChild);
            insertTrie(newChild, str.substring(1));
        }
    }

    private static void printTrie(TrieNode node){
        if(node == null){
            return;
        }
        if(node.eow){
            System.out.print(node.val + "( "+node.frequency+" )  |-**-|  ");
        }else {
            System.out.print(node.val + "( "+node.frequency+" )  ->  ");
        }
        System.out.println("\n"+node.val+" ::: "+node.children.keySet());
        for(char ch: node.children.keySet()){
            System.out.println();
            printTrie(node.children.get(ch));
            System.out.println();
        }
    }


    public static int solve(int[] A) {
        if(A.length == 0) return 0;
        root = new TrieNode(' ');
        for(int value: A){
            insertTrie(root, String.format("%32s", Integer.toBinaryString(value)).replace(' ', '0'));
        }
//        printTrie(root);
        int max = Integer.MIN_VALUE;
        for(int i: A) {
            max = Math.max(max, getMaxComplimentaryNumber(root,i));
        }
        return max;
    }

    private static int getMaxComplimentaryNumber(TrieNode node, int N) {
        String ip = String.format("%32s", Integer.toBinaryString(N)).replace(' ', '0');
        StringBuilder str = new StringBuilder();
        TrieNode temp = node;
        for(char ch: ip.toCharArray()){
            char oppo = (ch == '0')?'1':'0';
            if(temp.children.containsKey(oppo)){
                str.append(oppo);
                temp = temp.children.get(oppo);
            }else{
                str.append(ch);
                temp = temp.children.get(ch);
            }
        }
        int maxXor = Integer.parseInt(str.toString(), 2);
        return N^maxXor;
    }

    public static void main(String[] args) {
//        System.out.println("RESULT:  "+solve(new int[]{8, 3, 10, 2, 6, 7, 6, 9, 3}));
        System.out.println("RESULT:  "+solve(new int[]{5, 17, 100, 11}));
        System.out.println("RESULT:  "+solve(new int[]{1,2,3,4,5}));
//        System.out.println("RESULT:  "+solve(new int[]{13, 13, 1, 5, 8, 10, 7, 3}));
    }
}
