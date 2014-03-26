package branchAndBound;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

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
		resultatsPartiels.put(base, entreprises);
		tailleResultatsPartiels ++;
	}
	
//	public void ajouterEntreprise(String base, String entreprise) {
//		boolean estPresent = false;
//		for (Entry<String, ArrayList<String>> entry : resultatsPartiels.entrySet()) {
//			if (entry.getValue().contains(entreprise)) {
//				estPresent = true;
//			}
//		}
//		if (!estPresent) {
//			ArrayList<String> temporaire = new ArrayList<String>(resultatsPartiels.get(base));
//			temporaire.add(entreprise);
//			resultatsPartiels.put(base, temporaire);
//			tailleResultatsPartiels ++;
//		}
//	}
	
	public void ajouterEntreprise(String base, String entreprise) {
		boolean estPresent = false;
		for (Entry<String, ArrayList<String>> entry : resultatsPartiels.entrySet()) {
			if (entry.getValue().contains(entreprise)) {
				estPresent = true;
			}
		}
		if (!estPresent) {
			//ArrayList<String> temporaire = new ArrayList<String>(resultatsPartiels.get(base));
			//temporaire.add(entreprise);
			//resultatsPartiels.put(base, temporaire);
			ArrayList<String> test = resultatsPartiels.get(base);
			test.add(entreprise);
			tailleResultatsPartiels ++;
		}
	}

	public boolean testResultatsPartiels(int tailleListeEntrepriseInitial) {
		if (tailleListeEntrepriseInitial == tailleResultatsPartiels) {
			return true;
		}
		return false;
	}
	
	public int getCoutOptimal() {
		return coutOptimal;
	}

	public void setCoutOptimal(int coutOptimal) {
		this.coutOptimal = coutOptimal;
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
			for (int i = 0; i < entry.getValue().size(); i++) {
				tailleResultatsPartiels++;
			}
		}
	}

	public String toString() {
		String affichage = "";
		affichage += "Coût = " + coutOptimal;
		affichage += resultatsPartiels.toString();
		return affichage;
	}
	
}