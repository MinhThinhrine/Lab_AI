package th8;

public class Test {
	    public static void main(String[] args) {
	        // Construct the game tree
	        Node root = new Node("A");
	        Node nodeB = new Node("B");
	        Node nodeC = new Node("C");
	        Node nodeD = new Node("D");
	        Node nodeE = new Node("E");
	        Node nodeF = new Node("F");
	        Node nodeG = new Node("G", 3);
	        Node nodeH = new Node("H", 6);
	        Node nodeI = new Node("I", 2);

	        root.addChild(nodeB);
	        root.addChild(nodeC);
	        nodeB.addChild(nodeD);
	        nodeB.addChild(nodeE);
	        nodeC.addChild(nodeF);
	        nodeC.addChild(nodeG);
	        nodeD.addChild(nodeH);
	        nodeD.addChild(nodeI);

	        // Create the MiniMax search algorithm instance
	        MiniMaxSearchAlgo miniMaxSearch = new MiniMaxSearchAlgo();
	        AlphaBetaSearchAlgo al = new AlphaBetaSearchAlgo();
	        // Execute the MiniMax search algorithm
	        miniMaxSearch.execute(root);
	        al.execute(root);
	    }
	
}
