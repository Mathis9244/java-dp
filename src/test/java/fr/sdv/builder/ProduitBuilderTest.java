package fr.sdv.builder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ProduitBuilderTest {

	@Test
	public void buildProduitComplet() {
		Produit p = new ProduitBuilder()
				.nom("Yaourt nature")
				.grade("A")
				.categorie("Produits laitiers")
				.marque("Danone")
				.ingredient("Lait", 850.0)
				.additif("Colorant E150d", 0.5)
				.allergene("Lait", 850.0)
				.build();

		assertEquals("Yaourt nature", p.getNom());
		assertEquals("A", p.getGrade());
		assertEquals("Produits laitiers", p.getCategorie().getNom());
		assertEquals("Danone", p.getMarque().getNom());
		assertEquals(1, p.getIngredients().size());
		assertEquals(1, p.getAdditifs().size());
		assertEquals(1, p.getAllergenes().size());
	}

	@Test
	public void buildProduitSansAdditifsNiAllergenes() {
		Produit p = new ProduitBuilder()
				.nom("Eau minerale")
				.grade("A")
				.categorie("Boissons")
				.marque("Evian")
				.ingredient("Eau", 1000.0)
				.build();

		assertTrue(p.getAdditifs().isEmpty());
		assertTrue(p.getAllergenes().isEmpty());
		assertEquals(1, p.getIngredients().size());
	}

	@Test(expected = IllegalStateException.class)
	public void buildSansNomEchoue() {
		new ProduitBuilder()
				.grade("B")
				.build();
	}
}
