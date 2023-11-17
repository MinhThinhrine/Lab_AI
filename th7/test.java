package th7;

public class test {
	    public static void main(String[] args) {
	        GA_NQueenAlgo ga = new GA_NQueenAlgo();

	        // Thực hiện thuật toán di truyền để tìm giải pháp tốt nhất
	        Node bestSolution = ga.execute();

	        // In ra giải pháp tốt nhất tìm được
	        System.out.println("Best Solution: " + bestSolution.toString());
	    }
	
}
