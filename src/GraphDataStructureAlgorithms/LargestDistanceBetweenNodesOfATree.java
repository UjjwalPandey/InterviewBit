/*
    Largest Distance between nodes of a Tree

Problem Description

Find largest distance Given an arbitrary unweighted rooted tree which consists of N (2 <= N <= 40000) nodes.

The goal of the problem is to find largest distance between two nodes in a tree. Distance between two nodes is a number of edges on a path between the nodes (there will be a unique path between any pair of nodes since it is a tree).

The nodes will be numbered 0 through N - 1.

The tree is given as an array A, there is an edge between nodes A[i] and i (0 <= i < N). Exactly one of the i's will have A[i] equal to -1, it will be root node.



Problem Constraints

2 <= |A| <= 40000


Input Format

First and only argument is vector A


Output Format

Return the length of the longest path


Example Input

Input 1:


A = [-1, 0]

Input 2:


A = [-1, 0, 0]



Example Output

Output 1:

 1

Output 2:

 2



Example Explanation

Explanation 1:

 Path is 0 -> 1.

Explanation 2:

 Path is 1 -> 0 -> 2.

 */
package GraphDataStructureAlgorithms;

import java.util.*;

public class LargestDistanceBetweenNodesOfATree {
    static boolean[] visited;
    static HashMap<Integer, ArrayList<Integer>> hm;
    static ArrayList<Integer> farthestLeaf ;
    static int farthestLeafLevel;

    public static int solve(int[] A) {
        hm = new HashMap<>();
        int root = 0;
        for(int i=0; i < A.length; i++){
            if(A[i] == -1){
                root = i;
            }else {
                ArrayList<Integer> arr = hm.getOrDefault(A[i], new ArrayList<>());
                arr.add(i);
                hm.put(A[i], arr);

                arr = hm.getOrDefault(i, new ArrayList<>());
                arr.add(A[i]);
                hm.put(i, arr);
            }
        }
        if(hm.size() == 0) return 0;
        farthestLeaf = new ArrayList<>();
        farthestLeafLevel = 0;
        visited = new boolean[A.length + 1];
        getFarthestLeaves(root, 0);
        visited = new boolean[A.length + 1];

        int res =0;
        for (int x: farthestLeaf) {
            visited = new boolean[A.length + 1];
            res = Math.max(res, dfs(x, 0));
        }
        return res;
    }

    private static void getFarthestLeaves(int root, int level) {
        visited[root] = true;
        boolean isLeaf = true;
        ArrayList<Integer> vals = hm.get(root);
        if(vals == null) return;
        for(int x: vals) {
            if (!visited[x]) {
                getFarthestLeaves(x, level+1);
                isLeaf =  false;
            }
        }
        if(isLeaf){
            if(farthestLeafLevel < level){
                farthestLeafLevel = level;
                farthestLeaf = new ArrayList<>();
                farthestLeaf.add(root);
            }else if(farthestLeafLevel == level){
                farthestLeaf.add(root);
            }
        }
    }

    private static int dfs(Integer key, int level) {
        int res = level;
        visited[key] = true;
        for(int x: hm.get(key)) {
            if (!visited[x])
                res = Math.max(res,dfs(x, level+1));
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(solve(new int[]{-1,0})); // 1
        System.out.println(solve(new int[]{-1, 0, 0, 0, 3 })); // 3
        System.out.println(solve(new int[]{-1,0,0}));  // 2
        System.out.println(solve(new int[]{-1}));  // 0
        System.out.println(solve(new int[]{-1, 0, 0, 1, 2, 1, 5}));  // 5
        System.out.println(solve(new int[]{ -1, 0, 1, 2, 0, 4, 4, 6, 1, 5, 6, 0, 2, 4, 0, 7, 2, 8, 13, 8, 7, 20, 3, 22, 16, 1, 7, 26, 23, 7, 27, 7, 11, 28, 30, 34, 9, 14, 16, 1, 36, 13, 0, 20, 37, 5, 44, 34, 25, 27, 13, 19, 26, 46, 43, 26, 53, 16, 40, 40, 11, 25, 61, 60, 63, 16, 50, 5, 11, 20, 10, 10, 40, 70, 43, 21, 70, 62, 54, 12, 33, 14, 67, 28, 45, 30, 13, 55, 78, 41, 22, 43, 66, 42, 27, 86, 67, 57, 51, 87}));  // 16
        System.out.println(solve(new int[]{-1, 0, 0, 2, 3, 0, 1, 0, 0, 6, 9, 3, 3, 0, 3, 13, 7, 5, 13, 5, 14, 13, 10, 15, 6, 23, 11, 19, 23, 9, 17, 16, 27, 12, 23, 6, 16, 23, 2, 19, 28, 15, 36, 41, 32, 4, 3, 45, 34, 42, 12, 4, 32, 20, 35, 8, 41, 7, 37, 44, 18, 10, 42, 29, 1, 54, 58, 21, 63, 53, 45, 26, 59, 4, 3, 41, 48, 53, 11, 59, 78, 46, 54, 75, 82, 82, 71, 49, 4, 70, 61, 52, 7, 28, 57, 52, 23, 30, 2, 5 }));  // 13
    }
}
