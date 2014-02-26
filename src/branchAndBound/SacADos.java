package branchAndBound;

import java.util.ArrayList;
import java.util.HashMap;

public class SacADos {
	
	private HashMap<String, ArrayList<String>> resultatsPartiels;
	private int coutOptimal;
	
	public SacADos() {
		this.resultatsPartiels = new HashMap<String, ArrayList<String>>();
		this.coutOptimal = 0;
	}

	public void ajouterEntree(String base, ArrayList<String> entreprises) {
		resultatsPartiels.put(base, entreprises);
	}
	
	public void ajouterEntreprise(String base, String entreprise) {
		ArrayList<String> temporaire = resultatsPartiels.get(base);
		temporaire.add(entreprise);
		resultatsPartiels.put(base, temporaire);
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
		System.out.println("\n\n");
	}
	
}