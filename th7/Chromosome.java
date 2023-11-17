package th7;

import java.util.Arrays;
import java.util.Random;

public class Chromosome {
	private int[] genes;
	private int fitness;

	public Chromosome(int size) {
		genes = new int[size];
		fitness = 0;
	}

	public void generateRandom() {
		Random random = new Random();

		for (int i = 0; i < genes.length; i++) {
			genes[i] = random.nextInt(genes.length);
		}
	}

	public int[] getGenes() {
		return genes;
	}

	public void setGene(int index, int value) {
		genes[index] = value;
	}

	public int getFitness() {
		return fitness;
	}

	public void calculateFitness() {
		int collisions = 0;

		for (int i = 0; i < genes.length; i++) {
			for (int j = i + 1; j < genes.length; j++) {
				if (genes[i] == genes[j] || Math.abs(genes[i] - genes[j]) == Math.abs(i - j)) {
					collisions++;
				}
			}
		}

		fitness = collisions;
	}

	@Override
	public String toString() {
		return Arrays.toString(genes);
	}


}