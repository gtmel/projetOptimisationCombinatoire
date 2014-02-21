package readers;

import java.util.ArrayList;

import projetOptimisationCombinatoire.Base;
import projetOptimisationCombinatoire.Entreprise;

public class Lecteur {
	
	private String prefixeCheminBases = "./bin/docs/bases/";
	
	private String cheminListeBases;
	private String cheminListeEntreprises;
	
	private LecteurBases lecteurBases;
	private LecteurEntreprises lecteurEntreprises;

	public Lecteur(String cheminListeBases, String cheminListeEntreprises) {
		this.cheminListeBases = cheminListeBases;
		this.cheminListeEntreprises = cheminListeEntreprises;
		this.lecteurBases = new LecteurBases();
		this.lecteurEntreprises = new LecteurEntreprises();
	}
	
	public ArrayList<Base> lireBases() {
		
		return null;
	}
	
	public ArrayList<Entreprise> lireEntreprises() {
		
		return null;
	}

}
