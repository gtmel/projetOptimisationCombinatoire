package ihm;

import glouton.AlgorithmeGlouton;
import branchAndBound.AlgorithmeBranchAndBound;
import model.Model;
import readers.Lecteur;

public class Main {

	public static void main(String[] args) {
		
		// Initialisation du compteur temps;
		long debut = System.currentTimeMillis();

		// Choix des fichiers
		String cheminListeBases = "./bin/docs/listesBases/ListeBases1.txt";
		String cheminListeEntreprises = "./bin/docs/listesEntreprises/ListeEntreprises1.txt";
		//String cheminListeBases = "./bin/docs/listesBases/lb1.txt";
		//String cheminListeEntreprises = "./bin/docs/listesEntreprises/le1.txt";
		
		// Lecture des fichiers
		Lecteur lecteur = new Lecteur(cheminListeBases, cheminListeEntreprises);
		Model model = new Model();
		lecteur.lireBases();
		model.setBases(lecteur.getBases());
		model.setEntreprises(lecteur.lireEntreprises());
		model.setEntreprisesBases(lecteur.getEntreprisesBases());
		
		// Temps intermédiaire = chargement des fichiers
		long inter = System.currentTimeMillis();
		System.out.println("TEMPS DE CHARGEMENT : " + (inter - debut) + " ms");
		
		//model.afficher();
		//AlgorithmeBranchAndBound algoBB = new AlgorithmeBranchAndBound(model);
		AlgorithmeGlouton algoGlouton = new AlgorithmeGlouton(model);
		algoGlouton.afficherResultat();
		
		// Temps final = temps d'éxecution de l'algorithme
		long fin = System.currentTimeMillis();
		System.out.println("TEMPS D'EXECUTION ALGO : " + (fin - inter) + " ms");
	}

}
