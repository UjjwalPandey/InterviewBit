/*  Shortest Unique Prefix

    Problem Description
        Given a list of N words. Find shortest unique prefix to represent each word in the list.

    NOTE: Assume that no word is prefix of another. In other words, the representation is always possible



    Problem Constraints

    1 <= Sum of length of all words <= 106


    Input Format

    First and only argument is a string array of size N.


    Output Format

    Return a string array B where B[i] denotes the shortest unique prefix to represent the ith word.


    Example Input

    Input 1:

     A = ["zebra", "dog", "duck", "dove"]

    Input 2:

    A = ["apple", "ball", "cat"]



    Example Output

    Output 1:

     ["z", "dog", "du", "dov"]

    Output 2:

     ["a", "b", "c"]



    Example Explanation

    Explanation 1:

     Shortest unique prefix of each word is:
     For word "zebra", we can only use "z" as "z" is not any prefix of any other word given.
     For word "dog", we have to use "dog" as "d" and "do" are prefixes of "dov".
     For word "du", we have to use "du" as "d" is prefix of "dov" and "dog".
     For word "dov", we have to use "dov" as "d" and do" are prefixes of "dog".


    Explanation 2:

     "a", "b" and c" are not prefixes of any other word. So, we can use of first letter of each to represent.

 */
package Tree.Trie;

import java.util.ArrayList;
import java.util.HashMap;

public class ShortestUniquePrefix {
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
    public static ArrayList<String> prefix(ArrayList<String> A) {
        ArrayList<String> result = new ArrayList<>();
        root = new TrieNode(' ');
        for(String str: A){
            insertTrie(root, str);
        }
        printTrie(root);
        for(String str: A){
            result.add(getPrefix(root, str));
        }
        return result;
    }

    private static String getPrefix(TrieNode root, String str) {
        TrieNode temp = root.children.get(str.charAt(0));
        int counter = 1;
        int len = str.length();
        StringBuilder resBuilder = new StringBuilder(String.valueOf(str.charAt(0)));
        while (counter < len && temp.frequency != 1){
            resBuilder.append(str.charAt(counter));
            temp = temp.children.get(str.charAt(counter++));
        }

        return resBuilder.toString();
    }

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

    public static void main(String[] args) {
        ArrayList<String> A = new ArrayList<>();
        A.add("zebra");
        A.add("dog");
        A.add("dogs");
        A.add("duck");
        A.add("dove");
        A.add("bearcat");
        A.add("bert");
        System.out.println(prefix(A));
    }
}
