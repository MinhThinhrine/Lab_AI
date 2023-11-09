package th5;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class GreedyBestFirstSearchAlgo implements IPuzzleAlgo {

	@Override
	// with h2
	public Node execute(Puzzle model) {
		// TODO Auto-generated method stub
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(PuzzleUtils.HeuristicComparatorByH);
		List<Node> explored = new LinkedList<>();
		model.getInitialState().setH(model.computeH2(model.getInitialState()));
		frontier.add(model.getInitialState());
		Node goal = model.getGoalState();
		while (!frontier.isEmpty()) {
			Node currentNode = frontier.poll();
			if (currentNode.equals(goal))
				return currentNode;
			explored.add(currentNode);

			List<Node> children = model.getSuccessors(currentNode);
			for (Node n : children) {
				if (!frontier.contains(n) && !explored.contains(n)) {
					n.setG(currentNode.getG() + 1);
					frontier.add(n);
				}
			}
		}
		return null;
	}

}
