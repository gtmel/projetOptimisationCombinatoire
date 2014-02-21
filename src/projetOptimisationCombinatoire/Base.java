package projetOptimisationCombinatoire;

import java.util.ArrayList;

public class Base {
	
	private String nomBase;
	private int coutBase;
	private ArrayList<String> nomEntreprises;
	
	Base() {
		
	}

	public String getNomBase() {
		return nomBase;
	}

	public void setNomBase(String nomBase) {
		this.nomBase = nomBase;
	}

	public int getCoutBase() {
		return coutBase;
	}

	public void setCoutBase(int coutBase) {
		this.coutBase = coutBase;
	}

	public ArrayList<String> getNomEntreprises() {
		return nomEntreprises;
	}

	public void setNomEntreprises(ArrayList<String> nomEntreprises) {
		this.nomEntreprises = nomEntreprises;
	}
	
}
