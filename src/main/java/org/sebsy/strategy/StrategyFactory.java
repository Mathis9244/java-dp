package org.sebsy.strategy;

public class StrategyFactory {

	public static AlgorithmeTri getStrategie(TypeTri type) {
		if (type == null) {
			throw new IllegalArgumentException("Le type de tri est obligatoire");
		}
		switch (type) {
			case BUBBLE:
				return new TriBubble();
			case INSERTION:
				return new TriInsertion();
			case SELECTION:
				return new TriSelection();
			default:
				throw new IllegalArgumentException("Type de tri inconnu : " + type);
		}
	}
}
