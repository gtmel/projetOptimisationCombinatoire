package branchAndBound;

import java.util.ArrayList;
import java.util.HashMap;

import model.Base;
import model.Model;

public class AlgorithmeBranchAndBound {

	private Model model;
	private SacADos sacADos;

	public AlgorithmeBranchAndBound(Model model) {
		this.model = model;
		sacADos = new SacADos();
		SacADos sacResultat = rechercheOptimale(sacADos, 0, 0);
	}

	public SacADos rechercheOptimale(SacADos sacADos, int increment, int coutOptimal) {
		
		if (increment < model.getEntreprises().size()) {
			
			String nomEntreprise = model.getEntreprises().get(increment);

			// Pour chaque base contenant l'entreprise 
			for (Base base : model.getBases()) {

				if (base.getEntreprises().contains(nomEntreprise)) {
					
					System.out.println("********** INCREMENT : " + increment + " **********");
					System.out.println("---------- ENTREPRISE : " + nomEntreprise + " ----------");
					System.out.println("\n");
					System.out.println("BASE -> " + base.getNomBase());
					
					// et qui n'est pas dans la liste partielle
					if (!sacADos.getResultatsPartiels().containsKey(base.getNomBase())) {
						System.out.println("JE PASSE ICI");
						SacADos nouveauSac = new SacADos();
						nouveauSac.setResultatsPartiels((HashMap<String, ArrayList<String>>)sacADos.getResultatsPartiels().clone());
						ArrayList<String> nouvelleListeEntreprises = new ArrayList<String>();
						nouvelleListeEntreprises.add(nomEntreprise);
						nouveauSac.ajouterEntree(base.getNomBase(), nouvelleListeEntreprises);
						nouveauSac.setCoutOptimal(sacADos.getCoutOptimal() + base.getCoutBase());
						nouveauSac.afficher();
						if(sacADos.getCoutOptimal() <= coutOptimal && !sacADos.testResultatsPartiels(model.getEntreprises().size())){
							rechercheOptimale(nouveauSac, increment + 1, sacADos.getCoutOptimal());
						}

					} else {
						System.out.println("OU JE PASSE LA");
						SacADos nouveauSac = new SacADos();
						nouveauSac.setResultatsPartiels((HashMap<String, ArrayList<String>>)sacADos.getResultatsPartiels().clone());
						nouveauSac.ajouterEntreprise(base.getNomBase(), nomEntreprise);
						nouveauSac.setCoutOptimal(sacADos.getCoutOptimal());
						nouveauSac.afficher();
						if(sacADos.getCoutOptimal() <= coutOptimal && !sacADos.testResultatsPartiels(model.getEntreprises().size())){
							rechercheOptimale(nouveauSac, increment + 1, sacADos.getCoutOptimal());
						}
					}
				}
			}
		}

		return null;
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	public SacADos getSacADos() {
		return sacADos;
	}

	public void setSacADos(SacADos sacADos) {
		this.sacADos = sacADos;
	}

}