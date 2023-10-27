package th4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class AStarSearch implements IInformedSearchAlgo {

	@Override
	public Node execute(Node root, String goal) {

		PriorityQueue<Node> frontier = new PriorityQueue<Node>(new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				Double h1 = o1.getH();
				Double h2 = o2.getH();
				int result = h1.compareTo(h2);
				if (result == 0)
					return o1.getLabel().compareTo(o2.getLabel());
				else
					return result;
			}

		});

		if (root.getLabel().equals(goal))
			return root;
		List<Node> explored = new ArrayList<>();
		frontier.add(root);
		while (!frontier.isEmpty()) {
			Node currentNode = frontier.poll();
			if (currentNode.getLabel().equals(goal))
				return currentNode;
			explored.add(currentNode);
			List<Node> children = currentNode.getChildrenNodes();
			for (Node child : children) {
				
				if (!frontier.contains(child) && !explored.contains(child)) {
					for (Edge edge : currentNode.getChildren()) {
						if (edge.getEnd().equals(child)) {
							child.setH(edge.getWeight() + currentNode.getH());
							break;
						}
					}
					child.setParent(currentNode);
					frontier.add(child);
				} else {
					double newChildPathCost = 0;
					for (Edge edge : currentNode.getChildren()) {
						if (edge.getEnd().equals(child)) {
							newChildPathCost = edge.getWeight() + currentNode.getH();
						}
					}
					for (Node frnode : frontier) {
						if (frnode.equals(child)) {
							if (frnode.getH() > newChildPathCost) {
								frontier.remove(frnode);
								child.setH(newChildPathCost);
								child.setParent(currentNode);
								frontier.add(child);
								break;
							}
						}
					}
				}
			}
		}
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		// TODO Auto-generated method stub
		return null;
	}

}
