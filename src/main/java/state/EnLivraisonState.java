package state;

public class EnLivraisonState implements CommandeState {

	@Override
	public void ajouterProduit(Commande commande, Produit produit) {
		throw new IllegalStateException("Impossible d'ajouter un produit : commande en livraison");
	}

	@Override
	public void payer(Commande commande) {
		throw new IllegalStateException("La commande est deja payee");
	}

	@Override
	public void livrer(Commande commande, String adresse) {
		throw new IllegalStateException("La commande est deja en cours de livraison");
	}

	@Override
	public String annuler(Commande commande) {
		return "La commande est deja en cours de livraison, l'annulation est impossible";
	}
}
