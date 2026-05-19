package fr.sdv.factory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class FactoryTest {

	private final ElementFactory factory = new ElementFactory();

	@Test
	public void createIngredient() {
		Element e = factory.create(TypeElement.INGREDIENT, "Sucre", 12.5, UNITE.MILLI_GRAMMES);
		assertTrue(e instanceof Ingredient);
		assertEquals("Sucre", e.getNom());
		assertEquals(12.5, e.getValeur(), 0.001);
		assertEquals(UNITE.MILLI_GRAMMES, e.getUnite());
	}

	@Test
	public void createAdditif() {
		Element e = factory.create(TypeElement.ADDITIF, "Colorant E102", 0.2, UNITE.MICRO_GRAMMES);
		assertTrue(e instanceof Additif);
		assertEquals("Colorant E102", e.getNom());
	}

	@Test
	public void createAllergene() {
		Element e = factory.create(TypeElement.ALLERGENE, "Gluten", 50.0, UNITE.MILLI_GRAMMES);
		assertTrue(e instanceof Allergene);
		assertEquals("Gluten", e.getNom());
	}

	@Test(expected = IllegalArgumentException.class)
	public void createAvecTypeNull() {
		factory.create(null, "Test", 1.0, UNITE.MILLI_GRAMMES);
	}
}
