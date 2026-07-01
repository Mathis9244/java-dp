package fr.sdv.composite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Service implements IElement {

	private final String nom;
	private final List<IElement> elements = new ArrayList<>();

	public Service(String nom) {
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}

	public void ajouter(IElement element) {
		elements.add(element);
	}

	public List<IElement> getElements() {
		return Collections.unmodifiableList(elements);
	}

	@Override
	public double calculerSalaire() {
		return elements.stream().mapToDouble(IElement::calculerSalaire).sum();
	}
}
