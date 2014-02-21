package projetOptimisationCombinatoire;

import java.util.ArrayList;

public class Model {
	
	private ArrayList<Base> bases;
	private ArrayList<Entreprise> entreprises;
	
	Model() {
		
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

}
