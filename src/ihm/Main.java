package ihm;

import projetOptimisationCombinatoire.Model;
import readers.Lecteur;;

public class Main {

	public static void main(String[] args) {
		String cheminBases = "./bin/docs/listesBases/ListeBases1.txt";
		String cheminEntreprises = "./bin/docs/listesEntreprises/ListeEntreprises1.txt";
		Lecteur lecteur = new Lecteur(cheminBases, cheminEntreprises);
		Model model = new Model();
		model.setBases(lecteur.lireBases());
		model.setEntreprises(lecteur.lireEntreprises());
		model.afficher();

	}

}
