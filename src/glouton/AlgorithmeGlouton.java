package glouton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import model.Base;
import model.Model;

public class AlgorithmeGlouton {
	
	private Model model;
	private HashMap<String, ArrayList<String>> resultatListe;
	private int resultatCout;
	
	public AlgorithmeGlouton(Model model) {
		this.model = model;
		this.resultatListe = new HashMap<String, ArrayList<String>>();
		this.resultatCout = 0;
		
		rechercheGlouton(0);
	}
	
	public void rechercheGlouton(int increment) {
		
		if (increment < model.getEntreprises().size()) {
			
			// Nom de l'entreprise recherchée
			String nomEntreprise = model.getEntreprises().get(increment);
			
			String meilleurChoixBase = "";
			int meilleurChoixCout = 0;
			boolean estPresent = false;
			
			// Pour chaque base contenant l'entreprise 
			for (Base base : model.getEntreprisesBases().get(nomEntreprise)) {
				if (!estPresent) {
					for (Entry<String, ArrayList<String>> entry : resultatListe.entrySet()) {
						if (entry.getKey().equals(base.getNomBase()) && "".equals(meilleurChoixBase)) {
							meilleurChoixBase = base.getNomBase();
							meilleurChoixCout = 0;
							estPresent = true;
						}
					}
					if (!estPresent) {
						if ("".equals(meilleurChoixBase)) { // Premier résultat partiel
							meilleurChoixBase = base.getNomBase();
							meilleurChoixCout = base.getCoutBase();
						} else {
							if (base.getCoutBase() < meilleurChoixCout) {
								meilleurChoixBase = base.getNomBase();
								meilleurChoixCout = base.getCoutBase();
							}
						}
					}
				}
			}
			if (estPresent) {
				resultatListe.get(meilleurChoixBase).add(nomEntreprise);
				rechercheGlouton(increment + 1);
			} else {
				ArrayList<String> entreprises = new ArrayList<String>();
				entreprises.add(nomEntreprise);
				resultatListe.put(meilleurChoixBase, entreprises);
				resultatCout += meilleurChoixCout;
				rechercheGlouton(increment + 1);
			}
		}
		
	}

	public HashMap<String, ArrayList<String>> getResultatListe() {
		return resultatListe;
	}

	public void setResultatListe(HashMap<String, ArrayList<String>> resultatListe) {
		this.resultatListe = resultatListe;
	}

	public int getResultatCout() {
		return resultatCout;
	}

	public void setResultatCout(int resultatCout) {
		this.resultatCout = resultatCout;
	}
	public void afficherResultat() {
		System.out.println(resultatListe.toString());
		System.out.println(resultatCout);
	}

}
