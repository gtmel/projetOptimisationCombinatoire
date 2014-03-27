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
	
	private String logs;
	
	public AlgorithmeGlouton(Model model) {
		this.model = model;
		this.resultatListe = new HashMap<String, ArrayList<String>>();
		this.resultatCout = 0;
		this.logs = "";
		rechercheGlouton(0);
	}
	
	public void rechercheGlouton(int increment) {
		
		if (increment < model.getEntreprises().size()) {
			
			// Nom de l'entreprise recherchée
			String nomEntreprise = model.getEntreprises().get(increment);
			
			String meilleurChoixBase = "";
			int meilleurChoixCout = 0;
			int nbEntreprises = 0;
			boolean estPresent = false;
			
			// Pour chaque base contenant l'entreprise 
			for (Base base : model.getEntreprisesBases().get(nomEntreprise)) {
				
				logs += "\n";
				for (int i = 0; i < increment; i++) {
					logs += "\t";
				}
				logs += "INCREMENT : " + increment + ", ";
				logs += "ENTREPRISE : " + nomEntreprise + ", ";
				logs += "BASE -> " + base.getNomBase() + ", ";
				
				if (!estPresent) {
					for (Entry<String, ArrayList<String>> entry : resultatListe.entrySet()) {
						if (entry.getKey().equals(base.getNomBase())) {
							meilleurChoixBase = base.getNomBase();
							meilleurChoixCout = 0;
							nbEntreprises = calculerNombreEntreprises(base);
							estPresent = true;
						}
					}
					if (!estPresent) {
						if ("".equals(meilleurChoixBase)) { // Premier résultat partiel
							meilleurChoixBase = base.getNomBase();
							meilleurChoixCout = base.getCoutBase();
							nbEntreprises = calculerNombreEntreprises(base);
						} else {
							if (base.getCoutBase() < meilleurChoixCout) {
								meilleurChoixBase = base.getNomBase();
								meilleurChoixCout = base.getCoutBase();
								nbEntreprises = calculerNombreEntreprises(base);
							}
							if (base.getCoutBase() == meilleurChoixCout) {
								int temporaire = calculerNombreEntreprises(base);
								if (temporaire > nbEntreprises) {
									meilleurChoixBase = base.getNomBase();
									meilleurChoixCout = base.getCoutBase();
								}
							}
						}
					}
				}
			}
			if (estPresent) {
				logs += "\n";
				for (int i = 0; i < increment; i++) {
					logs += "\t";
				}
				logs += "Choix --> " + meilleurChoixBase + " (Cout = 0)\n";
				resultatListe.get(meilleurChoixBase).add(nomEntreprise);
				rechercheGlouton(increment + 1);
			} else {
				logs += "\n";
				for (int i = 0; i < increment; i++) {
					logs += "\t";
				}
				logs += "Choix --> " + meilleurChoixBase + " (Cout = " + meilleurChoixCout + ")\n";
				ArrayList<String> entreprises = new ArrayList<String>();
				entreprises.add(nomEntreprise);
				resultatListe.put(meilleurChoixBase, entreprises);
				resultatCout += meilleurChoixCout;
				rechercheGlouton(increment + 1);
			}
		}
		
	}
	
	private int calculerNombreEntreprises(Base base) {
		int nbEntreprises = 0;
		for (String entreprise : base.getEntreprises()) {
			for (String ent : model.getEntreprises()) {
				if (entreprise.equals(ent)) {
					nbEntreprises++;
				}
			}
		}
		return nbEntreprises;
	}

	public String afficherResultat() {
		String affichageResultat = "";
		affichageResultat += "Meilleur coût : " + resultatCout + "\n\n";
		for (Entry<String, ArrayList<String>> entry : resultatListe.entrySet()) {
			affichageResultat += "\tBase " + entry.getKey() + "\n";
			for (String entreprise : entry.getValue()) {
				affichageResultat += "\t\t" + entreprise + "\n";
			}
			affichageResultat += "\n";
		}
		return affichageResultat;
	}
	
	public String getLogs() {
		return logs;
	}

}
