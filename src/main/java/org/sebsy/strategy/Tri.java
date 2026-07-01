package org.sebsy.strategy;

public class Tri {

	public void exec(TypeTri typeTri, Integer[] arr) {
		AlgorithmeTri algorithme = StrategyFactory.getStrategie(typeTri);
		algorithme.trier(arr);
	}
}
