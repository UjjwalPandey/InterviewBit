/*
Check whether the graph is bipartite or not

Problem Description

Given a undirected graph having A nodes. A matrix B of size M x 2 is given which represents the edges such that there is an edge between B[i][0] and B[i][1].

Find whether the given graph is bipartite or not.

A graph is bipartite if we can split it's set of nodes into two independent subsets A and B such that every edge in the graph has one node in A and another node in B

Note:

There are no self-loops in the graph.

No multiple edges between two pair of vertices.

The graph may or may not be connected.

Nodes are Numbered from 0 to A-1.

Your solution will run on multiple test cases. If you are using global variables make sure to clear them.



Problem Constraints

1 <= A <= 100000

1 <= M <= min(A*(A-1)/2,200000)

0 <= B[i][0],B[i][1] < A



Input Format

The first argument given is an integer A.

The second argument given is the matrix B.



Output Format

Return 1 if the given graph is bipartite else return 0.


Example Input

Input 1:

A = 2
B = [ [0, 1] ]

Input 2:

A = 3
B = [ [0, 1], [0, 2], [1, 2] ]



Example Output

Output 1:

1

Output 2:

0



Example Explanation

Explanation 1:

Put 0 and 1 into 2 different subsets.

Explanation 2:


It is impossible to break the graph down to make two different subsets for bipartite matching

 */
package GraphDataStructureAlgorithms;

import java.util.*;

public class CheckWhetherTheGraphIsBipartiteOrNot {
    public static void main(String[] args) {
        int A = 3;
        int[][] B = {{0, 1}, {0, 2}, {1, 2}};
        System.out.println(solve(A, B));
        System.out.println(solve(2, new int[][]{{0,1}}));
    }

    enum Color{
        WHITE, RED, GREEN
    }

    static class Graph {
        int vertices;
        LinkedList<Integer>[] adjList;

        public Graph(int vertices) {
            this.vertices = vertices;

            adjList = new LinkedList[vertices];
            for (int i = 0; i < vertices; i++) {
                adjList[i] = new LinkedList<>();
            }
        }

        public void addEdge(int source, int destination) {
            adjList[source].addFirst(destination);
            adjList[destination].addFirst(source);
        }

        public boolean isBipartite(Graph graph) {
            if (graph.vertices == 0)
                return true;
            Color[] colors = new Color[vertices];
            Arrays.fill(colors, Color.WHITE);
            Queue<Integer> queue = new LinkedList<>();
            for (int source = 0; source < vertices; source++) {
                if (colors[source] == Color.WHITE) {
                    colors[source] = Color.RED;
                    queue.add(source);
                    while (!queue.isEmpty()) {
                        int v = queue.remove();
                        for (int i = 0; i < adjList[v].size(); i++) {
                            int dest = adjList[v].get(i);
                            if (colors[dest] == Color.WHITE) {
                                if (colors[v] == Color.RED) {
                                    colors[dest] = Color.GREEN;
                                } else if (colors[v] == Color.GREEN) {
                                    colors[dest] = Color.RED;
                                }
                                queue.add(dest);
                            } else if (colors[v] == colors[dest]) {
                                return false;
                            }
                        }
                    }
                }
            }
            return true;
        }
    }
    public static int solve(int A, int[][] B) {
        Graph graph = new Graph(A);
        for(int[] arr: B){
            graph.addEdge(arr[0],arr[1]);
        }
        return graph.isBipartite(graph)?1:0;
    }
}
