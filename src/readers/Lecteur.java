package readers;

import java.util.ArrayList;

import projetOptimisationCombinatoire.Base;
import projetOptimisationCombinatoire.Entreprise;

public class Lecteur {
	
	private String cheminBases;
	private String cheminEntreprises;
	
	private LecteurBases lecteurBases;
	private LecteurEntreprises lecteurEntreprises;

	Lecteur(String cheminBases, String cheminEntreprises) {
		this.cheminBases = cheminBases;
		this.cheminEntreprises = cheminEntreprises;
		this.lecteurBases = new LecteurBases();
		this.lecteurEntreprises = new LecteurEntreprises();
	}
	
	public ArrayList<Base> lireBases(String cheminBases) {
		
		return null;
	}
	
	public ArrayList<Entreprise> lireEntreprises(String cheminEntreprises) {
		
		return null;
	}

}
