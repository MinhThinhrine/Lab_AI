package th2;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

public class DepthFirstSearchAlgo implements ISearchAlgo {

	@Override
	public Node execute(Node startNode, String targetNodeName) {
	    Stack<Node> stack = new Stack<>();
	    Set<Node> visited = new HashSet<>();

	    stack.push(startNode);

	    while (!stack.isEmpty()) {
	        Node current = stack.pop();
	        if (current.getLabel().equals(targetNodeName)) {
	            return current;
	        }

	        visited.add(current);

	        // Sắp xếp các đỉnh kề theo thứ tự từ điển
	        Set<Edge> edges = new HashSet<>(current.getChildren());
	        Set<Edge> sortedEdges = sortEdges(edges);

	        for (Edge edge : sortedEdges) {
	            Node adjacent = edge.getEnd();
	            if (!visited.contains(adjacent)) {
	                stack.push(adjacent);
	            }
	        }
	    }

	    return null;
	}

	private Set<Edge> sortEdges(Set<Edge> edges) {
	    TreeSet<Edge> sortedEdges = new TreeSet<>((a, b) -> a.getEnd().getLabel().compareTo(b.getEnd().getLabel()));
	    sortedEdges.addAll(edges);
	    return sortedEdges;
	}


    public Node execute(Node root, String start, String goal) {
        Node startNode = findNode(root, start);

        if (startNode == null) {
            return null; // Start node not found
        }

        return execute(startNode, goal);
    }

    private Node findNode(Node root, String data) {
        if (root == null) {
            return null;
        }

        if (root.getLabel().equals(data)) {
            return root;
        }

        for (Edge edge : root.getChildren()) {
            Node adjacent = edge.getEnd();
            Node result = findNode(adjacent, data);
            if (result != null) {
                return result;
            }
        }

        return null;
    }
}