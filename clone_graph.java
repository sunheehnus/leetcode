/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
import java.util.TreeMap;
import java.util.List;
import java.util.ArrayList;
public class Solution {
	public UndirectedGraphNode DFS_Clone(UndirectedGraphNode node, TreeMap<Integer, UndirectedGraphNode> graph) {
		UndirectedGraphNode newnode = new UndirectedGraphNode(node.label);
		graph.put(newnode.label, newnode);
		for (UndirectedGraphNode neighbor: node.neighbors) {
			UndirectedGraphNode dummy_neighbor = graph.get(neighbor.label);
			if (dummy_neighbor == null)
				newnode.neighbors.add(DFS_Clone(neighbor, graph));
			else
				newnode.neighbors.add(dummy_neighbor);
		}
		return newnode;
	}
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null)
			return null;
		TreeMap<Integer, UndirectedGraphNode> graph = new TreeMap<Integer, UndirectedGraphNode>();
		return DFS_Clone(node, graph);
	}
}
