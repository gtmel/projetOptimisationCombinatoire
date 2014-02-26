package ihm;

import model.Model;
import readers.Lecteur;

public class Main {

	public static void main(String[] args) {
		String cheminListeBases = "./bin/docs/listesBases/ListeBases1.txt";
		String cheminListeEntreprises = "./bin/docs/listesEntreprises/ListeEntreprises1.txt";
		Lecteur lecteur = new Lecteur(cheminListeBases, cheminListeEntreprises);
		Model model = new Model();
		model.setBases(lecteur.lireBases());
		model.setEntreprises(lecteur.lireEntreprises());
		model.afficher();

	}

}
