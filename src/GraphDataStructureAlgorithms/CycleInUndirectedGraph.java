/*

Cycle in Undirected Graph

Problem Description

Given an undirected graph having A nodes labelled from 1 to A with M edges given in a form of matrix B of size M x 2 where (B[i][0], B[i][1])
represents two nodes B[i][0] and B[i][1] connected by an edge.

Find whether the graph contains a cycle or not, return 1 if cycle is present else return 0.

NOTE:

    The cycle must contain atleast three nodes.
    There are no self-loops in the graph.
    There are no multiple edges between two nodes.
    The graph may or may not be connected.
    Nodes are numbered from 1 to A.
    Your solution will run on multiple test cases. If you are using global variables make sure to clear them.



Problem Constraints

1 <= A, M <= 3105

1 <= B[i][0], B[i][1] <= A



Input Format

The first argument given is an integer A representing the number of nodes in the graph.

The second argument given is an matrix B of size M x 2 which represents the M edges such that there is a edge between node B[i][0] and node B[i][1].



Output Format

Return 1 if cycle is present else return 0.


Example Input

Input 1:

 A = 5
 B = [  [1. 2]
        [1, 3]
        [2, 3]
        [1, 4]
        [4, 5]
     ]

Input 2:

 A = 3
 B = [  [1. 2]
        [1, 3]
     ]



Example Output

Output 1:

 1

Output 2:

 0



Example Explanation*

Explanation 1:

 There is a cycle in the graph i.e 1 -> 2 -> 3 -> 1 so we will return 1

Explanation 2:

 No cycle present in the graph so we will return 0.

 */
package GraphDataStructureAlgorithms;

import java.util.ArrayList;
import java.util.HashMap;

public class CycleInUndirectedGraph {
    public static void main(String[] args) {
        int A = 5;
        int[][] B = {  {1, 2},
                {4, 1},
                {2, 4},
                {3, 4},
                {5, 2},
                {1, 3} };
        System.out.println(solve(A, B));
        int C = 5;
        int[][] D = {  {1, 2},
                {2, 3},
                {3, 4},
                {4, 5} };
        System.out.println(solve(C, D));
        int E = 5;
        int[][] F = {  {1, 2},
                {1, 3},
                {2, 3},
                {1, 4},
                {4, 3},
                {4, 5},
                {3, 5} };
        System.out.println(solve(E, F));
    }

    static boolean[] visited;
    public static int solve(int A, int[][] B) {
        HashMap<Integer, ArrayList<Integer>> adjacencyMap = new HashMap<>();
        for (int[] ints : B) {
            ArrayList<Integer> tuple = adjacencyMap.getOrDefault(ints[0], new ArrayList<>());
            tuple.add(ints[1]);
            adjacencyMap.put(ints[0], tuple);
            tuple = adjacencyMap.getOrDefault(ints[1], new ArrayList<>());
            tuple.add(ints[0]);
            adjacencyMap.put(ints[1], tuple);
        }
        for(int i=1; i<= A; i++){
            visited = new boolean[A+1];
            int isCycle = dfs(adjacencyMap, i , -1);
            if(isCycle == 1) return 1;
        }
        return 0;
    }

    private static int dfs(HashMap<Integer, ArrayList<Integer>> adjacencyMap, int x, int parent) {
        if(visited[x]) return 1;
        visited[x] = true;
        ArrayList<Integer> neighbours = adjacencyMap.get(x);
        if(neighbours == null){
            visited[x] = false;
            return 0;
        }
        for(int i: neighbours){
            if(i== parent) continue;
            int isCycle= dfs(adjacencyMap, i, x);
            if(isCycle == 1) return 1;
        }
        visited[x] = false;
        return 0;
    }
}
