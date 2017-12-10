package controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * 
 * @author talhasaleem09
 * 
 *         f(a,b,c,d) = 2a^2 - 2.5abc^2 + 4bcd + 0.25cd - 0.2d^2
 * 
 *         0 <= a <= 1 ------> $a = 0.02 -2 <= b <= 2 ------> $b = 0.22 -1 <= c
 *         <= 1 ------> $c = -0.11 1 <= d <= 2 ------> $d = 0.22
 * 
 *         initPop[25][5] child[40][5] 2 child/iteration k =50 mutation = 50%
 *         gene mutation = 25% each
 * 
 *         if (a + $) becomes > 1 or < 0 for constrain 'a' the stop it till max
 *         value
 *
 */

public class Genes {

	private int generations;
	private int[][] initialPopulation;
	private int[][] childProduced;
	private int[][] fittestPopulation;
	private int nQueen;
	private int mutationRate;
	private int childNumber;
	protected ArrayList<GeneTable> fitness;

	public Genes(int k, int initialPopulation, int childrenProduction, int mutationRate, int nQueen) {
		this.generations = k;
		this.initialPopulation = new int[initialPopulation][nQueen+1];
		this.childProduced = new int[childrenProduction][nQueen+1];
		this.fittestPopulation = new int[initialPopulation + childrenProduction][nQueen+1];
		this.nQueen = nQueen;
		this.mutationRate = mutationRate;
		this.childNumber = 0;
		this.fitness = new ArrayList<>();

		geneticAlgorithm();
		
		writeToFile();

	}

	private void geneticAlgorithm() {
		for (int i = 0; i < generations; i++) {

			if (i == 0) {
				initializePopulation();
			}

			boolean untilChildrenAreProduce = true;

			while (untilChildrenAreProduce) {

				// Parent Selection

				int father = 0 + (int) (Math.random() * (initialPopulation.length - 1));
				int mother = 0 + (int) (Math.random() * (initialPopulation.length - 1));

				while (true) {
					if (father == mother) {
						mother = 0 + (int) (Math.random() * (initialPopulation.length - 1));
					} else {
						break;
					}
				}

				// Cross Over and Child Production

				if (childNumber < childProduced.length) {
					produceChild(father, mother);
				} else {
					break;
				}

			}

			// fittest population

			for (int l = 0; l < fittestPopulation.length; l++) {
				for (int m = 0; m < fittestPopulation[l].length; m++) {
					if (l < initialPopulation.length) {
						fittestPopulation[l][m] = initialPopulation[l][m];
					} else {
						fittestPopulation[l][m] = childProduced[l - initialPopulation.length][m];
					}
				}
			}

			// Sort Initial Population and ChildProduced in Fittest population
			// wrt Fitness level

			java.util.Arrays.sort(fittestPopulation, new java.util.Comparator<int[]>() {
				public int compare(int[] a, int[] b) {
					return Integer.compare(a[4], b[4]);
				}
			});

			for (int l = 0; l < initialPopulation.length; l++) {
				for (int m = 0; m < initialPopulation[l].length; m++) {
					initialPopulation[l][m] = fittestPopulation[l][m];
				}
			}

			fitness.add(new GeneTable(i+1, initialPopulation[0][0], initialPopulation[0][1], initialPopulation[0][2],
					initialPopulation[0][3], initialPopulation[0][4]));
			childNumber = 0;
		}

	}

	private void produceChild(int father, int mother) {

 
	}

	private void magic(int a, int b, int c, int d) {



	}


	private boolean mutation() {
		// Randomly generated number for 50% probability for Mutation occurring
		int rand = 0 + (int) (Math.random() * 100);

		// Mutation success?
		if (rand >= mutationRate) {
			return true;
		}

		return false;
	}

	// Initialize the whole population randomly and according to constraints
	// given
	private void initializePopulation() {
		
		int[][] queen;
		
		for (int i = 0; i < initialPopulation.length; i++) {
			
			queen = new int[1][nQueen];
			
			for(int j = 0; j < queen[0].length; j++) {
				
				while(true) {
					
					int value = 0 + (int)(Math.random() * nQueen);
					
					if(checkQueenPlacement(queen, value)) {
						queen[0][j] = value;
						break;
					}
				}
				
			}
			
			int nQueenFitness = nQueenFitness(queen);
			initialPopulation[i] = queen[0];
			initialPopulation[i][initialPopulation[i].length-1] = nQueenFitness;
		}

	}
	
	private int nQueenFitness(int arr[][]) {
		int[][] queen = new int[nQueen][nQueen];
		
		for(int i = 0; i < nQueen; i++) {
			queen[i][arr[0][i]] = 1;
		}
		
		int fit = checkFitness(queen, arr);
		
		return fit;
	}
	
	private int checkFitness(int arr[][], int[][] queen) {
		
		int fitnessLevel = 0;
		
		for(int row = 0; row < queen.length; row++) {
			int a = (queen.length - 1) - row;
			int b = (queen.length - 1) - queen[0][row];
			int c = (queen.length - 1) - a;
			int d = (queen.length - 1) - b;
			
			int max, min, maxA, minA;
			
			if(a > b) {
				max = a;
				min = b;
			} else {
				max = b;
				min = a;
			}
			
			if(c > d) {
				maxA = c;
				minA = d;
			} else {
				maxA = d;
				minA = c;
			}
			
			boolean flag = true;
			
			for(int i = 1; i <= min; i++) {
				if(arr[row+i][queen[0][i]+i] == 1) {
					flag = false;
					break;
				}
			}
			
			for(int i = 1; i <= ((queen.length-1)-max); i++) {
				if(arr[row-i][queen[0][i]-i] == 1) {
					flag = false;
					break;
				}
			}
			
			for(int i = 1; i <= minA; i++) {
				if(arr[row+1][queen[0][i]-i] == 1) {
					flag = false;
					break;
				}
			}
			
			for(int i = 1; i <= ((queen.length-1)-maxA); i++) {
				if(arr[row-i][queen[0][i]+i] == 1) {
					flag = false;
					break;
				}
			}
			
			if(flag) {
				fitnessLevel++;
			}
			
		}
		
		
		return fitnessLevel;
	}
	
	private boolean checkQueenPlacement(int[][] arr, int val) {
		
		for(int i = 0; i < arr[0].length; i++) {
			if(arr[0][i] == val) {
				return false;
			}
		}
		
		return true;
	}

	
	private void writeToFile() {
		File outputFile = new File("fitness.txt");
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(outputFile));
			
			out.write("Population: " + initialPopulation.length);
			out.newLine();
			
			out.write("Children: " + childProduced.length);
			out.newLine();
			
			out.write("Mutation: " + mutationRate + "%");
			out.newLine();
			
			out.write("Generations: " + generations);
			out.newLine();
			
			out.newLine();
			
			for(int i = 0; i < fitness.size(); i++) {
				out.write("" + fitness.get(i).getFitness());
				out.newLine();
			}
			
			out.close();
		} catch (IOException e) {

			System.out.println("File Not Found!");
		}
	}

}
