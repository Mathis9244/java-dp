package state;

public class CreationState implements CommandeState {

	@Override
	public void ajouterProduit(Commande commande, Produit produit) {
		commande.getProduits().add(produit);
	}

	@Override
	public void payer(Commande commande) {
		commande.setEtat(new PaiementState());
	}

	@Override
	public void livrer(Commande commande, String adresse) {
		throw new IllegalStateException("La livraison n'est possible qu'apres le paiement");
	}

	@Override
	public String annuler(Commande commande) {
		commande.setEtat(new AnnuleeState());
		return "Commande annulee";
	}
}
