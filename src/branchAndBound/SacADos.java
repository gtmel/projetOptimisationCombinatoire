package branchAndBound;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import model.Model;

public class SacADos {
	
	private HashMap<String, ArrayList<String>> resultatsPartiels;
	private int coutOptimal;
	private int tailleResultatsPartiels;
	
	public SacADos() {
		this.resultatsPartiels = new HashMap<String, ArrayList<String>>();
		this.coutOptimal = 0;
		this.tailleResultatsPartiels = 0;
	}

	public void ajouterEntree(String base, ArrayList<String> entreprises) {
		/*boolean estPresent = false;
		for (Entry<String, ArrayList<String>> entry : resultatsPartiels.entrySet()) {
			if (entry.getValue().contains(entreprises.get(0))) {
				estPresent = true;
			}
		}
		if (!estPresent) {*/
			resultatsPartiels.put(base, entreprises);
			tailleResultatsPartiels ++;
		//}
	}
	
	public void ajouterEntreprise(String base, String entreprise) {
		ArrayList<String> temporaire = (ArrayList<String>) resultatsPartiels.get(base).clone();
		boolean estPresent = false;
		for (Entry<String, ArrayList<String>> entry : resultatsPartiels.entrySet()) {
			if (entry.getValue().contains(entreprise)) {
				estPresent = true;
			}
		}
		if (!estPresent) {
			temporaire.add(entreprise);
			resultatsPartiels.put(base, temporaire);
			tailleResultatsPartiels ++;
		}
	}
	
	public boolean testResultatsPartiels(int tailleListeEntrepriseInitial) {
		boolean estComplete = false;
		
		if (tailleListeEntrepriseInitial == tailleResultatsPartiels) {
			estComplete = true;
		}
		return estComplete;
	}
	
	public HashMap<String, ArrayList<String>> getResultatsPartiels() {
		return resultatsPartiels;
	}

	public void setResultatsPartiels(HashMap<String, ArrayList<String>> resultatsPartiels) {
		this.resultatsPartiels = resultatsPartiels;
		modifierCoutOptimal();
	}

	private void modifierCoutOptimal() {
		for (Entry<String, ArrayList<String>> entry : resultatsPartiels.entrySet()) {
			for (String entreprise : entry.getValue()) {
				tailleResultatsPartiels++;
			}
		}
	}
	
	public int getCoutOptimal() {
		return coutOptimal;
	}

	public void setCoutOptimal(int coutOptimal) {
		this.coutOptimal = coutOptimal;
	}

	public void afficher() {
		System.out.println(resultatsPartiels.toString());
		System.out.println(coutOptimal);
	}
	
}