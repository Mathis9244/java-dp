package fr.sdv.factory;

public class ElementFactory {

	public Element create(TypeElement type, String nom, double valeur, UNITE unite) {
		if (type == null) {
			throw new IllegalArgumentException("Le type est obligatoire");
		}
		switch (type) {
			case INGREDIENT:
				return new Ingredient(nom, valeur, unite);
			case ADDITIF:
				return new Additif(nom, valeur, unite);
			case ALLERGENE:
				return new Allergene(nom, valeur, unite);
			default:
				throw new IllegalArgumentException("Type inconnu : " + type);
		}
	}
}
