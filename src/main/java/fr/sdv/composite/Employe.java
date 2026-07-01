package fr.sdv.composite;

public class Employe implements IElement {

	private final String nom;
	private final double salaire;

	public Employe(String nom, double salaire) {
		this.nom = nom;
		this.salaire = salaire;
	}

	public String getNom() {
		return nom;
	}

	public double getSalaire() {
		return salaire;
	}

	@Override
	public double calculerSalaire() {
		return salaire;
	}
}
