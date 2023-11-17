package th7;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GA_NQueenAlgo {
	public static final int POP_SIZE = 100; // Kích thước quần thể
	public static final double MUTATION_RATE = 0.03; // Tỷ lệ đột biến
	public static final int MAX_ITERATIONS = 1000; // Số lần lặp tối đa
	List<Node> population = new ArrayList<Node>();
	Random rd = new Random();

	// Khởi tạo quần thể bằng cách tạo ra các cá thể ban đầu
	public void initPopulation() {
		for (int i = 0; i < POP_SIZE; i++) {
			Node ni = new Node();
			ni.generateBoard();
			population.add(ni);
		}
	}

	public Node execute() {
		// Khởi tạo quần thể ban đầu
		initPopulation();

		int iterations = 0;
		Node bestSolution = null;

		while (iterations < MAX_ITERATIONS) {
			List<Node> newPopulation = new ArrayList<Node>();

			// Lặp qua từng cá thể trong quần thể hiện tại
			for (int i = 0; i < POP_SIZE; i++) {
				Node parent1 = getParentByTournamentSelection();
				Node parent2 = getParentByTournamentSelection();

				// Tạo ra con cái từ 2 cha mẹ
				Node child = reproduce(parent1, parent2);

				// Đột biến con cái
				mutate(child);

				newPopulation.add(child);
			}

			// Cập nhật quần thể mới
			population = newPopulation;

			// Tìm kiếm cá thể tốt nhất trong quần thể
			Node currentBest = findBestSolution();
			if (bestSolution == null || currentBest.getH() < bestSolution.getH()) {
				bestSolution = currentBest;
			}

			iterations++;
		}

		return bestSolution;
	}

	// Đột biến một cá thể bằng cách chọn một quân hậu ngẫu nhiên và di chuyển nó
	// đến một hàng ngẫu nhiên
	public void mutate(Node node) {
		for (int i = 0; i < Node.N; i++) {
			if (rd.nextDouble() < MUTATION_RATE) {
				node.getState()[i].setRow(rd.nextInt(Node.N));
			}
		}
	}

	// Tạo ra con cái từ hai cha mẹ bằng cách kết hợp các quân hậu từ cả hai cha mẹ
	public Node reproduce(Node x, Node y) {
		Node child = new Node();

		for (int i = 0; i < Node.N; i++) {
			if (rd.nextBoolean()) {
				child.getState()[i].setRow(x.getState()[i].getRow());
			} else {
				child.getState()[i].setRow(y.getState()[i].getRow());
			}
		}

		return child;
	}

	// Lựa chọn cha mẹ thông qua giải thuật Tournament Selection
	public Node getParentByTournamentSelection() {
		int tournamentSize = 5;
		List<Node> tournament = new ArrayList<Node>();

		for (int i = 0; i < tournamentSize; i++) {
			int randomIndex = rd.nextInt(POP_SIZE);
			tournament.add(population.get(randomIndex));
		}

		return findBestSolution(tournament);
	}

	// Lựa chọn cha mẹ ngẫu nhiên từ quần thể
	public Node getParentByRandomSelection() {
		int randomIndex = rd.nextInt(POP_SIZE);
		return population.get(randomIndex);
	}

	// Tìm kiếm cá thể tốt nhất trong một danh sách các cá thể
	private Node findBestSolution(List<Node> nodes) {
		Node best = nodes.get(0);
		for (int i = 1; i < nodes.size(); i++) {
			Node current = nodes.get(i);
			if (current.getH() < best.getH()) {
				best = current;
			}
		}
		return best;
	}

	// Tìm kiếm cá thể tốt nhất trong quần thể hiện tại
	private Node findBestSolution() {
		return findBestSolution(population);
	}
}