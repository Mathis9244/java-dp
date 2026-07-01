package state;

public class PaiementState implements CommandeState {

	@Override
	public void ajouterProduit(Commande commande, Produit produit) {
		throw new IllegalStateException("Impossible d'ajouter un produit apres le paiement");
	}

	@Override
	public void payer(Commande commande) {
		throw new IllegalStateException("La commande est deja payee");
	}

	@Override
	public void livrer(Commande commande, String adresse) {
		commande.setAdresse(adresse);
		commande.setEtat(new EnLivraisonState());
	}

	@Override
	public String annuler(Commande commande) {
		commande.setEtat(new AnnuleeState());
		return "Commande annulee";
	}
}
