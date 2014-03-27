package branchAndBound;

import java.util.ArrayList;
import java.util.Map.Entry;

import model.Base;
import model.Model;

public class AlgorithmeBranchAndBound {

	private Model model;
	private SacADos sacADos;
	private int majorant;
	
	private SacADos resultat;
	private int compteurMajorants;
	private int compteurBranches;
	private int compteurBranchesCoupees;
	
	private String logs;

	public AlgorithmeBranchAndBound(Model model) {
		this.model = model;
		this.sacADos = new SacADos();
		this.majorant = -1;
		
		this.resultat = null;
		this.compteurMajorants = 0;
		this.compteurBranches = 0;
		this.compteurBranchesCoupees = 0;
		
		this.logs = "";
		
		rechercheOptimale(sacADos, 0);
		
		//System.out.println(logs);
	}
	
	public void rechercheOptimale(SacADos sacADos, int increment) {
		
		if (increment < model.getEntreprises().size()) {
			
			// Nom de l'entreprise recherchée
			String nomEntreprise = model.getEntreprises().get(increment);

			// Pour chaque base contenant l'entreprise 
			for (Base base : model.getEntreprisesBases().get(nomEntreprise)) {
					
				logs += "\n";
				for (int i = 0; i < increment; i++) {
					logs += "\t";
				}
				logs += "INCREMENT : " + increment + ", ";
				logs += "ENTREPRISE : " + nomEntreprise + ", ";
				logs += "BASE -> " + base.getNomBase() + ", ";
				
				SacADos nouveauSac = new SacADos(sacADos);
				
				// et qui n'est pas dans la liste partielle
				if (!sacADos.rechercherBase(base)) {
					ArrayList<String> nouvelleListeEntreprises = new ArrayList<String>();
					nouvelleListeEntreprises.add(nomEntreprise);
					nouveauSac.ajouterEntree(base.getNomBase(), nouvelleListeEntreprises);
					// On ajoute le coût de la base ouverte au coût optimal
					nouveauSac.incrementerCoutOptimal(base.getCoutBase());
				} else {
					nouveauSac.ajouterEntreprise(base.getNomBase(), nomEntreprise);
					// On incrémente pas le coût optimal puisque la base était déjà ouverte
				}
				
				logs += nouveauSac.toString();
				
				if(!nouveauSac.testResultatsPartiels(model.getEntreprises().size())) {
					if (nouveauSac.getCoutOptimal() < majorant || majorant == -1) {
						rechercheOptimale(nouveauSac, increment + 1);
						compteurBranches++;
					} else {
						compteurBranchesCoupees++;
						logs += " ---> BRANCHE";
					}
				} else {
					compteurBranches++;
					if (nouveauSac.getCoutOptimal() < majorant || majorant == -1) {
						majorant = nouveauSac.getCoutOptimal();
						compteurMajorants++;
						resultat = nouveauSac;
						logs += " ---> NOUVEAU MAJORANT : " + majorant;
					}
				}
			}
		}
	}
	
	public String afficherResultat() {
		String affichageResultat = "";
		affichageResultat += "Meilleur coût : " + resultat.getCoutOptimal() + "\n\n";
		affichageResultat += "Nombre de majorants : " + compteurMajorants + "\n";
		affichageResultat += "Nombre de branches : " + compteurBranches + "\n";
		affichageResultat += "Nombre de branches coupées : " + compteurBranchesCoupees + "\n\n";
		for (Entry<String, ArrayList<String>> entry : resultat.getResultatsPartiels().entrySet()) {
			affichageResultat += "\tBase" + entry.getKey() + "\n";
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