package th8;

public class MiniMaxSearchAlgo implements ISearchAlgo {

	// function MINIMAX-DECISION(state) returns an action
	// inputs: state, current state in game
	// v <- MAX-VALUE(state)
	// return the action in SUCCESSORS(state) with value v
	@Override
	public void execute(Node node) {
		// Enter your code here
		int bestValue = maxValue(node);
		Node bestChild = findChildWithBestValue(node, bestValue);
		if (bestChild != null) {
			System.out.println("Best action: " + bestChild.getLabel() );
		} else {
			System.out.println("No best action found.");
		}
	}

	private Node findChildWithBestValue(Node node, int value) {
		for (Node child : node.getChildren()) {
			if (child.getValue() == value) {
				return child;
			}
		}
		return null;
	}
	// function MAX-VALUE(state) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- Integer.MIN_VALUE
	// for each s in SUCCESSORS(state) do
	// v <- MAX(v, MIN-VALUE(s))
	// return v

	private int maxValue(Node node) {
		if (node.isTerminal()) {
			return node.getValue();
		}
		int bestValue = Integer.MIN_VALUE;
		for (Node child : node.getChildren()) {
			int value = minValue(child);
			bestValue = Math.max(bestValue, value);
		}
		return bestValue;
	}
	// function MIN-VALUE(state) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- Integer.MAX_VALUE
	// for each s in SUCCESSORS(state) do
	// v <- MIN(v, MAX-VALUE(s))
	// return v

	private int minValue(Node node) {
		if (node.isTerminal()) {
			return node.getValue();
		}
		int bestValue = Integer.MAX_VALUE;
		for (Node child : node.getChildren()) {
			int value = maxValue(child);
			bestValue = Math.min(bestValue, value);
		}
		return bestValue;
	}

}
