package controller;

public class GeneTable {

	private int generations;
	private double geneA;
	private double geneB;
	private double geneC;
	private double geneD;
	private double fitness;

	public int getGenerations() {
		return generations;
	}

	public void setGenerations(int generations) {
		this.generations = generations;
	}

	public double getGeneA() {
		return geneA;
	}

	public void setGeneA(double geneA) {
		this.geneA = geneA;
	}

	public double getGeneB() {
		return geneB;
	}

	public void setGeneB(double geneB) {
		this.geneB = geneB;
	}

	public double getGeneC() {
		return geneC;
	}

	public void setGeneC(double geneC) {
		this.geneC = geneC;
	}

	public double getGeneD() {
		return geneD;
	}

	public void setGeneD(double geneD) {
		this.geneD = geneD;
	}

	public double getFitness() {
		return fitness;
	}

	public void setFitness(double fitness) {
		this.fitness = fitness;
	}

	public GeneTable(int generations, double geneA, double geneB, double geneC, double geneD, double fitness) {
		super();
		this.generations = generations;
		this.geneA = geneA;
		this.geneB = geneB;
		this.geneC = geneC;
		this.geneD = geneD;
		this.fitness = fitness;
	}

}
