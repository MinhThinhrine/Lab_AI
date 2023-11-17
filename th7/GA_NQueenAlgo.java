package th7;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GA_NQueenAlgo {
    private static final int POPULATION_SIZE = 100;
    private static final double MUTATION_RATE = 0.05;
    private static final int MAX_GENERATIONS = 1000;

    private int boardSize;

    public GA_NQueenAlgo(int boardSize) {
        this.boardSize = boardSize;
    }

    public List<Chromosome> initializePopulation() {
        List<Chromosome> population = new ArrayList<>();

        for (int i = 0; i < POPULATION_SIZE; i++) {
            Chromosome chromosome = new Chromosome(boardSize);
            chromosome.generateRandom();
            population.add(chromosome);
        }

        return population;
    }

    public Chromosome selection(List<Chromosome> population) {
        Random random = new Random();
        int index1 = random.nextInt(population.size());
        int index2 = random.nextInt(population.size());

        Chromosome chromosome1 = population.get(index1);
        Chromosome chromosome2 = population.get(index2);

        return chromosome1.getFitness() < chromosome2.getFitness() ? chromosome1 : chromosome2;
    }

    public Chromosome crossover(Chromosome parent1, Chromosome parent2) {
        Chromosome child = new Chromosome(boardSize);
        Random random = new Random();

        int crossoverPoint = random.nextInt(boardSize);

        for (int i = 0; i < crossoverPoint; i++) {
            parent1.setGene(i,i);
        }

        for (int i = crossoverPoint; i < boardSize; i++) {
            child.setGene(i, i);;
        }

        return child;
    }

    public void mutate(Chromosome chromosome) {
        Random random = new Random();

        for (int i = 0; i < boardSize; i++) {
            if (random.nextDouble() < MUTATION_RATE) {
                int gene = random.nextInt(boardSize);
                chromosome.setGene(i, gene);
            }
        }
    }

    public Chromosome geneticAlgorithm() {
        List<Chromosome> population = initializePopulation();
        int generation = 0;

        while (generation < MAX_GENERATIONS) {
            List<Chromosome> newPopulation = new ArrayList<>();

            for (int i = 0; i < POPULATION_SIZE; i++) {
                Chromosome parent1 = selection(population);
                Chromosome parent2 = selection(population);

                Chromosome child = crossover(parent1, parent2);

                mutate(child);

                newPopulation.add(child);
            }

            population = newPopulation;
            generation++;
        }

        Chromosome bestChromosome = population.get(0);

        for (Chromosome chromosome : population) {
            if (chromosome.getFitness() < bestChromosome.getFitness()) {
                bestChromosome = chromosome;
            }
        }

        return bestChromosome;
    }

    public static void main(String[] args) {
        int boardSize = 8;
        GA_NQueenAlgo ga = new GA_NQueenAlgo(boardSize);
        Chromosome solution = ga.geneticAlgorithm();
        System.out.println("Best Solution: " + solution);
    }
}