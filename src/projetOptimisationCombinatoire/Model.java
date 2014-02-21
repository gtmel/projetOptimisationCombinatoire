package projetOptimisationCombinatoire;

import java.util.ArrayList;

public class Model {
	
	private ArrayList<Base> bases;
	private ArrayList<String> entreprises;
	
	public Model() {
		
	}

	public ArrayList<Base> getBases() {
		return bases;
	}

	public void setBases(ArrayList<Base> bases) {
		this.bases = bases;
	}

	public ArrayList<String> getEntreprises() {
		return entreprises;
	}

	public void setEntreprises(ArrayList<String> entreprises) {
		this.entreprises = entreprises;
	}
	
	public void afficher() {
		afficherBases();
		afficherEntreprises();
	}
	
	public void afficherBases() {
		System.out.println("***** LISTE DES BASES *****");
		System.out.println("\n");
		for (Base base : bases) {
			System.out.println("Nom de la base : " + base.getNomBase());
			System.out.println("Coût de la base : " + base.getCoutBase());
			for (String nomEntreprise : base.getEntreprises()) {
				System.out.println(nomEntreprise);
			}
			System.out.println("\n");
		}
	}
	
	public void afficherEntreprises() {
		System.out.println("***** LISTE DES ENTREPRISES *****");
		System.out.println("\n");
		for (String entreprise : entreprises) {
			System.out.println(entreprise);
		}
		System.out.println("\n");
	}

}
