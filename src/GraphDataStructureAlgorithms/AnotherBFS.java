/*
    Another BFS

Problem Description

Given a weighted undirected graph having A nodes, a source node C and destination node D.

Find the shortest distance from C to D and if it is impossible to reach node D from C then return -1.

You are expected to do it in Time Complexity of O(A + M).

Note:

There are no self-loops in the graph.

No multiple edges between two pair of vertices.

The graph may or may not be connected.

Nodes are Numbered from 0 to A-1.

Your solution will run on multiple testcases. If you are using global variables make sure to clear them.



Problem Constraints

1 <= A <= 105

0 <= B{i},{0},, B{i},{1}, < A

1 <= B{i},{2}, <= 2

0 <= C < A

0 <= D < A



Input Format

The first argument given is an integer A, representing the number of nodes.

The second argument given is the matrix B, where B{i},{0}, and B{i},{1}, are connected through an edge of weight B{i},{2},.

The third argument given is an integer C, representing the source node.

The fourth argument is an integer D, representing the destination node.

Note: B{i},{2}, will be either 1 or 2.



Output Format

Return the shortest distance from C to D. If it is impossible to reach node D from C then return -1.


Example Input

Input 1:


A = 6
B = {   {2, 5, 1},
        {1, 3, 1},
        {0, 5, 2},
        {0, 2, 2},
        {1, 4, 1},
        {0, 1, 1}, },
C = 3
D = 2

Input 2:

A = 2
B = {   {0, 1, 1},
    },
C = 0
D = 1



Example Output

Output 1:

 4

Output 2:

 1



Example Explanation

Explanation 1:

The path to be followed will be:
    3 -> 1 (Edge weight : 1)
    1 -> 0 (Edge weight : 1)
    0 -> 2 (Edge weight : 2)
Total length of path = 1 + 1 + 2 = 4.

Explanation 2:

 Path will be 0-> 1.

 */
package GraphDataStructureAlgorithms;

import java.util.*;

public class AnotherBFS {
    public static void main(String[] args) {
        int A = 6;
        int[][] B = {{2, 5, 1},
                    {1, 3, 1},
                    {0, 5, 2},
                    {0, 2, 2},
                    {1, 4, 1},
                    {0, 1, 1}};
        int C = 3;
        int D = 2;
        System.out.println(solve(A, B, C, D));  // 4
    }

    public static int solve(int A, int[][] B, int C, int D) {
        if(C==D) return 0;
        int totalNodes = A;
        // Creating a Graph through HashMap with intermittent nodes.
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
        for (int[] ints : B) {
            int prev = ints[0];
            int counter = ints[2];
            while (counter > 1) {
                totalNodes++;
                ArrayList<Integer> arr = hm.getOrDefault(prev, new ArrayList<>());
                arr.add(totalNodes);
                hm.put(prev, arr);
                arr = hm.getOrDefault(totalNodes, new ArrayList<>());
                arr.add(prev);
                hm.put(totalNodes, arr);
                prev = totalNodes;
                counter--;
            }
            ArrayList<Integer> arr = hm.getOrDefault(prev, new ArrayList<>());
            arr.add(ints[1]);
            hm.put(prev, arr);
            arr = hm.getOrDefault(ints[1], new ArrayList<>());
            arr.add(prev);
            hm.put(ints[1], arr);
        }

        // Implementing BFS to find level
        int[] visited = new int[totalNodes+1];
        Arrays.fill(visited, Integer.MAX_VALUE);
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(C,0));
        while (!q.isEmpty()){
            Node v = q.remove();
            if(v == null) continue;
            visited[v.getNumber()] = v.getLevel();
            ArrayList<Integer> arr = hm.get(v.getNumber());
            if(arr == null)continue;
            for (int x: arr){
                if(visited[x] == Integer.MAX_VALUE || visited[x] > visited[v.getNumber()]+1){
                    Node n1 = new Node(x, visited[v.getNumber()]+1);
                    q.add(n1);
                }
                visited[x]= Math.min(visited[x], v.getLevel()+1);
            }
        }

        return (visited[D]==Integer.MAX_VALUE)?-1:visited[D];
    }

    // Class Having Node level(min distance) and the corresponding edge weight.
    static class Node implements Comparable<Node>{
        int level, number;
        Node(int a, int b){
            number = a;
            level= b;
        }
        public int getNumber() {
            return number;
        }
        public int getLevel() {
            return level;
        }

        @Override
        public int compareTo(Node o) {
            return number - o.getNumber();
        }
    }
}
