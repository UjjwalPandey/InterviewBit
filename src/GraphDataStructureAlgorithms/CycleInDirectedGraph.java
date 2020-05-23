/*
Cycle in Directed Graph

Problem Description

Given an directed graph having A nodes. A matrix B of size M x 2 is given which represents the M edges such that there is a edge directed from node B{i},{0}, to node B{i},{1},.

Find whether the graph contains a cycle or not, return 1 if cycle is present else return 0.

NOTE:

    The cycle must contain atleast two nodes.
    There are no self-loops in the graph.
    There are no multiple edges between two nodes.
    The graph may or may not be connected.
    Nodes are numbered from 1 to A.
    Your solution will run on multiple test cases. If you are using global variables make sure to clear them.



Problem Constraints

2 <= A <= 105

1 <= M <= min(200000,A*(A-1))

1 <= B{i},{0},, B{i},{1}, <= A



Input Format

The first argument given is an integer A representing the number of nodes in the graph.

The second argument given a matrix B of size M x 2 which represents the M edges such that there is a edge directed from node B{i},{0}, to node B{i},{1},.



Output Format

Return 1 if cycle is present else return 0.


Example Input

Input 1:

 A = 5
 B = {  {1, 2},
        {4, 1},
        {2, 4},
        {3, 4},
        {5, 2},
        {1, 3}, },

Input 2:

 A = 5
 B = {  {1, 2},
        {2, 3},
        {3, 4},
        {4, 5}, },



Example Output

Output 1:

 1

Output 2:

 0



Example Explanation

Explanation 1:

 The given graph contain cycle 1 -> 3 -> 4 -> 1 or the cycle 1 -> 2 -> 4 -> 1

Explanation 2:

 The given graph doesn't contain any cycle.

 */

/*  Refer Concepts.txt
### CYCLE IN A GRAPH:
        There is a cycle in the graph if and only if there is a BACK-EDGE in the graph.
        BACK_EDGE is an edge that is from a node to itself OR a node to any of its ancestors.
        * To find ancestor we will implement DFS
*/
package GraphDataStructureAlgorithms;

import java.util.ArrayList;
import java.util.HashMap;

public class CycleInDirectedGraph {
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
        }
        for(int i=1; i<= A; i++){
            visited = new boolean[A+1];
            int isCycle = dfs(adjacencyMap, i);
            if(isCycle == 1) return 1;
        }
        return 0;
    }

    private static int dfs(HashMap<Integer, ArrayList<Integer>> adjacencyMap, int x) {
        if(visited[x]) return 1;
        visited[x] = true;
        ArrayList<Integer> neighbours = adjacencyMap.get(x);
        if(neighbours == null){
            visited[x] = false;
            return 0;
        }
        for(int i: neighbours){
            int isCycle= dfs(adjacencyMap, i);
            if(isCycle == 1) return 1;
        }
        visited[x] = false;
        return 0;
    }
}
