package projetOptimisationCombinatoire;

import java.util.ArrayList;

public class Model {
	
	private ArrayList<Base> bases;
	private ArrayList<Entreprise> entreprises;
	
	public Model() {
		
	}

	public ArrayList<Base> getBases() {
		return bases;
	}

	public void setBases(ArrayList<Base> bases) {
		this.bases = bases;
	}

	public ArrayList<Entreprise> getEntreprises() {
		return entreprises;
	}

	public void setEntreprises(ArrayList<Entreprise> entreprises) {
		this.entreprises = entreprises;
	}
	
	public void afficher() {
		afficherBases();
		afficherEntreprises();
	}
	
	public void afficherBases() {
		System.out.println("***** LISTE DES BASES *****");
		System.out.println("\n\n");
		for (Base base : bases) {
			System.out.println("Nom de la base : " + base.getNomBase());
			System.out.println("Coût de la base : " + base.getCoutBase());
			for (String nomEntreprise : base.getNomEntreprises()) {
				System.out.println(nomEntreprise);
			}
			System.out.println("\n");
		}
	}
	
	public void afficherEntreprises() {
		System.out.println("***** LISTE DES ENTREPRISES *****");
		System.out.println("\n\n");
		for (Entreprise entreprise : entreprises) {
			System.out.println(entreprise.getNomEntreprise());
		}
		System.out.println("\n");
	}

}
