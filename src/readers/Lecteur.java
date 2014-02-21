package readers;

import java.util.ArrayList;

import projetOptimisationCombinatoire.Base;

public class Lecteur {
	
	private String prefixCheminBases = "./bin/docs/bases/";
	
	private LecteurBases lecteurBases;
	private LecteurEntreprises lecteurEntreprises;

	public Lecteur(String cheminListeBases, String cheminListeEntreprises) {
		this.lecteurBases = new LecteurBases(cheminListeBases, prefixCheminBases);
		this.lecteurEntreprises = new LecteurEntreprises(cheminListeEntreprises);
	}
	
	public ArrayList<Base> lireBases() {
		return lecteurBases.lire();
	}
	
	public ArrayList<String> lireEntreprises() {
		
		return lecteurEntreprises.lire();
	}

}
