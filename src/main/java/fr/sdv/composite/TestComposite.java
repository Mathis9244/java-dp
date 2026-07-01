package fr.sdv.composite;

public class TestComposite {

	public static void main(String[] args) {
		Service direction = new Service("Direction");

		Service rh = new Service("Ressources Humaines");
		rh.ajouter(new Employe("Alice Martin", 3000));
		rh.ajouter(new Employe("Bob Dupont", 3200));

		Service technique = new Service("Technique");
		technique.ajouter(new Employe("Claire Leroy", 4000));
		technique.ajouter(new Employe("David Bernard", 4100));
		technique.ajouter(new Employe("Eve Petit", 3900));
		technique.ajouter(new Employe("Frank Moreau", 4050));

		direction.ajouter(rh);
		direction.ajouter(technique);

		System.out.println("Salaire total Direction : " + direction.calculerSalaire() + " EUR");
		System.out.println("Salaire total RH : " + rh.calculerSalaire() + " EUR");
		System.out.println("Salaire total Technique : " + technique.calculerSalaire() + " EUR");
	}
}
