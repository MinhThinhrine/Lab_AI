package th9;

import java.util.Arrays;
import java.util.List;

public class TestNode {
	public static void main(String[] args) {
		Node node = new Node();
		Integer[] data = {7};
		node.addAll(Arrays.asList(data));
System.out.println(node.getSuccessors());
		MinimaxAlgo algo = new MinimaxAlgo();
		algo.execute(node);
	}
}