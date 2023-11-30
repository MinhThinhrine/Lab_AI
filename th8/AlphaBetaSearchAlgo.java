package th8;

import java.util.List;

public class AlphaBetaSearchAlgo implements ISearchAlgo {

	// function ALPHA-BETA-SEARCH(state) returns an action
	// inputs: state, current state in game
	// v <- MAX-VALUE(state, Integer.MIN_VALUE , Integer.MAX_VALUE)
	// return the action in SUCCESSORS(state) with value v
	@Override
	public void execute(Node node) {
		int alpha = Integer.MIN_VALUE;
		int beta = Integer.MAX_VALUE;
		int bestValue = maxValue(node, alpha, beta);
		List<Node> successors = node.getChildren();

		// Find the successor with the best value
		Node bestSuccessor = null;
		for (Node successor : successors) {
			if (successor.getValue() == bestValue) {
				bestSuccessor = successor;
				break;
			}
		}

		if (bestSuccessor != null) {
			// Perform the action associated with the best successor
			System.out.println("Best action: " + bestSuccessor.getLabel());
		}
	}

	// function MAX-VALUE(state, alpha, beta) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- MIN_VALUE;
	// for each s in SUCCESSORS(state) do
	// v <- MAX(v, MIN-VALUE(s, alpha, beta))
	// if v >= beta then return v
	// alpha <- MAX(alpha, v)
	// return v

	public int maxValue(Node node, int alpha, int beta) {
		if (node.isTerminal()) {
			return node.getValue();
		}

		int v = Integer.MIN_VALUE;
		List<Node> successors = node.getChildren();
		for (Node successor : successors) {
			v = Math.max(v, minValue(successor, alpha, beta));
			if (v >= beta) {
				return v;
			}
			alpha = Math.max(alpha, v);
		}
		return v;
	}

	// function MIN-VALUE(state, alpha , beta) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- Integer.MAX_VALUE
	// for each s in SUCCESSORS(state) do
	// v <- MIN(v, MAX-VALUE(s, alpha , beta))
	// if v <= alpha then return v
	// beta <- MIN(beta ,v)
	// return v

	public int minValue(Node node, int alpha, int beta) {
		if (node.isTerminal()) {
			return node.getValue();
		}

		int v = Integer.MAX_VALUE;
		List<Node> successors = node.getChildren();
		for (Node successor : successors) {
			v = Math.min(v, maxValue(successor, alpha, beta));
			if (v <= alpha) {
				return v;
			}
			beta = Math.min(beta, v);
		}
		return v;
	}
}
