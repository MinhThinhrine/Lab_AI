package th2;

public class Test {
	public static void main(String[] args) {
		
	Node nodeS = new Node("S"); 
	Node nodeA = new Node("A"); 
	Node nodeB = new Node("B"); 
	Node nodeC = new Node("C");
	Node nodeD = new Node("D"); 
	Node nodeE = new Node("E"); 
	Node nodeF = new Node("F"); 
	Node nodeG = new Node("G"); 
	Node nodeH = new Node("H"); 
	
	nodeS.addEdge(nodeA, 5); 
	nodeS.addEdge(nodeB, 2); 
	nodeS.addEdge(nodeC, 4); 
	nodeA.addEdge(nodeE, 4); 
	nodeA.addEdge(nodeD, 9); 
	nodeB.addEdge(nodeG, 6); 
	nodeC.addEdge(nodeF, 2); 
	nodeD.addEdge(nodeH, 7); 
	nodeE.addEdge(nodeG, 6); 
	nodeF.addEdge(nodeG, 1); 
//	nodeS.setParent(null); // Start node has no parent
//	nodeA.setParent(nodeS); // Parent of nodeA is nodeS
//	nodeB.setParent(nodeS); // Parent of nodeB is nodeS
//	nodeC.setParent(nodeS); // Parent of nodeC is nodeS
//	nodeD.setParent(nodeA); // Parent of nodeD is nodeA
//	nodeE.setParent(nodeA); // Parent of nodeE is nodeA
//	nodeF.setParent(nodeC); // Parent of nodeF is nodeC
//	nodeG.setParent(nodeE); // Parent of nodeG is nodeE
//	nodeG.setParent(nodeB); // Parent of nodeG is nodeB
//	nodeF.setParent(nodeC); //parent of nodeF is nodeC
//	nodeG.setParent(nodeF);// Parent of nodeG is nodeF
//	nodeH.setParent(nodeD); // Parent of nodeH is nodeD
	ISearchAlgo algo1 = new BreadthFirstSearchAlgo(); 
	ISearchAlgo algo2 = new DepthFirstSearchAlgo();
	NodeUtils nd = new NodeUtils();
	Node result1 = algo1.execute(nodeS, "G");
	System.out.println(nd.printPath(result1	));

//	Node result2 = algo2.execute(nodeS, "G");
//	System.out.println(nd.printPath(result2	));

	}
}
