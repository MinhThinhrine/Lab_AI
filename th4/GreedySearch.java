package th4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import javax.swing.text.AsyncBoxView.ChildLocator;

public class GreedySearch implements IInformedSearchAlgo{

	@Override
	public Node execute(Node root, String goal) {

			PriorityQueue<Node> frontier = new PriorityQueue<Node>(new Comparator<Node>() {

				@Override
				public int compare(Node o1, Node o2) {
					// TODO Auto-generated method stub
					return (int) (o1.getH()-o2.getH());
				}
				
			});
			
			if (root.getLabel().equals(goal)) return root;
			List<Node> explored = new ArrayList<>();
			frontier.add(root);
			while (!frontier.isEmpty()) {
				Node currentNode = frontier.poll();
				if(currentNode.getLabel().equals(goal)) return currentNode;
				explored.add(currentNode);
				List<Edge> children = currentNode.getChildren();
				for (Edge e : children) {
					Node child = e.getEnd();
					if (!frontier.contains(child) && !explored.contains(child)) { 
						child.setG(currentNode.getG()+e.getWeight());
						frontier.add(child);
						child.setParent(currentNode);
						break;
				}else {
					double newChildPathCost = 0;
					newChildPathCost = e.getWeight() + currentNode.getH();
					if(frontier.contains(child) && child.getG()>newChildPathCost) {
						frontier.remove(child);
						child.setG(newChildPathCost);
						child.setParent(currentNode);
						frontier.add(child);
						break;
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
