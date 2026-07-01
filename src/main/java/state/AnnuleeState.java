package state;

public class AnnuleeState implements CommandeState {

	@Override
	public void ajouterProduit(Commande commande, Produit produit) {
		throw new IllegalStateException("Impossible d'ajouter un produit : commande annulee");
	}

	@Override
	public void payer(Commande commande) {
		throw new IllegalStateException("Impossible de payer une commande annulee");
	}

	@Override
	public void livrer(Commande commande, String adresse) {
		throw new IllegalStateException("Impossible de livrer une commande annulee");
	}

	@Override
	public String annuler(Commande commande) {
		return "La commande a deja ete annulee";
	}
}
