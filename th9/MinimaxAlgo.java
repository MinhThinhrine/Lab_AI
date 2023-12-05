package th9;

import java.util.List;

public class MinimaxAlgo {
	public void execute(Node node) {
		Node v = new Node();
		maxValue(node);
		System.out.println(v);
	}

	public int maxValue(Node node) {
		if (node.isTerminal()) {
			return evaluateUtility(node);
		}

		int v = Integer.MIN_VALUE;
		List<Node> successors = node.getSuccessors();
		for (Node s : successors) {
			v = Math.max(v, minValue(s));
		}
		return v;
	}

	public int minValue(Node node) {
		if (node.isTerminal()) {
			return evaluateUtility(node);
		}

		int v = Integer.MAX_VALUE;
		List<Node> successors = node.getSuccessors();
		for (Node s : successors) {
			v = Math.min(v, maxValue(s));
		}
		return v;
	}

	private int evaluateUtility(Node node) {
		List<Integer> data = node.getData();
		int max = data.get(0);
		int min = data.get(data.size() - 1);
		return max - min;
	}
}