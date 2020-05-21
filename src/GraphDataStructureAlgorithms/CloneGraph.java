/*
    Clone Graph

Problem Description

Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.


Problem Constraints

1 <= Number of nodes <= 105


Input Format

First and only argument is a node A denoting the root of the undirected graph.


Output Format

Return the node denoting the root of the new clone graph.


Example Input

Input 1:

      1
    / | \
   3  2  4
        / \
       5   6

Input 2:

      1
     / \
    3   4
   /   /|\
  2   5 7 6



Example Output

Output 1:

 Output will the same graph but with new pointers:
      1
    / | \
   3  2  4
        / \
       5   6

Output 2:

      1
     / \
    3   4
   /   /|\
  2   5 7 6



Example Explanation

Explanation 1:

 We need to return the same graph, but the pointers to the node should be different.
 */
package GraphDataStructureAlgorithms;

import java.util.*;

public class CloneGraph {
    static class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;
        UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<>(); }
    }

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode source) {
        Queue<UndirectedGraphNode> q = new LinkedList<>();
        q.add(source);
        HashMap<UndirectedGraphNode,UndirectedGraphNode> hm = new HashMap<>();
        hm.put(source,new UndirectedGraphNode(source.label));
        while (!q.isEmpty()) {
            UndirectedGraphNode u = q.poll();
            UndirectedGraphNode cloneNodeU = hm.get(u);
            if (u.neighbors != null) {
                List<UndirectedGraphNode> v = u.neighbors;
                for (UndirectedGraphNode node : v) {
                    UndirectedGraphNode cloneNodeG = hm.get(node);
                    if (cloneNodeG == null) {
                        q.add(node);
                        cloneNodeG = new UndirectedGraphNode(node.label);
                        hm.put(node,cloneNodeG);
                    }
                    cloneNodeU.neighbors.add(cloneNodeG);
                }
            }
        }
        return hm.get(source);
    }

}
