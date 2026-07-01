package state;

public interface CommandeState {

	void ajouterProduit(Commande commande, Produit produit);

	void payer(Commande commande);

	void livrer(Commande commande, String adresse);

	String annuler(Commande commande);
}
