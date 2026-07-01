package state;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Commande {

	private final List<Produit> produits = new ArrayList<>();
	private String adresse;
	private CommandeState etat = new CreationState();

	void setEtat(CommandeState etat) {
		this.etat = etat;
	}

	public void ajouterProduit(Produit produit) {
		etat.ajouterProduit(this, produit);
	}

	public double payer() {
		etat.payer(this);
		return calculerPrixTotal();
	}

	public void livrer(String adresse) {
		etat.livrer(this, adresse);
	}

	public String annuler() {
		return etat.annuler(this);
	}

	public double calculerPrixTotal() {
		return produits.size() * 0.5;
	}

	List<Produit> getProduits() {
		return produits;
	}

	public List<Produit> getProduitsLus() {
		return Collections.unmodifiableList(produits);
	}

	String getAdresse() {
		return adresse;
	}

	void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public CommandeState getEtat() {
		return etat;
	}
}
