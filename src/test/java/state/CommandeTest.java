package state;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CommandeTest {

	@Test
	public void cycleNominal() {
		Commande commande = new Commande();
		commande.ajouterProduit(new Produit("Pomme"));
		commande.ajouterProduit(new Produit("Poire"));

		assertEquals(1.0, commande.payer(), 0.001);
		commande.livrer("10 rue de Paris");

		assertTrue(commande.getEtat() instanceof EnLivraisonState);
		assertEquals("10 rue de Paris", commande.getAdresse());
	}

	@Test
	public void annulerEnCreation() {
		Commande commande = new Commande();
		commande.ajouterProduit(new Produit("Banane"));

		assertEquals("Commande annulee", commande.annuler());
		assertTrue(commande.getEtat() instanceof AnnuleeState);
	}

	@Test
	public void annulerImpossibleEnLivraison() {
		Commande commande = new Commande();
		commande.ajouterProduit(new Produit("Banane"));
		commande.payer();
		commande.livrer("5 avenue Victor Hugo");

		assertEquals(
				"La commande est deja en cours de livraison, l'annulation est impossible",
				commande.annuler());
	}

	@Test
	public void annulerDejaAnnulee() {
		Commande commande = new Commande();
		commande.annuler();

		assertEquals("La commande a deja ete annulee", commande.annuler());
	}
}
