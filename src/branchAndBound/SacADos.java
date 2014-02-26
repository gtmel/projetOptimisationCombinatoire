package branchAndBound;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class SacADos {
	
	private HashMap<String, ArrayList<String>> resultatsPartiels;
	private int coutOptimal;
	
	public SacADos() {
		this.resultatsPartiels = new HashMap<String, ArrayList<String>>();
		this.coutOptimal = 0;
	}

	public void ajouterEntree(String base, ArrayList<String> entreprises) {
		boolean estPresent = false;
		for (Entry<String, ArrayList<String>> entry : resultatsPartiels.entrySet()) {
			if (entry.getValue().contains(entreprises.get(0))) {
				estPresent = true;
			}
		}
		if (!estPresent) {
			resultatsPartiels.put(base, entreprises);	
		}
	}
	
	public void ajouterEntreprise(String base, String entreprise) {
		ArrayList<String> temporaire = resultatsPartiels.get(base);
		boolean estPresent = false;
		for (Entry<String, ArrayList<String>> entry : resultatsPartiels.entrySet()) {
			if (entry.getValue().contains(entreprise)) {
				estPresent = true;
			}
		}
		if (!estPresent) {
			temporaire.add(entreprise);
			resultatsPartiels.put(base, temporaire);	
		}
	}
	
	public HashMap<String, ArrayList<String>> getResultatsPartiels() {
		return resultatsPartiels;
	}

	public void setResultatsPartiels(HashMap<String, ArrayList<String>> resultatsPartiels) {
		this.resultatsPartiels = resultatsPartiels;
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